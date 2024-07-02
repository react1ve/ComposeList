package com.reactive.composelist.domain.usecase

import com.reactive.composelist.data.model.Data
import com.reactive.composelist.data.repository.ItemRepository

class GetItemsUseCase(private val repository : ItemRepository) {
    fun execute() : List<Data> {
        return repository.getItems()
    }
}
