package aoc2025

import scala.io.Source

object Q12:

  case class Present(idx: Int, shape: Array[String]):
    override def toString(): String = 
      "\n" ++ idx.toString ++ ":\n" ++ shape.mkString("\n")
  case class Region(length: Int, width: Int, shapeQuantities: Map[Int, Int])

  def parseInput(fname: String): (List[Present], List[Region]) =
    val lines = Source.fromResource(fname).mkString.split("""\n\s*\n""").toList
    val presents = lines.dropRight(1)
      .map { line =>
        line.split(":", 2) match
          case Array(idx, shape) =>
            Present(idx.toInt, shape.split("\n").filter(_ != ""))
      }
    val regions = lines.last
      .split("\n")
      .map { line =>
        line.split(":", 2) match
          case Array(lw, region) =>
            val (length, width) = lw.split("x") match
              case Array(l, w) => (l.toInt, w.toInt)
            val shapeQuantities = region.trim.split(" ").zipWithIndex.map {
              case (quantity, idx) => idx -> quantity.toInt
            }.toMap
            Region(length, width, shapeQuantities)
      }
    (presents, regions.toList)

  def regionCanFitPresents(region: Region, presents: List[Present]): Boolean =
    val totalRegionArea = region.length * region.width

    val presentShapeAreas = presents.map { present =>
      present.shape.map(_.count(_ == '#')).sum
    }
    val totalPresentShapeAreas = presentShapeAreas.zipWithIndex.map {
      case (area, idx) =>
        area * region.shapeQuantities.getOrElse(idx, 0)
    }.sum

    val presentBoxShapeAreas = presents.map { present =>
      present.shape.length * present.shape.map(_.count(_ == '#')).max
    }
    val totalPresentBoxShapeAreas = presentBoxShapeAreas.zipWithIndex.map {
      case (area, idx) =>
        area * region.shapeQuantities.getOrElse(idx, 0)
    }.sum

    totalPresentShapeAreas < totalRegionArea && totalPresentBoxShapeAreas <= totalRegionArea

  def regionsThatCanFitPresents(presents: List[Present], regions: List[Region]): Int =
    regions.filter(region => regionCanFitPresents(region, presents)).size
