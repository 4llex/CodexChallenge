package com.codexchallenge.service

import com.codexchallenge.model.ClockApiResponse
import com.codexchallenge.model.FullResponseModel
import com.codexchallenge.model.WorldClockClientResponseModel
import com.codexchallenge.model.WorldClockServerResponseModel
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import org.springframework.web.reactive.function.client.WebClient
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

private val json = Json { ignoreUnknownKeys = true }

@Service
class WorldClockService {

    private val restTemplate = RestTemplate()
    private val webClient = WebClient.create()

    fun getWorldClockServer(): WorldClockServerResponseModel {
        //Define the target format as requested
        val targetFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm'Z'")
        //Format current LocalDateTime into the target format "2023-10-09T10:12Z"
        val formattedDateTime = LocalDateTime.now().format(targetFormat)

        return WorldClockServerResponseModel(formattedDateTime.toString())
    }

    fun getWorldClockClient(): WorldClockClientResponseModel {
        val url = "http://worldclockapi.com/api/json/utc/now"
        val response: ResponseEntity<ClockApiResponse> = restTemplate.getForEntity(url, ClockApiResponse::class.java)

        if (response.statusCode.is2xxSuccessful) {
            if (response.body != null) {
                return WorldClockClientResponseModel(
                        response.body!!.currentDateTime,
                        "utcOffset: ${response.body!!.utcOffset}")
            } else {
                throw IllegalStateException("Empty response body")
            }
        } else {
            throw IllegalStateException("Failed to fetch user data")
        }

    }



    //TODO: Below methods was created for tests
    fun getWorldClockClient2(): WorldClockClientResponseModel {
        val url = "http://worldtimeapi.org/api/timezone/America/Sao_Paulo"
        val response: ResponseEntity<FullResponseModel> = restTemplate.getForEntity(url, FullResponseModel::class.java)
        val str: String = "{\"abbreviation\":\"-03\",\"client_ip\":\"170.233.62.132\",\"datetime\":\"2023-10-09T13:17:04.333560-03:00\",\"day_of_week\":1,\"day_of_year\":282,\"dst\":false,\"dst_from\":null,\"dst_offset\":0,\"dst_until\":null,\"raw_offset\":-10800,\"timezone\":\"America/Sao_Paulo\",\"unixtime\":1696868224,\"utc_datetime\":\"2023-10-09T16:17:04.333560+00:00\",\"utc_offset\":\"-03:00\",\"week_number\":41}"

        if (response.statusCode.is2xxSuccessful) {
            if (response.body != null) {
                return WorldClockClientResponseModel(
                        response.body!!.datetime,
                        response.body!!.utcDatetime)
            } else {
                throw IllegalStateException("Empty response body")
            }
        } else {
            throw IllegalStateException("Failed to fetch user data")
        }
    }

    fun getWorldClockClient3(): WorldClockClientResponseModel {
        val url = "http://worldtimeapi.org/api/timezone/America/Sao_Paulo"

        //This approach take too long to get the response!!!
        val response = webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(String::class.java)
                .block()

        // Process the response as needed
        println("=> $response")

        val responseParsed: WorldClockClientResponseModel? = try {
            Json{ ignoreUnknownKeys = true}.decodeFromString(response.toString())
        } catch (e: Exception) {
            println(e.message)
            println(e.cause)
            null
        }

        if (responseParsed != null) {
            // You have successfully parsed the JSON into your data class
            println("current date/time: ${responseParsed.datetime}")
            println("current UTC time: ${responseParsed.utc_datetime}")
            return  responseParsed
        } else {
            // Handle the case where parsing failed
            println("Failed to parse JSON response")
            throw IllegalStateException("Empty response body")
        }
    }

}