package com.codexchallenge.model

import java.awt.Point


data class RectanglesPointsModel(
        var rec1: RectangleModel,
        var rec2: RectangleModel
)

data class RectangleModel(
        var p1: Point,
        var p2: Point
)

data class IntersectionResponseModel(
        var intersectionDetected: Boolean = false
)

data class AreaResponseModel(
        var intersectionDetected: Boolean = false,
        var areaOfIntersection: Int = 0
)