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

data class RectangleResponseModel(
        var intersectionDetected: Boolean = false
)