package com.iambenkay.paymentcoinbase.services

import com.iambenkay.paymentcoinbase.CreateInvoiceRequest
import com.iambenkay.paymentcoinbase.config.Properties
import com.iambenkay.paymentcoinbase.types.CBCreateInvoiceResponse
import com.iambenkay.paymentcoinbase.utils.generateTimedHttpRequestClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import java.net.URI

@Service
class CoinbaseService @Autowired constructor(props: Properties) {

    private val serviceEndpoint: String = props.coinBaseUri
    private val client: RestTemplate

    init {
        val headers = HttpHeaders()
        headers.add("X-CC-Api-Key", props.coinBaseKey)
        headers.add("X-CC-Version", "2018-03-22")
        this.client = generateTimedHttpRequestClient(10000, headers)
    }

    private fun resource(uri: String): URI {
        return URI.create("$serviceEndpoint/$uri")
    }

    fun createInvoice(createInvoice: CreateInvoiceRequest): CBCreateInvoiceResponse {
        val resp = client.postForEntity(resource("invoices"), createInvoice, CBCreateInvoiceResponse::class.java)
        return resp.body!!
    }
}