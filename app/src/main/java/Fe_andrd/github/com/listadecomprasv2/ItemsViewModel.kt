package Fe_andrd.github.com.listadecomprasv2

import Fe_andrd.github.com.listadecomprasv2.ItemModel.ItemModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/** ItemsViewModel é uma classe que estende ViewModel.
 * Esta classe gerencia uma lista de ItemModel. Ela contém métodos para adicionar e remover itens da lista.
 * A lista de itens é exposta através de um LiveData.
 * @property items Uma lista mutável de ItemModel. Esta lista é privada e só pode ser modificada através dos métodos addItem e removeItem.
 * @property itemsLiveData Um MutableLiveData que contém a lista de itens. Este LiveData é público e pode ser observado para receber atualizações quando a lista de itens é modificada.
 * @author Fernanda Botareli
 * @version 1.0
 * @since 14/08/2024 */
class ItemsViewModel : ViewModel() {

    private var items = mutableListOf<ItemModel>()

    val itemsLiveData = MutableLiveData<List<ItemModel>>()

    fun addItem(name: String) {

        val item = ItemModel(
            id = 0,
            name = name,
            onRemove = ::removeItem
        )

        if (!items.contains(item)) {
            items.add(item)
            itemsLiveData.value = items
        }
    }

    private fun removeItem(item: ItemModel) {
        items.remove(item)
        itemsLiveData.value = items
    }
}