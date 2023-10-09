package com.codexchallenge.service

import com.codexchallenge.model.CnpjModel
import org.springframework.stereotype.Service

@Service
class CnpjService {

    fun helloWorld(): String {
        return "Hello cruel world from my application"
    }

    fun getValidateCnpj(cnpj: String): String {
        return "cnpj from url get: $cnpj"
    }

    fun validateCnpj(cnpjModel: CnpjModel): CnpjModel {
        cnpjModel.isValid = validateCnpj(cnpjModel.cnpj)
        return cnpjModel
    }

}

fun validateCnpj(cnpj: String): Boolean {

    // Remove formatting characters getting only numbers
    val cleanedCnpj: String = cnpj.replace(Regex("[^0-9]"), "")

    // Check if the length is correct (14 characters)
    if (cleanedCnpj.length != 14) {
        return false
    }

    val subCnpj = cleanedCnpj.substring(0, 12)
    val multiplierForD1: List<Int> = listOf(5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2)
    val multiplierForD2: List<Int> = listOf(6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2)

    // Calculate the first check digit, D1
    var sum = 0
    for (i in 0 until 12) {
        sum += Character.getNumericValue(subCnpj[i]) * multiplierForD1[i]
    }
    var d1 = sum % 11
    d1 = if (d1 < 2) 0 else 11 - d1 //Digit 1 rule check


    // Calculate the second check digit, D2
    val subCnpjAddedD1 = subCnpj.plus(d1)
    sum = 0
    for (i in 0 until 13) {
        sum += Character.getNumericValue(subCnpjAddedD1[i]) * multiplierForD2[i]
    }
    var d2 = sum % 11
    d2 = if (d2 < 2) 0 else 11 - d2 //Digit 2 rule check

    return d1 == Character.getNumericValue(cleanedCnpj[12])
            && d2 == Character.getNumericValue(cleanedCnpj[13])
}