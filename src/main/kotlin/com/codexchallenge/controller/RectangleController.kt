package com.codexchallenge.controller

import com.codexchallenge.model.AreaResponseModel
import com.codexchallenge.model.IntersectionResponseModel
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

    @PostMapping("check_intersection")
    @ResponseStatus(HttpStatus.OK) //TODO: check status response
    fun checkRectangleIntersection(@RequestBody rectanglesPoints: RectanglesPointsModel): IntersectionResponseModel {
        return rectangleService.checkRectangleIntersection(rectanglesPoints)
    }

    @PostMapping("compute_area")
    @ResponseStatus(HttpStatus.OK) //TODO: check status response
    fun calculateIntersectionArea(@RequestBody rectanglesPoints: RectanglesPointsModel): AreaResponseModel {
        return rectangleService.calculateIntersectionArea(rectanglesPoints)
    }

}