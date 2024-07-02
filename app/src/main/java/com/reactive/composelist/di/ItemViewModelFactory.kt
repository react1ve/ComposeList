package com.reactive.composelist.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.reactive.composelist.domain.usecase.GetItemsUseCase
import com.reactive.composelist.presentation.screens.list.ItemViewModel

class ItemViewModelFactory(private val getItemsUseCase : GetItemsUseCase):
    ViewModelProvider.Factory {
    override fun <T: ViewModel> create(modelClass : Class<T>) : T {
        if (modelClass.isAssignableFrom(ItemViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ItemViewModel(getItemsUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
