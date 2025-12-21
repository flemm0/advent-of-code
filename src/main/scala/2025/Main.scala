import aoc2025.*

object Main:

  def main(args: Array[String]): Unit =
    println("2025 Main")
    println("-----")

    val q1p1Result = Q1.crackSafe(Q1.parseInput("2025_Q1.txt"))
    println(s"The password to open the door is ${q1p1Result}.")
    val q1p2Result = Q1.crackSafeForReal(50, Q1.parseInput("2025_Q1.txt"))
    println(s"The password to open the door using the click method is ${q1p2Result}.")

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

    println("-----")
    val q4p1Result = Q4.totalAccessiblePositions(Q4.parseInput("2025_Q4.txt"))
    println(s"The total number of accessible positions is ${q4p1Result}.")

    val q4p2Result = Q4.totalAccessiblePositionsWithRemoval(Q4.parseInput("2025_Q4.txt"))
    println(s"The total number of accessible positions with removal is ${q4p2Result}.")

    println("-----")
    val q5p1Result = Q5.countFreshIngredients(
      Q5.parseInput("2025_Q5.txt")._1,
      Q5.parseInput("2025_Q5.txt")._2
    )
    println(s"The total number of fresh ingredients is ${q5p1Result}.")
    val q5p2Result = Q5.countTotalFreshIngredients(Q5.parseInput("2025_Q5.txt")._1)
    println(s"The total number of all fresh ingredients reanges is ${q5p2Result}.")
