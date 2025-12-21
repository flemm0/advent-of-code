package aoc2025


object Q5:

  def parseInput(fname: String): (List[String], List[Long]) =
    val lines = scala.io.Source.fromResource(fname)
      .getLines()
      .toList
    val splitIndex = lines.indexOf("")
    val ranges = lines.take(splitIndex)
    val ids = lines.drop(splitIndex + 1).map(_.toLong)
    (ranges, ids)

  def isIngredientFresh(ranges: List[String], id: Long): Boolean =
    ranges.exists { rng =>
      val Array(start, end) = rng.split("-").map(_.toLong)
      id >= start && id <= end
    }

  def countFreshIngredients(ranges: List[String], ids: List[Long]): Int =
    ids.filter(id => isIngredientFresh(ranges, id)).size
