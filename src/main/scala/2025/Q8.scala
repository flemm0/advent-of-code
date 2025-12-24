package aoc2025

import scala.io.Source


object Q8:
  
  case class JunctionBox(x: Int, y: Int, z: Int)
  object JunctionBox:
    def distance(a: JunctionBox, b: JunctionBox): Double =
      val dx = a.x - b.x
      val dy = a.y - b.y
      val dz = a.z - b.z
      dx.toLong * dx + dy.toLong * dy + dz.toLong * dz

  def parseInput(fname: String): List[JunctionBox] =
    Source.fromResource(fname)
      .getLines()
      .toList
      .map { line =>
        val parts = line.split(",").map(_.trim.toInt)
        JunctionBox(parts(0), parts(1), parts(2))
      }

  def shortestConnections(boxes: List[JunctionBox], n: Int): List[((JunctionBox, JunctionBox), Double)] =
    boxes.indices.iterator.flatMap { i =>
      (i + 1 until boxes.length).iterator.map { j =>
        ((boxes(i), boxes(j)), JunctionBox.distance(boxes(i), boxes(j)))
      }
    }
      .toList
      .sortBy(_._2)
      .take(n)

  def formJunctions(pairs: List[((JunctionBox, JunctionBox), Double)]): List[List[JunctionBox]] =
    pairs.map(_._1)
      .foldLeft(List.empty[List[JunctionBox]]) { (acc, pair) =>
        val (a, b) = pair
        val (aGroup, bGroup) = (acc.find(_.contains(a)), acc.find(_.contains(b)))
        (aGroup, bGroup) match
          case (None, None)         =>
            acc :+ List(a, b)
          case (Some(ag), None)     =>
            acc.filterNot(_ == ag) :+ (ag :+ b)
          case (None, Some(bg))     =>
            acc.filterNot(_ == bg) :+ (bg :+ a)
          case (Some(ag), Some(bg)) => 
            // need to merge the groups if not already the same
            if ag != bg then
              acc.filterNot(g => g == ag || g == bg) :+ (ag ++ bg)
            else
              acc
      }
  
  def threeLargestJunctionsProduct(junctions: List[List[JunctionBox]]): Long =
    junctions.map(_.length)
      .sortWith(_ > _)
      .take(3)
      .map(_.toLong)
      .product
