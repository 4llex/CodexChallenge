package com.codexchallenge.service

import com.codexchallenge.model.CNPJ
import org.springframework.stereotype.Service

@Service
class CnpjService {

    fun helloWorld(): String {
        return "Hello cruel world from my application"
    }

    fun getValidateCnpj(cnpj: String): String {
        return "cnpj from url get: $cnpj"
    }

    fun validateCnpj(cnpj: CNPJ): CNPJ {
        cnpj.isValid = true
        return cnpj
    }

}