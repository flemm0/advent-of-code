package aoc2025

import scala.io.Source
import scala.collection.immutable.NumericRange


object Q2:

  def parseInput(fname: String): String =
    Source.fromResource(fname)
      .getLines()
      .mkString

  def isInvalidId(num: Long): Boolean =
    val (firstHalf, secondHalf) = num.toString().splitAt(num.toString().length / 2)
    firstHalf == secondHalf
  
  def isInvalidIdFull(num: Long): Boolean =
    val numStr = num.toString
    (1 to numStr.size - 1).exists { s =>
      numStr.grouped(s).toSet.size == 1
    }
    
  def inputToRanges(input: String): List[NumericRange.Inclusive[Long]] = 
    input.split(",")
      .toList
      .map(_.split("-"))
      .map({ case Array(a, b) => a.toLong to b.toLong})
		
  def findInvalidIds(allIds: String)(isInvalid: Long => Boolean): Long =
    inputToRanges(allIds)
      .map(_.toList)
      .flatMap(_.filter(isInvalid))
      .sum
