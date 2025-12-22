package aoc2025

object Q6:

  def parseInput(fname: String): String =
    scala.io.Source.fromResource(fname)
      .mkString
  
  def parseColumnExpressionsByRows(input: String): List[List[String]] =
    input.trim
      .linesIterator
      .toList
      .map(_.trim.split("""\s+"""))
      .map(_.toList)
      .transpose


  def solveCephlapodMathProblem(rows: List[List[String]]): Long =
    rows
      .map { row
        => row.last match
          case "+" => row.init.map(_.toLong).sum
          case "*" => row.init.map(_.toLong).product
      }
      .sum

  def splitBySeparator[T](l: List[T], sep: T): List[List[T]] = {
    l.span( _ != sep ) match {
      case (head, _ :: tail) => head :: splitBySeparator(tail, sep)
      case (head, _) => List(head)
    }
  }

  def parseColumnExpressionsByChars(input: String): List[List[String]] =
    val nums = input.linesIterator
      .toList
      .init
      .transpose
      .map(_.mkString.trim)
    val ops = input.linesIterator
      .toList
      .last
      .trim
      .split("""\s+""")
      .toList
    splitBySeparator(nums, "").zip(ops).map {
      case (nums, op) => nums :+ op
    }
