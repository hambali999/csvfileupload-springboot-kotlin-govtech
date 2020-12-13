package com.govtech.test.controller

import com.govtech.test.models.Item
import com.govtech.test.service.ItemService
import com.opencsv.bean.CsvToBean
import com.opencsv.bean.CsvToBeanBuilder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.multipart.MultipartFile
import java.io.BufferedReader
import java.io.InputStreamReader


@Controller
class UploadController {

    @Autowired
    private val itemService: ItemService? = null

    @GetMapping("/")
    fun index(): String {
        return "index"
    }

    @PostMapping("/display-data")
    fun uploadCSVFile(@RequestParam("file") file: MultipartFile, model: Model): String? {

        // validate file
        if (file.isEmpty) {
            model.addAttribute("message", "Please select a CSV file to upload.")
            model.addAttribute("status", false)
        } else {

            var fileReader: BufferedReader? = null
            // parse CSV file to create a list of `Item` objects
            try {
                fileReader = BufferedReader(InputStreamReader(file.inputStream)) //read the content of the csv file.

                // create csv bean reader
                val csvToBean: CsvToBean<Item?> = CsvToBeanBuilder<Item>(fileReader)
                    .withType(Item::class.java)
                    // .withSkipLines(1) //to skip line(1)? since first line of csv contains header.
                    .withIgnoreLeadingWhiteSpace(true)
                    .build()

                // convert `CsvToBean` object to list of items
                val items: List<Item?> = csvToBean.parse()
                // return csvToBean.parse()   Should we add this?

                // save items list on model
                model.addAttribute("items", items)
                model.addAttribute("status", true)

            } catch (ex: Exception) {
                model.addAttribute("message", "An error occurred while processing the CSV file.")
                model.addAttribute("status", false)
            }
        }
        return findPaginated(1, model)
    }

    @GetMapping("/page/{pageNo}")
    fun findPaginated(@PathVariable(value = "pageNo") pageNo: Int, model: Model): String {
        val pageSize = 5
        val page: Page<Item> = itemService?.findPaginated(pageNo, pageSize)!!
        val listItem: List<Item?> = page.content
        model.addAttribute("currentPage", pageNo)
        model.addAttribute("totalPages", page.totalPages)
        model.addAttribute("totalItems", page.totalElements)
        model.addAttribute("listItems", listItem)
        return "display-data"
    }

//this is the mapping to search for items actually..
//    @GetMapping("/items")
//    fun listItems(@RequestParam(defaultValue = "") stockCode: String?, model: Model): String? {
//        model.addAttribute("items", itemService?.findByName(stockCode))
//        return "display-data"
//    }


//    display list of items
//    @GetMapping("/display-data")
//    fun viewHomePage(model: Model?): String? {
//        return findPaginated(1, model!!)
//    }

//    @GetMapping("/page/{pageNo}")
//    fun findPaginated(@PathVariable(value = "pageNo") pageNo: Int, model: Model): String {
//        val pageSize = 5
//        val page: Page<Item> = itemService!!.findPaginated(pageNo, pageSize)
//        val listEmployees: List<Item> = page.getContent()
//        model.addAttribute("currentPage", pageNo)
//        model.addAttribute("totalPages", page.getTotalPages())
//        model.addAttribute("totalItems", page.getTotalElements())
//        model.addAttribute("listEmployees", listEmployees)
//        return "display-data"
//    }

//    @GetMapping("/page/{pageNo}")
//    fun findPaginated(@PathVariable(value = "pageNo") pageNo: Int, model: Model): String? {
//        val pageSize = 5
//        val page: Page<Item> = itemService.findPaginated(pageNo, pageSize)
//        val listEmployees: List<Item> = page.getContent()
//        model.addAttribute("currentPage", pageNo)
//        model.addAttribute("totalPages", page.getTotalPages())
//        model.addAttribute("totalItems", page.getTotalElements())
//        model.addAttribute("listEmployees", listEmployees)
//        return "index"
//    }

//    @GetMapping("/display-data")
//    fun getItems(pageable: Pageable?, model: Model): String? {
//        val results: Page<Item> = itemRepository.findAll(pageable)
//        model.addAttribute("results", results)
//        return "/display-data"
//    }

//    @RequestMapping("/test", method = RequestMethod.GET)
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public Page<Item> fetchByPage(Pageable page){
//        return this.ItemService
//    }

//    @GetMapping("/display-data")
//    fun showPage(model: Model, @RequestParam(defaultValue = "0")) {
//        model.addAttribute(
//            "data", itemRepo.findAll(new PageRequest (page, 4)
//        ));
//        return "index";
//    }

//    @GetMapping("/page/{pageNo}")
//    fun findPaginated(
//        @PathVariable(value = "pageNo") pageNo: Int,
//        model: Model
//    ): String? {
//        val pageSize = 5
//        val page: Page<Item> = ItemService.findPaginated(pageNo, pageSize)
//        val listEmployees: List<Item> = page.getContent()
//        model.addAttribute("currentPage", pageNo)
//        model.addAttribute("totalPages", page.getTotalPages())
//        model.addAttribute("totalItems", page.getTotalElements())
//        model.addAttribute("listEmployees", listEmployees)
//        return "index"
//    }


}
