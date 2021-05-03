package com.iambenkay.paymentcoinbase.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration

@Configuration
class Properties {
    @Value("\${services.coinbase.endpoint}")
    lateinit var coinBaseUri: String

    @Value("\${services.coinbase.api-key}")
    lateinit var coinBaseKey: String
}