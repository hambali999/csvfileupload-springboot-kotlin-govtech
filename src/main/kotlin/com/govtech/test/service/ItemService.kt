package com.govtech.test.service

import com.govtech.test.models.Item
import org.springframework.data.domain.Page


interface ItemService {

//    fun getAllItems(): List<Item?>?
//
//    fun findPaginated(pageNo: Int, pageSize: Int, sortField: String?, sortDirection: String): Page<Item>?
//
//    fun findAll(pageable: Pageable): Page<ItemResponse>

//      fun findPaginated(pageNo: Int, pageSize: Int): Page<Item?>?

//      fun findAll(pageable: Pageable): Page<ItemResponse>

         fun findPaginated(pageNo: Int, pageSize: Int): Page<Item>

//         fun findByName(stockCode: String?): List<Item>
}
