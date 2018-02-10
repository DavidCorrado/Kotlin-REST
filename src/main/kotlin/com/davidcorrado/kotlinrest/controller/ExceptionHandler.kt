package com.davidcorrado.kotlinrest.controller

import com.davidcorrado.kotlinrest.data.MessageResponse
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.client.HttpClientErrorException
import org.springframework.web.context.request.WebRequest




@ControllerAdvice
internal class ExceptionHandler {
    @ExceptionHandler(HttpClientErrorException::class)
    fun handleHTTPExceptions(httpClientErrorException: HttpClientErrorException, request: WebRequest): ResponseEntity<MessageResponse> {
        return ResponseEntity(MessageResponse(httpClientErrorException.statusText ?: "Unknown server error."), httpClientErrorException.statusCode)
    }
}