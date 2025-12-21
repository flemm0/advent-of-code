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


  def parseRange(rng: String): (Long, Long) =
    rng.split("-")
      .map(_.toLong) match
      case Array(start, end) => (start.toLong, end.toLong)
  
  def countTotalFreshIngredients(ranges: List[String]): Long =
    // first, sort all the ranges
    val sortedRange = ranges
      .map(parseRange)
      .sortBy(_._1)

    // then merge the overlapping ranges
    val mergedRanges = sortedRange.foldLeft(List.empty[(Long, Long)]) {
      case (Nil, currentRange) => List(currentRange)
      case (accumulator @ (prevStart, prevEnd) :: tail, (currentStart, currentEnd)) =>
        if (currentStart <= prevEnd) then
          (prevStart, Math.max(prevEnd, currentEnd)) :: tail
        else
          (currentStart, currentEnd) :: accumulator
    }.reverse

    mergedRanges.map { case (start, end) => end - start + 1 }.sum
