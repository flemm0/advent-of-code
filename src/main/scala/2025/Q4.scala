package aoc2025


object Q4:

  def parseInput(fname: String): List[String] =
    scala.io.Source.fromResource(fname)
      .getLines()
      .toList

  def canAccessPosition(x: Int, y: Int, grid: List[String]): Boolean =
    (for
      xs <- (x - 1 to x + 1).filter(xi => xi >= 0 && xi < grid.head.length)
      ys <- (y - 1 to y + 1).filter(yi => yi >= 0 && yi < grid.length)
      if !(xs == x && ys == y)
    yield grid(ys).charAt(xs))
      .count(_ == '@') < 4

  def totalAccessiblePositions(grid: List[String]): Int =
    (for
      y <- grid.indices
      x <- grid.head.indices
      if canAccessPosition(x, y, grid) && grid(y).charAt(x) == '@'
    yield 1).sum
