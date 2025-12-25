import org.scalatest.funsuite.AnyFunSuite
import aoc2025.Q9.*


class Q9Test extends AnyFunSuite:
  
  val points = List(
    Point(7,1),
    Point(11,1),
    Point(11,7),
    Point(9,7),
    Point(9,5),
    Point(2,5),
    Point(2,3),
    Point(7,3)
  )

  test("q9 part 1 test") {
    val result = largestRectangleArea(makeRectangles(points))
    assert(result == 50L)
  }

  test("q9 part 2 test") {
    val boundaries = makeBoundaries(points)
    val result = largestNonOverlappingRectangleArea(makeRectangles(points), boundaries)
    assert(result == 24L)
  }
