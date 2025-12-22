import org.scalatest.funsuite.AnyFunSuite
import aoc2025.Q6.*


class Q6Test extends AnyFunSuite:

  val inputString = parseInput("2025_Q6_test.txt")

  test("q6 part 1 test") {
    val result = solveCephlapodMathProblem(
      parseColumnExpressionsByRows(inputString)
    )
    assert(result == 4277556)
  }

  test("q6 part 2 test") {
    val result = solveCephlapodMathProblem(
      parseColumnExpressionsByChars(inputString)
    )
    assert(result == 3263827)
  }