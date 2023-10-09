package com.codexchallenge.controller

import com.codexchallenge.controller.requestcnpj.PostCnpjRequest
import com.codexchallenge.extension.toCnpjModel
import com.codexchallenge.model.CnpjModel
import com.codexchallenge.service.CnpjService
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
class CnpjController (
        val cnpjService: CnpjService
) {

    @GetMapping
    fun helloWorld(): String {
        return cnpjService.helloWorld()
    }

    @GetMapping("/{cnpj}")
    fun getValidateCnpj(@PathVariable cnpj: String): String {
        return cnpjService.getValidateCnpj(cnpj)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK) //TODO: check status response
    fun validateCnpj(@RequestBody cnpj: PostCnpjRequest): CnpjModel {
        return cnpjService.validateCnpj(cnpj.toCnpjModel())
    }

}
