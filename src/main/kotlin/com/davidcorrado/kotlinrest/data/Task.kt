package com.davidcorrado.kotlinrest.data

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Task() {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Int? = 0
    lateinit var name: String
    lateinit var detail: String

    constructor(name: String, detail: String) : this() {
        this.name = name
        this.detail = detail
    }
}