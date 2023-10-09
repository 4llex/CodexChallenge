package com.codexchallenge.controller

import com.codexchallenge.model.WorldClockResponseModel
import com.codexchallenge.service.WorldClockService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("world_clock")
class WorldClockController(
        var worldClockService: WorldClockService
) {

    @GetMapping
    fun getWorldClock(): WorldClockResponseModel {
        return worldClockService.getWorldClock()
    }

}