package com.codexchallenge.extension

import com.codexchallenge.controller.requestcnpj.PostCnpjRequest
import com.codexchallenge.model.CNPJ

fun PostCnpjRequest.toCnpjModel(): CNPJ {
    return CNPJ(cnpj = this.cnpj, isValid = false)
}