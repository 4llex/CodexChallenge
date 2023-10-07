package com.codexchallenge.service

import com.codexchallenge.model.AreaResponseModel
import com.codexchallenge.model.IntersectionResponseModel
import com.codexchallenge.model.RectangleModel
import com.codexchallenge.model.RectanglesPointsModel
import org.springframework.stereotype.Service
import java.awt.Point
import kotlin.math.max
import kotlin.math.min

@Service
class RectangleService {

    fun helloWorld(): String {
        return "Rectangle end-point helloWorld()"
    }

    fun checkRectangleIntersection(rectanglesPoints: RectanglesPointsModel): IntersectionResponseModel {
        return IntersectionResponseModel(hasIntersection(getResultingRectangle(rectanglesPoints)))
    }

    fun calculateIntersectionArea(rectanglesPoints: RectanglesPointsModel): AreaResponseModel {
        return calculateArea(rectanglesPoints)
    }

}

fun calculateArea(rectanglesPoints: RectanglesPointsModel): AreaResponseModel {
    //check if exist intersection before compute area
    val rectangle = getResultingRectangle(rectanglesPoints)
    if (!hasIntersection(rectangle)) {
        return AreaResponseModel(false, 0)
    }

    //calculate the area do Retangulo resultante
    //#height: p2y - p1y     #base: p2x - p1x    #plus 1 to INCLUDED points
    val area: Int
    rectangle.apply {
        area = (p2.y - p1.y + 1) * (p2.x - p1.x + 1)
    }

    println(area)
    return AreaResponseModel(true, area)
}

fun getResultingRectangle(rectanglesPoints: RectanglesPointsModel): RectangleModel {
    //Rectangle A points
    val x1: Int = rectanglesPoints.rec1.p1.x
    val y1: Int = rectanglesPoints.rec1.p1.y
    val x2: Int = rectanglesPoints.rec1.p2.x
    val y2: Int = rectanglesPoints.rec1.p2.y
    println("A = p1($x1, $y1) - p2($x2, $y2)")

    //Rectangle A points
    val x3 = rectanglesPoints.rec2.p1.x
    val y3 = rectanglesPoints.rec2.p1.y
    val x4 = rectanglesPoints.rec2.p2.x
    val y4 = rectanglesPoints.rec2.p2.y
    println("B = p1($x3, $y3) - p2($x4, $y4)")

    //Math definition to get the points of a possible intersection area
    val x5 = max(x1, x3)
    val y5 = max(y1, y3)
    val x6 = min(x2, x4)
    val y6 = min(y2, y4)
    println("Retangulo resultante = p1($x5, $y5), p2($x6, $y6)")
    return RectangleModel(Point(x5, y5), Point(x6, y6))
}

fun hasIntersection(rectangle: RectangleModel): Boolean {
    // if (x5 > x6 || y5 > y6) println("No intersection")
    //Math definition to check for intersection
    rectangle.apply {
        return if (p1.x > p2.x || p1.y > p2.y) {
            println("No intersection")
            false
        } else {
            println("Intersection Detected!!!")
            true
        }
    }
}