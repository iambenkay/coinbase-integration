package com.iambenkay.paymentcoinbase.controllers

import com.iambenkay.paymentcoinbase.CreateInvoiceRequest
import com.iambenkay.paymentcoinbase.models.Callback
import com.iambenkay.paymentcoinbase.services.CallbackService
import com.iambenkay.paymentcoinbase.services.CoinbaseService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("transactions")
class InvoiceController @Autowired constructor(
    val coinbaseService: CoinbaseService,
    val callbackService: CallbackService,
    ) {
    @CrossOrigin
    @PostMapping
    fun createTransaction(@RequestBody request: CreateInvoiceRequest, @RequestParam("callback") cb: String): ResponseEntity<Unit> {
        val response = coinbaseService.createInvoice(request)
        callbackService.createCallback(Callback(response.data.id, cb))
        return ResponseEntity.ok().build()
    }
}