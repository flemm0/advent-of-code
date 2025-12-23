package aoc2025


object Q7:

  def parseInput(fname: String): List[String] =
    scala.io.Source.fromResource(fname)
      .getLines()
      .toList

  def getNextBeamPositions(currentBeams: Set[Int], splitIndices: List[Int]): Set[Int] =
    val newIndices = splitIndices
      .flatMap { idx =>
        List(idx - 1, idx + 1)
      }
      .toSet
    (currentBeams diff splitIndices.toSet) ++ newIndices

  def findSplitIndices(row: String, currentBeams: Set[Int]): List[Int] =
    row.zipWithIndex
      .filter { (char, idx) =>
        char == '^' && currentBeams.contains(idx)
      }
      .map(_._2)
      .toList

  def totalBeamSplits(input: List[String]): Int =
    val start = input.head
    val manifold = input.tail
    manifold.foldLeft(Set(start.indexOf('S')), 0) {
      case ((currentBeams, totalSplits), row) =>
        val splitIndices = findSplitIndices(row, currentBeams)
        (getNextBeamPositions(currentBeams, splitIndices), totalSplits + splitIndices.size)
    }
    ._2
