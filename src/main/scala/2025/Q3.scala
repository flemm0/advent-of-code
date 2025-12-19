package `2025`

object Q3:

  def parseInput(fname: String): List[String] =
    scala.io.Source.fromResource(fname)
      .getLines()
      .toList

  def findMaxDigit(num: String, remainingDigits: Int): String =
    val idxOfMax = (0 until num.size - remainingDigits + 1)
      .maxBy(num.charAt(_))
    val maxNum = remainingDigits match
      case 1 => num.charAt(idxOfMax).toString
      case _ => num.charAt(idxOfMax).toString + findMaxDigit(num.substring(idxOfMax + 1), remainingDigits - 1)
    maxNum

  def totalOutputJoltage(nDigits: Int)(bank: List[String]): Long =
    bank.map(findMaxDigit(_, nDigits).toLong).sum
