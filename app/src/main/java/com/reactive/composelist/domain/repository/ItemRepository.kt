package com.reactive.composelist.domain.repository

import com.reactive.composelist.data.model.Data
import com.reactive.composelist.data.repository.ItemRepository

class ItemRepositoryImpl : ItemRepository {
    override fun getItems(): List<Data> {
        return List(1000) { index ->
            Data(
                id = index,
                description = "Item $index",
                imageUrl = "https://picsum.photos/id/$index/300/300"
            )
        }
    }
}
