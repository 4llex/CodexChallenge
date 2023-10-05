package com.codexchallenge.controller

import com.codexchallenge.controller.requestcnpj.PostCnpjRequest
import com.codexchallenge.model.CNPJ
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("validate_cnpj")
class CnpjController {

    @GetMapping
    fun helloWorl(): String {
        return "Hello cruel world from my application"
    }

    @GetMapping("/{cnpj}")
    fun getvalidateCnpj(@PathVariable cnpj: String): String {
        return "cnpj from url get: $cnpj"
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK) //TODO: check status response
    fun validateCnpj(@RequestBody postCnpjRequest: PostCnpjRequest): CNPJ {
        return CNPJ(postCnpjRequest.cnpj , false)
    }

}
