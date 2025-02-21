package com.example.fetchrewards.viewModel


import android.content.ClipData.Item
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fetchrewards.data.model.ItemModel
import com.example.fetchrewards.data.remote.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

private val TAG = "FetchItemViewModel"

@HiltViewModel
class FetchViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    var state by mutableStateOf(ScreenState())

    init {
        viewModelScope.launch {
            val response = repository.getFetchItem()

            if (response.isSuccessful){
                val lista = response.body()!!
                val filterList = lista.filter { it.name != null && !it.name.equals("") }
                val sortedList = filterList.sortedWith(compareBy({it.listId}, {it.id}))

                val itemMap: HashMap<Int, ItemModel> = lista.associateBy({ it.id }) as HashMap<Int, ItemModel>

                val categories = filterList.groupBy { it.listId }.size
                state = state.copy(
                    items = sortedList,
                    count = categories,
                    detailData = itemMap
                )
            } else {
                Log.e(TAG, "Error fetching: ${response.message()}")
            }
        }
    }
}

data class ScreenState(

    val items : List<ItemModel> = emptyList(),
    val count: Int = 0,
    val page: Int = 1,
    val detailData : Map<Int, ItemModel> = emptyMap()
)