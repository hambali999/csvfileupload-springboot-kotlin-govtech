package com.govtech.test.repository

import com.govtech.test.models.Item
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ItemRepository:  JpaRepository<Item, Long>{

//      fun findByNameLike(stockCode: String?): List<Item>

//    fun findByItemPackageCode(@Param("code") code: String?, pageable: Pageable?): Page<Item?>?

}


//using JpaRepo for pagination PagingAndSortingRepository