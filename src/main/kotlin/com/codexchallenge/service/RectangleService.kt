package com.codexchallenge.service

import com.codexchallenge.model.AreaResponseModel
import com.codexchallenge.model.IntersectionResponseModel
import com.codexchallenge.model.RectanglesPointsModel
import org.springframework.stereotype.Service
import kotlin.math.max
import kotlin.math.min

@Service
class RectangleService {

    fun helloWorld(): String {
        return "Rectangle end-point helloWorld()"
    }

    fun checkRectangleIntersection(rectanglesPoints: RectanglesPointsModel): IntersectionResponseModel {
        return IntersectionResponseModel(intersectionDetected = hasIntersection(rectanglesPoints))
    }

    fun calculateIntersectionArea(rectanglesPoints: RectanglesPointsModel): AreaResponseModel {
        return calculateArea(rectanglesPoints)
    }

}

fun calculateArea(rectanglesPoints: RectanglesPointsModel): AreaResponseModel {
    //
    return AreaResponseModel()
}

fun hasIntersection(rectanglesPoints: RectanglesPointsModel): Boolean{
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

    //Math definition to identity rectangles intersection
    val x5 = max(x1, x3)
    val y5 = max(y1, y3)
    val x6 = min(x2, x4)
    val y6 = min(y2, y4)
    println("Retangulo resultante = p1($x5, $y5), p2($x6, $y6)")

    // no intersection condition
    return if (x5 > x6 || y5 > y6) {
        println("No intersection")
        false
    } else {
        println("Intersection Detected!!!")
        true
    }
}