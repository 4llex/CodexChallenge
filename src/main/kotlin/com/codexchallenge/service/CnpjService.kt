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
        cnpj.isValid = checkCnpj(cnpj.cnpj)
        return cnpj
    }


    fun checkCnpj(cnpj: String) : Boolean {

        println("Is CNPJ  $cnpj")
        val isValid1 = myValidationCnpj(cnpj)
        println("Is CNPJ valid? $isValid1 \n")

        return isValid1
    }

    fun myValidationCnpj(cnpj: String): Boolean{

        // Remove formatting characters getting only numbers
        val cleanedCnpj: String = cnpj.replace(Regex("[^0-9]"), "")
        println("===55==--> $cleanedCnpj")

        // Check if the length is correct (14 characters)
        if (cleanedCnpj.length != 14) {
            return false//TODO: generate an exception
        } else {
            println("===55==--> ${cleanedCnpj.length}")
        }

        //Get previous D1,D2
        val pD1: Int = Character.getNumericValue(cleanedCnpj[12])
        val pD2: Int = Character.getNumericValue(cleanedCnpj[13])

        println("===cleanedCnpj==--> ${cleanedCnpj.toList()}")

        val subCnpj = cleanedCnpj.substring(0, 12)
        println("===subCnpj==-->     ${subCnpj.toList()}")
        val fator1: List<Int> = listOf(5,4,3,2,9,8,7,6,5,4,3,2)
        val fator2: List<Int> = listOf(6,5,4,3,2,9,8,7,6,5,4,3,2)

        // Calculate the first check digit, D1
        var sum1 = 0
        for (i in 0 until 12) {
            val n = Character.getNumericValue(subCnpj[i])
            val f = fator1[i]
            sum1 += n * f
            println(" $n * $f")
        }
        var d1 = sum1 % 11
        d1 = if (d1<2) 0 else 11-d1 //Digit 1 rule


        // Calculate the second check digit, D2
        val cnpjAddedD1 = subCnpj.plus(d1)
        println("=== cnpj+d1 ==--> ${cnpjAddedD1.toList()}")
        sum1 = 0
        for (i in 0 until 13) {
            val n = Character.getNumericValue(cnpjAddedD1[i])
            val f = fator2[i]
            sum1 += n * f
            println(" $n * $f")
        }
        var d2 = sum1 % 11
        d2 = if (d2 < 2) 0 else 11 - d2 //Digit 1 rule

        return pD1 == d1 && pD2 == d2
    }


}