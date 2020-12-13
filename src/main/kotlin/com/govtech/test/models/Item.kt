package com.govtech.test.models

import com.opencsv.bean.CsvBindByName
import com.opencsv.bean.CsvBindByPosition
import javax.persistence.Entity
import javax.persistence.Id


@Entity
data class Item(

    @Id
    @CsvBindByName(column = "InvoiceNo")
    var invoiceNo: Long? = null,
    @CsvBindByName(column = "StockCode")
    var stockCode: String? = null,
    @CsvBindByName(column = "Description")
    var description: String? = null,
    @CsvBindByName(column = "Quantity")
    var quantity: Int? = null,
    @CsvBindByName(column = "InvoiceDate")
    var invoiceDate: String? = null,
    @CsvBindByName(column = "UnitPrice")
    var unitPrice: Float? = null,
    @CsvBindByName(column = "CustomerID")
    var customerID: Int? = null,
    @CsvBindByName(column = "Country")
    var country: String? = null

)

//this is another way to bound the data, can delete if u want..
data class UserWithCsvBindByPosition(
    @CsvBindByPosition(position = 0)
    var invoiceNo: Long? = null,
    @CsvBindByPosition(position = 1)
    var stockCode: String? = null,
    @CsvBindByPosition(position = 2)
    var description: String? = null,
    @CsvBindByPosition(position = 3)
    var quantity: Int? = null,
    @CsvBindByPosition(position = 4)
    var invoiceDate: String? = null,
    @CsvBindByPosition(position = 6)
    var unitPrice: Float? = null,
    @CsvBindByPosition(position = 7)
    var customerID: Int? = null,
    @CsvBindByPosition(position = 8)
    var country: String? = null
)




