package com.codexchallenge.controller

import com.codexchallenge.model.RectangleResponseModel
import com.codexchallenge.model.RectanglesPointsModel
import com.codexchallenge.service.RectangleService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("rectangle")
class RectangleController(
        var rectangleService: RectangleService
) {

    @GetMapping
    fun helloWorld(): String {
        return rectangleService.helloWorld()
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK) //TODO: check status response
    fun checkRectangleIntersection(@RequestBody rectanglesPoints: RectanglesPointsModel): RectangleResponseModel {
        //return RectangleModel(Point(0,0),Point(0,0)) - @RequestBody rectanglesPoints: RectangleModel
        //return RectanglesModel(RectangleModel(Point(0,0)),RectangleModel(Point(0,0)))
        //return RectanglesModel(RectangleModel(Point(), Point()), RectangleModel(Point(), Point()))
        return rectangleService.checkRectangleIntersection(rectanglesPoints)
    }

}