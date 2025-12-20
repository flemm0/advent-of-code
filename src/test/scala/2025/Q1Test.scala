import org.scalatest.funsuite.AnyFunSuite
import `2025`.Q1.*


class Q1Test extends AnyFunSuite:

  test("q1 part1 test") {
    val rotations = List("L68", "L30", "R48", "L5", "R60", "L55", "L1", "L99", "R14", "L82")
    val password = crackSafe(rotations)
    assert(password == 3)
  }

  test("q1 part2 test -- method 0x434C49434B (click)") {
    val rotations = List("L68", "L30", "R48", "L5", "R60", "L55", "L1", "L99", "R14", "L82")
    val password = crackSafeForReal(50, rotations)
    assert(password == 6)
  }
