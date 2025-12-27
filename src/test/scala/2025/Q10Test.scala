import org.scalatest.funsuite.AnyFunSuite
import aoc2025.Q10.*


class Q10Test extends AnyFunSuite:
  val sampleInput = parseInput("2025_Q10_test.txt")

  test("q10 part 1 test") {
    val result = configureAllMachines(sampleInput)
    assert(result == 7)
  }
