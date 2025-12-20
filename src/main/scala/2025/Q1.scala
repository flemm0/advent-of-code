package `2025`

import scala.math.abs
import scala.io.Source


object Q1:

  def parseInput(fname: String): List[String] =
    Source.fromResource(fname)
      .getLines()
      .toList

  def turnDial(input: String): Int = input match
    case s"L${value}" => -value.toInt
    case s"R${value}" => value.toInt
  
  def dialPosition(currentPos: Int, turn: Int): Int =
    ((currentPos + turn) % 100 + 100) % 100

  def crackSafe(rotations: List[String]): Int =
    rotations.map(turnDial)
      .scanLeft(50)(dialPosition)
      .tail
      .count(_ == 0)

  def allClicks(currentPos: Int, turn: Int): IndexedSeq[Int] =
    (currentPos to currentPos + turn by (if turn > 0 then 1 else -1))
      .map {pos =>
        ((pos % 100) + 100) % 100
      }
      .tail
  
  def crackSafeForReal(startPos: Int, rotations: List[String]): Int =
    rotations
      .map(turnDial)
      .foldLeft(startPos, 0) {
        case ((currentPos, zeroCount), turn) =>
          val clicks = allClicks(currentPos, turn)
          val newZeroCount = zeroCount + clicks.count(_ == 0)
          val newPos = clicks.last
          (newPos, newZeroCount)
      }
      ._2