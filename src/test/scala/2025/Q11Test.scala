import org.scalatest.funsuite.AnyFunSuite
import aoc2025.Q11.*


class Q11Test extends AnyFunSuite:
  val inputp1 = parseInput("2025_Q11_test.txt")
  
  test ("q11 part 1 test") {
    val result = countAllPaths(inputp1)
    assert(result == 5)
  }

  val inputp2 = parseInput("2025_Q11_part2_test.txt")
  test("q11 part 2 test") {
    val result = countAllProblematicPaths(inputp2)
    assert(result == 2)
  }
