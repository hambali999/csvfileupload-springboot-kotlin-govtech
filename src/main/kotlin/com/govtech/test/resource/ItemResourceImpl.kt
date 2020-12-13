//package com.govtech.test.resource
//
//import com.govtech.test.dto.ItemResponse
//import com.govtech.test.service.ItemService
//import org.springframework.data.domain.Page
//import org.springframework.data.domain.Pageable
//import org.springframework.http.ResponseEntity
//import org.springframework.web.bind.annotation.GetMapping
//import org.springframework.web.bind.annotation.RequestMapping
//import org.springframework.web.bind.annotation.RestController
//
//@RestController
//@RequestMapping("/display-data")
//class ItemResourceImpl(private val itemService: ItemService) : ItemResource {
//
//    @GetMapping
//    override fun findAll(pageable: Pageable): ResponseEntity<Page<ItemResponse>> {
//        return ResponseEntity.ok(this.itemService.findAll(pageable))
//    }
//}
//
//
