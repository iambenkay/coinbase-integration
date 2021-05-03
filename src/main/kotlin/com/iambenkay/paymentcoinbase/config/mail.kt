package com.iambenkay.paymentcoinbase.config

import org.springframework.context.annotation.Bean
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.JavaMailSenderImpl
import org.springframework.stereotype.Component

@Component
class Mail {

    @Bean
    fun javaMailSender(): JavaMailSender {
        val mailSender = JavaMailSenderImpl()
        mailSender.host = System.getenv("EMAIL_HOST")
        mailSender.port = System.getenv("EMAIL_PORT").toInt()
        mailSender.username = System.getenv("EMAIL_USER")
        mailSender.password = System.getenv("EMAIL_PASS")
        val props = mailSender.javaMailProperties
        props["mail.transport.protocol"] = "smtp"
        props["mail.smtp.auth"] = "true"
        props["mail.smtp.starttls.enable"] = "true"
        props["mail.debug"] = "true"
        props["mail.smtp.connectiontimeout"] = 5000
        props["mail.smtp.timeout"] = 3000
        props["mail.smtp.writetimeout"] = 5000

        return mailSender
    }
}