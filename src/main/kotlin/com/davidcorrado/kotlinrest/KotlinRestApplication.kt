package com.davidcorrado.kotlinrest

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class KotlinRestApplication

fun main(args: Array<String>) {
    System.getProperties()["server.port"] = 8081
    SpringApplication.run(KotlinRestApplication::class.java, *args)
}
