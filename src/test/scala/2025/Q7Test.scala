import org.scalatest.funsuite.AnyFunSuite
import aoc2025.Q7.*

class Q7Test extends AnyFunSuite:

  val inputData = parseInput("2025_Q7_test.txt")

  test("q7 part 1 test") {
    val result = totalBeamSplits(inputData)
    assert(result == 21)
  }

  test("q7 part 2 test") {
    val result = totalBeamTimelines(inputData)
    assert(result == BigInt(40))
  }
