import aoc2025.*

object Main:

  def main(args: Array[String]): Unit =
    
    val divider = "\n" + "=" * 80 + "\n"
    
    println("2025 Main")
    println(divider)

    val q1p1Result = Q1.crackSafe(Q1.parseInput("2025_Q1.txt"))
    println(s"The password to open the door is ${q1p1Result}.")
    val q1p2Result = Q1.crackSafeForReal(50, Q1.parseInput("2025_Q1.txt"))
    println(s"The password to open the door using the click method is ${q1p2Result}.")

    println(divider)
    val q2p1Result = Q2.findInvalidIds(Q2.parseInput("2025_Q2.txt"))(Q2.isInvalidId)
    println(s"The sum of all invalid IDs is ${q2p1Result}.")

    val q2p2Result = Q2.findInvalidIds(Q2.parseInput("2025_Q2.txt"))(Q2.isInvalidIdFull)
    println(s"The sum of all invalid IDs using the new rule is ${q2p2Result}.")

    println(divider)
    val q3p1Result = Q3.totalOutputJoltage(2)(Q3.parseInput("2025_Q3.txt"))
    println(s"The total output joltage with 2 digits is ${q3p1Result}.")

    val q3p2Result = Q3.totalOutputJoltage(12)(Q3.parseInput("2025_Q3.txt"))
    println(s"The total output joltage with 12 digits is ${q3p2Result}.")

    println(divider)
    val q4p1Result = Q4.totalAccessiblePositions(Q4.parseInput("2025_Q4.txt"))
    println(s"The total number of accessible positions is ${q4p1Result}.")

    val q4p2Result = Q4.totalAccessiblePositionsWithRemoval(Q4.parseInput("2025_Q4.txt"))
    println(s"The total number of accessible positions with removal is ${q4p2Result}.")

    println(divider)
    val q5p1Result = Q5.countFreshIngredients(
      Q5.parseInput("2025_Q5.txt")._1,
      Q5.parseInput("2025_Q5.txt")._2
    )
    println(s"The total number of fresh ingredients is ${q5p1Result}.")
    val q5p2Result = Q5.countTotalFreshIngredients(Q5.parseInput("2025_Q5.txt")._1)
    println(s"The total number of all fresh ingredients reanges is ${q5p2Result}.")

    println(divider)
    val q6p1Result = Q6.solveCephlapodMathProblem(
      Q6.parseColumnExpressionsByRows(Q6.parseInput("2025_Q6.txt"))
    )
    println(s"The answer to the cephlapod math problem is ${q6p1Result}.")
    val q6p2Result = Q6.solveCephlapodMathProblem(
      Q6.parseColumnExpressionsByChars(Q6.parseInput("2025_Q6.txt"))
    )
    println(s"The answer to the cephlapod math problem using char parsing is ${q6p2Result}.")

    println(divider)
    val q7p1Result = Q7.totalBeamSplits(Q7.parseInput("2025_Q7.txt"))
    println(s"The total number of beam splits is ${q7p1Result}.")
    val q7p2Result = Q7.totalBeamTimelines(Q7.parseInput("2025_Q7.txt"))
    println(s"The total number of beam timelines is ${q7p2Result}.")

    println(divider)
    val q8p1Result = Q8.threeLargestJunctionsProduct(
      Q8.formJunctions(
        Q8.shortestConnections(
          Q8.parseInput("2025_Q8.txt"), 1000
        )
      )
    )
    println(s"The product of the sizes of the three largest junctions is ${q8p1Result}.")
    val q8p2Result = Q8.formJunctionsUntilAllConnected(
      Q8.shortestConnections(
        Q8.parseInput("2025_Q8.txt"), 
        Q8.parseInput("2025_Q8.txt").size * Q8.parseInput("2025_Q8.txt").size
      ).map(_._1),
      Q8.parseInput("2025_Q8.txt").map(List(_))
    )
    println(s"The product of the x coordinates of the final junction is ${q8p2Result}.")

    println(divider)
    val q9p1Result = Q9.largestRectangleArea(
      Q9.makeRectangles(
        Q9.parseInput("2025_Q9.txt")
      )
    )
    println(s"The area of the largest rectangle is ${q9p1Result}.")

