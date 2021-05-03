package com.iambenkay.paymentcoinbase.types

import com.iambenkay.paymentcoinbase.Invoice

open class CBResponse<T>(
    val data: T,
    val warnings: List<String>?,
)

class CBCreateInvoiceResponse(
    data: Invoice,
    warnings: List<String>?
): CBResponse<Invoice>(data, warnings)

data class EventData(
    val attempt_number: Int,
    val event: Event,
    val id: String,
    val scheduled_for: String
)

data class Event(
    val api_version: String,
    val created_at: String,
    val data: HashMap<String, Any>,
    val id: String,
    val resource: String,
    val type: String
)
