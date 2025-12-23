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

  def totalBeamTimelines(input: List[String]): BigInt =
    val start = input.head
    val manifold = input.tail
    manifold.foldLeft(Map(start.indexOf('S') -> BigInt(1))) {
      case (currentTimelines, row) =>
        val splitIndices = findSplitIndices(row, currentTimelines.keySet)
        val intermediateState = currentTimelines.map { case (beamPos, timelineCount) =>
          if splitIndices.contains(beamPos) then
            beamPos -> (List(beamPos - 1, beamPos + 1), timelineCount)
          else
            beamPos -> (List(beamPos), timelineCount)
        }
        intermediateState.values
          .flatMap { case (targets, count) =>
            targets.map( _ -> count)
          }
          .groupMapReduce(_._1)( _._2 )( _ + _ )
    }
    .values
    .sum
