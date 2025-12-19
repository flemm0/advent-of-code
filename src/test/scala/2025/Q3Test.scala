import org.scalatest.funsuite.AnyFunSuite
import `2025`.Q3.*

class Q3Test extends AnyFunSuite:
  val exampleBanks = List(
    "987654321111111",
    "811111111111119",
    "234234234234278",
    "818181911112111"
  )
  test("q3 part 1 test"){
    val res = totalOutputJoltage(2)(exampleBanks)
    assert(res == 357L)
  }

  test("q3 part 2 test"){
    val res = totalOutputJoltage(12)(exampleBanks)
    assert(res == 3121910778619L)
  }
