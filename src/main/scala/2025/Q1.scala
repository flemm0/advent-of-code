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
  