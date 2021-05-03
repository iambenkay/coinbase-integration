package com.iambenkay.paymentcoinbase.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.stereotype.Service

@Service
class EmailService @Autowired constructor(val mailSender: JavaMailSender) {
    fun sendMail(to: String, subject: String, text: String){
        val message = SimpleMailMessage()
        message.setFrom("benjamin@varscongroup.com")
        message.setTo(to)
        message.setSubject(subject)
        message.setText(text)
        mailSender.send(message)
    }
}