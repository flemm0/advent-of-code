import org.scalatest.funsuite.AnyFunSuite
import aoc2025.Q8.*


class Q8Test extends AnyFunSuite:
  val input = parseInput("2025_Q8_test.txt")

  test("q8 part 1 test") {
    val result = threeLargestJunctionsProduct(
      formJunctions(
        shortestConnections(input, 10)
      )
    )
    assert(result == 40L)
  }

  test("q8 part 2 test") {
    val allConnections = shortestConnections(input, input.size * input.size)
      .map(_._1)
    val result = formJunctionsUntilAllConnected(allConnections, input.map(List(_)))
    assert(result == 25272L)
  }
