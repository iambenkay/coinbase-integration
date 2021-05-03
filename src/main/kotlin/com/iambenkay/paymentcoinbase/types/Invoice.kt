package com.iambenkay.paymentcoinbase

import com.iambenkay.paymentcoinbase.types.Currency
import java.time.LocalDateTime

data class Invoice(
    val id: String,
    val business_name: String,
    val customer_email: String,
    val customer_name: String,
    val local_price: Money,
    val memo: String?,
    val code: String,
    val created_at: LocalDateTime,
    val status: String,
    val resource: String,
    val updated_at: LocalDateTime,
    val hosted_url: String,
)

data class CreateInvoiceRequest(
    val business_name: String,
    val customer_email: String,
    val customer_name: String,
    val local_price: Money,
    var memo: String,
)

data class Money(
    val amount: String,
    val currency: Currency
)

