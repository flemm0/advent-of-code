package aoc2025

import scala.io.Source

object Q9:

  case class Point(x: Long, y: Long)

  case class Rectangle(c1: Point, c2: Point):
    def width = Math.abs(c2.x - c1.x).toLong + 1L
    def height = Math.abs(c2.y - c1.y).toLong + 1L
    def area = width * height
  
  def parseInput(fname: String): List[Point] =
    Source.fromResource(fname)
      .getLines()
      .toList
      .map { line =>
        val parts = line.split(",").map(_.trim.toLong)
        Point(parts(0), parts(1))
      }

  def makeRectangles(points: List[Point]): List[Rectangle] =
    points.combinations(2)
      .map(pair => Rectangle(pair(0), pair(1)))
      .toList

  def largestRectangleArea(rectangles: List[Rectangle]): Long =
    rectangles.map(_.area).max
