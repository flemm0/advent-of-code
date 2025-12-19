import `2025`.*

object Main:

  def main(args: Array[String]): Unit =
    println("2025 Main")
    println("-----")

    val q1Result = Q1.crackSafe(Q1.parseInput("2025_Q1.txt"))
    println(s"The password to open the door is ${q1Result}.")

    println("-----")
    val q2p1Result = Q2.findInvalidIds(Q2.parseInput("2025_Q2.txt"))(Q2.isInvalidId)
    println(s"The sum of all invalid IDs is ${q2p1Result}.")

    val q2p2Result = Q2.findInvalidIds(Q2.parseInput("2025_Q2.txt"))(Q2.isInvalidIdFull)
    println(s"The sum of all invalid IDs using the new rule is ${q2p2Result}.")

    println("-----")
    val q3p1Result = Q3.totalOutputJoltage(2)(Q3.parseInput("2025_Q3.txt"))
    println(s"The total output joltage with 2 digits is ${q3p1Result}.")

    val q3p2Result = Q3.totalOutputJoltage(12)(Q3.parseInput("2025_Q3.txt"))
    println(s"The total output joltage with 12 digits is ${q3p2Result}.")
