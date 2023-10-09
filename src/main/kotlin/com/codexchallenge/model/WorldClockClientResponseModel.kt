package com.codexchallenge.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WorldClockClientResponseModel(
        @SerialName("datetime")
        var datetime: String,
        @SerialName("utc_datetime")
        var utc_datetime: String
)

@Serializable
data class FullResponseModel(
        @SerialName("abbreviation")
        val abbreviation: String,
        @SerialName("client_ip")
        val clientIp: String,
        @SerialName("datetime")
        val datetime: String,
        @SerialName("day_of_week")
        val dayOfWeek: Int,
        @SerialName("day_of_year")
        val dayOfYear: Int,
        @SerialName("dst")
        val dst: Boolean,
        @SerialName("dst_from")
        val dstFrom: String?, // It's nullable because it can be null in the JSON
        @SerialName("dst_offset")
        val dstOffset: Int,
        @SerialName("dst_until")
        val dstUntil: String?, // It's nullable because it can be null in the JSON
        @SerialName("raw_offset")
        val rawOffset: Int,
        @SerialName("timezone")
        val timezone: String,
        @SerialName("unixtime")
        val unixtime: Long,
        @SerialName("utc_datetime")
        val utcDatetime: String,
        @SerialName("utc_offset")
        val utcOffset: String,
        @SerialName("week_number")
        val weekNumber: Int
)

@Serializable
data class ClockApiResponse(
        @SerialName("\$id")
        val id: String,
        @SerialName("currentDateTime")
        val currentDateTime: String,
        @SerialName("utcOffset")
        val utcOffset: String,
        @SerialName("isDayLightSavingsTime")
        val isDayLightSavingsTime: Boolean,
        @SerialName("dayOfTheWeek")
        val dayOfTheWeek: String,
        @SerialName("timeZoneName")
        val timeZoneName: String,
        @SerialName("currentFileTime")
        val currentFileTime: Long,
        @SerialName("ordinalDate")
        val ordinalDate: String,
        @SerialName("serviceResponse")
        val serviceResponse: String?
)