package com.iambenkay.paymentcoinbase.controllers

import com.iambenkay.paymentcoinbase.services.CallbackService
import com.iambenkay.paymentcoinbase.types.EventData
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("events")
class WebhookController @Autowired constructor(
    val callbackService: CallbackService

    ) {
    @CrossOrigin
    @PostMapping
    fun transactionEvent(@RequestBody body: EventData): ResponseEntity<Unit> {
        print(body.event.data)
        val ok = callbackService.proxyToReceiver(body)
        return if(ok){
            ResponseEntity.ok().build()
        } else {
            ResponseEntity.badRequest().build()
        }
    }
}
