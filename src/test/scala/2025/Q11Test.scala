import org.scalatest.funsuite.AnyFunSuite
import aoc2025.Q11.*


class Q11Test extends AnyFunSuite:
  val input = parseInput("2025_Q11_test.txt")
  test ("q11 part 1 test") {
    val result = countAllPaths(input)
    assert(result == 5)
  }
