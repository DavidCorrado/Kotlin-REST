package com.davidcorrado.kotlinrest

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.concurrent.atomic.AtomicLong

@RestController
@RequestMapping( "/account")
class AccountController {

    val counter = AtomicLong()
    @ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "Please check your username or password.")
    class LoginUnauthorizedException: RuntimeException() {}

    @PostMapping("/login")
    fun greeting(@RequestBody loginRequest: LoginRequest): MessageResponse{
        if(loginRequest.email == "success@gmail.com"){
            return MessageResponse("Successful Login")
        } else {
            throw LoginUnauthorizedException()
        }
    }
}