package com.davidcorrado.kotlinrest

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class KotlinRestApplication

fun main(args: Array<String>) {
    SpringApplication.run(KotlinRestApplication::class.java, *args)
}
