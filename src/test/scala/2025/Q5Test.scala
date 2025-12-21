import org.scalatest.funsuite.AnyFunSuite
import aoc2025.Q5.*

class Q5Test extends AnyFunSuite:

  val exampleRanges = List("3-5", "10-14", "16-20", "12-18")
  val exampleIds = List(1L, 5L, 8L, 11L, 17L, 32L)

  test("q5 part 1 test") {
    val res = countFreshIngredients(exampleRanges, exampleIds)
    assert(res == 3)
  }

  test("q5 part 2 test - range coverages") {
    val res = countTotalFreshIngredients(exampleRanges)
    assert(res == 14L)
  }
