package Fe_andrd.github.com.listadecomprasv2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView

/**
 * MainActivity é uma classe que estende AppCompatActivity.
 * Esta classe é responsável por inicializar a interface do usuário e manipular eventos de interação do usuário.
 * A interface do usuário é definida no arquivo de layout `activity_main.xml`.
 *
 * @author Fernanda Botareli
 * @version 1.0
 * @since 14/08/2024
 */

class MainActivity : AppCompatActivity() {

    val viewModel: ItemsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Lista de Compras"

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val itemsAdapter = ItemsAdapter()
        recyclerView.adapter = itemsAdapter

        val button = findViewById<Button>(R.id.button)
        val editText = findViewById<EditText>(R.id.editText)

        button.setOnClickListener {
            if (editText.text.isEmpty()) {
                editText.error = "Preencha um valor"
                return@setOnClickListener
            }

            viewModel.addItem(editText.text.toString())
            editText.text.clear()

            viewModel.itemsLiveData.observe(this) {
                    items -> itemsAdapter.updateItems(items)
            }

        }

    }
}