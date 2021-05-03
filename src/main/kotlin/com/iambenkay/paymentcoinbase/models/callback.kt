package com.iambenkay.paymentcoinbase.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.repository.MongoRepository

@Document
data class Callback(
    @Id
    val id: String,
    val callback: String
)

interface CallbackRepository: MongoRepository<Callback, String>