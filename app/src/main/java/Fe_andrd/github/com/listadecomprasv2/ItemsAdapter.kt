package Fe_andrd.github.com.listadecomprasv2

import Fe_andrd.github.com.listadecomprasv2.ItemModel.ItemModel
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 * Classe ItemsAdapter que estende RecyclerView.Adapter.
 * Esta classe é responsável por fornecer a visualização dos itens na lista e manipular os eventos de clique.
 * Utiliza o padrão ViewHolder para melhorar o desempenho ao reutilizar as visualizações dos itens.
 *
 * @author Fernanda Botareli
 * @version 1.0
 * @since 14/08/2024
 *
 */
class ItemsAdapter : RecyclerView.Adapter<ItemsAdapter.ItemViewHolder>() {

    private var items = listOf<ItemModel>()

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val textView = view.findViewById<TextView>(R.id.textViewItem)

        val button = view.findViewById<ImageButton>(R.id.imageButton)

        fun bind(item: ItemModel) {
            textView.text = item.name
            button.setOnClickListener {
                item.onRemove(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    fun updateItems(newItems: List<ItemModel>) {
        items = newItems
        notifyDataSetChanged()
    }
}