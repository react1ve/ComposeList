package com.reactive.composelist.data.repository

import com.reactive.composelist.data.model.Data

interface ItemRepository {
    fun getItems() : List<Data>
}
