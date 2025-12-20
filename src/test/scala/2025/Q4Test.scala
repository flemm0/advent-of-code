import org.scalatest.funsuite.AnyFunSuite
import aoc2025.Q4.*


class Q4Test extends AnyFunSuite:
  val exampleGrid = List(
    "..@@.@@@@.",
    "@@@.@.@.@@",
    "@@@@@.@.@@",
    "@.@@@@..@.",
    "@@.@@@@.@@",
    ".@@@@@@@.@",
    ".@.@.@.@@@",
    "@.@@@.@@@@",
    ".@@@@@@@@.",
    "@.@.@@@.@.",
  )

  test("q4 part 1 test"){
    val res = totalAccessiblePositions(exampleGrid)
    assert(res == 13)
  }
