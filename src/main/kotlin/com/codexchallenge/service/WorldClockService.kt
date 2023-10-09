package com.codexchallenge.service

import com.codexchallenge.model.WorldClockResponseModel
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Service
class WorldClockService {

    @GetMapping
    fun getWorldClock(): WorldClockResponseModel {
        //Define the target format as requested
        val targetFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm'Z'")
        //Format current LocalDateTime into the target format "2023-10-09T10:12Z"
        val formattedDateTime = LocalDateTime.now().format(targetFormat)

        return WorldClockResponseModel(formattedDateTime.toString())
    }

    fun test(): WorldClockResponseModel {
        val currentDateTime = LocalDateTime.now().toString()
        println(currentDateTime)

        // Parse the input string into a LocalDateTime          "2023-10-09T10:14:20.239505600"
        val inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSSSSS")
        val sourceDateTime = LocalDateTime.parse(currentDateTime, inputFormatter)
        println(sourceDateTime)

        // Format the LocalDateTime into the target format       "2023-10-09T10:12Z"
        val targetFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm'Z'")
        val formattedDateTime = sourceDateTime.format(targetFormatter)

        //val response = DateTimeResponse(currentDateTime)
        return WorldClockResponseModel(formattedDateTime)
    }

}