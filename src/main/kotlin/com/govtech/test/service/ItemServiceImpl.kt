package com.govtech.test.service

import com.govtech.test.models.Item
import com.govtech.test.repository.ItemRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class ItemServiceImpl(private val itemRepository: ItemRepository) : ItemService {

    override fun findPaginated(pageNo: Int, pageSize: Int): Page<Item> {
        val pageable: Pageable = PageRequest.of(pageNo - 1, pageSize)
        return this.itemRepository?.findAll(pageable)
    }

//    override fun findByName(stockCode: String?): List<Item> {
//         return itemRepository.findByNameLike(stockCode);
//    }

//    override fun findByName(description: String?): List<Item> {
//        return this.itemRepository?.findByNameLike(name);
//    }


//    override fun getAllItems(): List<Item?>? {
//        return itemRepository?.findAll()
//    }

//    override fun findPaginated(
//        pageNo: Int,
//        pageSize: Int,
//
//        sortField: String?,
//        sortDirection: String
//    ): Page<Item>? {
//        val sort = if (sortDirection.equals(Sort.Direction.ASC.name, ignoreCase = true)) Sort.by(sortField)
//            .ascending() else Sort.by(sortField).descending()
//        val pageable: Pageable = PageRequest.of(pageNo - 1, pageSize, sort)
//        return this.itemRepository?.findAll(pageable)
//    }

//    override fun findAll(pageable: Pageable): Page<ItemResponse> = this.itemDao.findAll(pageable).map(Item::toItemResponse)

//    override fun findPaginated(pageNo: Int, pageSize: Int): Page<Item?>? {
//        Pageable pageable = PageRequest.of (pageNo - 1, pageSize)
//        return itemRepository.findAll(pageable)
//    }

//    override fun findAll(pageable: Pageable): Page<ItemResponse> = this.itemRepository.findAll(pageable).map(Item::toItemResponse)


}
