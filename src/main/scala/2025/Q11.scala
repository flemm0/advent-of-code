package aoc2025


object Q11:

  def parseInput(fname: String): Map[String, Set[String]] =
    scala.io.Source.fromResource(fname).getLines()
      .map(_.split(": "))
        .collect {
          case Array(key, values) =>
            key -> values.split(" ").toSet
        }
        .toMap

  def countAllPaths(deviceOutputs: Map[String, Set[String]], node: String = "you"): Int =
    node match
      case "out" => 1
      case _ =>
        deviceOutputs
          .getOrElse(node, Set())
          .toList
          .map(countAllPaths(deviceOutputs, _))
          .sum
