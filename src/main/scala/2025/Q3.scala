package `2025`

object Q3:

  def parseInput(fname: String): List[String] =
    scala.io.Source.fromResource(fname)
      .getLines()
      .toList

  def numToDigits(num: String): List[Int] =
    num.grouped(1).toList.map(_.toInt)
  
  def maxVoltage(num: String): Int =
    numToDigits(num)
      .tails
      .flatMap {
        case a :: rest => rest.map(a * 10 + _).maxOption
        case _         => None
      }
      .max

  def totalOutputJoltage(nums: List[String]): Int =
    nums.map(maxVoltage).sum
