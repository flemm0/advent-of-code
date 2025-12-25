package aoc2025

import scala.io.Source

object Q9:

  case class Point(x: Long, y: Long)

  case class Rectangle(c1: Point, c2: Point):
    def width = Math.abs(c2.x - c1.x).toLong + 1L
    def height = Math.abs(c2.y - c1.y).toLong + 1L
    def area = width * height
    val minX = Math.min(c1.x, c2.x)
    val maxX = Math.max(c1.x, c2.x)
    val minY = Math.min(c1.y, c2.y)
    val maxY = Math.max(c1.y, c2.y)
    def overlapsArea(other: Rectangle): Boolean =
      !(maxX <= other.minX ||
      other.maxX <= minX ||
      maxY <= other.minY ||
      other.maxY <= minY)

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

  def makeBoundaries(points: List[Point]): List[Rectangle] =
    makeRectangles(points)
      .filter { rectangle =>
        rectangle.c1.x == rectangle.c2.x || rectangle.c1.y == rectangle.c2.y
      }

  def largestNonOverlappingRectangleArea(rectangles: List[Rectangle],
                                         boundaries: List[Rectangle]
  ): Long =
    rectangles
      .filter { rectangle =>
        !boundaries.exists( boundary => rectangle.overlapsArea(boundary) )
      }
      .map(_.area)
      .max
