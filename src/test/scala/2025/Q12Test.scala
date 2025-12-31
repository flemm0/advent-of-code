import org.scalatest.funsuite.AnyFunSuite
import aoc2025.Q12.*


class Q12Test extends AnyFunSuite:

  val (presents, regions) = parseInput("2025_Q12_test.txt")
  
  test ("q12 test") {
    val result = regionsThatCanFitPresents(presents, regions)
    assert(result == 1)
  }
end Q12Test
