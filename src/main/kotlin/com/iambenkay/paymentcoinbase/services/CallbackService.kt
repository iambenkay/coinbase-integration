package com.iambenkay.paymentcoinbase.services

import com.iambenkay.paymentcoinbase.models.Callback
import com.iambenkay.paymentcoinbase.models.CallbackRepository
import com.iambenkay.paymentcoinbase.types.EventData
import com.iambenkay.paymentcoinbase.utils.generateTimedHttpRequestClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import java.util.*

@Service
class CallbackService @Autowired constructor(val callbackRepository: CallbackRepository) {
    private val client: RestTemplate

    init {
        val headers = HttpHeaders()
        this.client = generateTimedHttpRequestClient(20000, headers)
    }

    fun createCallback(callback: Callback): Callback {
        return callbackRepository.save(callback)
    }

    fun findCallbackById(id: String): Optional<Callback> {
        return callbackRepository.findById(id)
    }

    fun proxyToReceiver(body: EventData): Boolean {
        val cb = findCallbackById(body.event.data["id"] as String)

        if(cb.isPresent) {
            val resp = client.postForEntity(cb.get().callback, body, Unit::class.java)
            return resp.statusCode.is2xxSuccessful
        }
        return false;
    }
}