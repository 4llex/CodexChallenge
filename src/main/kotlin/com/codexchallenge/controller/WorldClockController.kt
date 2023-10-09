package com.codexchallenge.controller

import com.codexchallenge.model.WorldClockClientResponseModel
import com.codexchallenge.model.WorldClockServerResponseModel
import com.codexchallenge.service.WorldClockService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("world_clock")
class WorldClockController(
        var worldClockService: WorldClockService
) {

    @GetMapping("server")
    fun getWorldClockServer(): WorldClockServerResponseModel {
        return worldClockService.getWorldClockServer()
    }

    @GetMapping("client")
    fun getWorldClockClient(): WorldClockClientResponseModel {
        return worldClockService.getWorldClockClient()
    }



    //TODO: Below end-poins was created for tests
    @GetMapping("client2")
    fun getWorldClockClient2(): WorldClockClientResponseModel {
        return worldClockService.getWorldClockClient2()
    }

    @GetMapping("client3")
    fun getWorldClockClient3(): WorldClockClientResponseModel {
        return worldClockService.getWorldClockClient3()
    }

}