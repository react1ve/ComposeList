package com.reactive.composelist.presentation.screens.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.reactive.composelist.data.model.Data
import com.reactive.composelist.domain.usecase.GetItemsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ItemViewModel(private val getItemsUseCase: GetItemsUseCase) : ViewModel() {

    private val _items = MutableStateFlow<List<Data>>(emptyList())
    val items: StateFlow<List<Data>> get() = _items

    init {
        viewModelScope.launch {
            _items.value = getItemsUseCase.execute()
        }
    }
}
