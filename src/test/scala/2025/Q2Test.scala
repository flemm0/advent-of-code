import org.scalatest.funsuite.AnyFunSuite
import `2025`.Q2.*


class Q2Test extends AnyFunSuite:

  val allIds: String = "11-22,95-115,998-1012,1188511880-1188511890,222220-222224,1698522-1698528,446443-446449,38593856-38593862,565653-565659,824824821-824824827,2121212118-2121212124"
  
  test("q2 part 1 test") {
    val res = findInvalidIds(allIds)(isInvalidId)
    assert(res == 1227775554L)
  }

  test("q2 part 2 test") {
    val res = findInvalidIds(allIds)(isInvalidIdFull)
    assert(res == 4174379265L)
  }
