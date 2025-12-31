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

  def countAllProblematicPaths(deviceOutputs: Map[String, Set[String]], node: String = "svr"): Long =
    
    /**
      * For each path from node -> out, store the number of paths that pass through
      * fft only, dac only, both, or neither.
      * 
      * If the same state is reached again, reuse the result.
      */
    val memo = scala.collection.mutable.Map.empty[(String, Boolean, Boolean), Long]
    
    def loop(node: String, passesFft: Boolean, passesDac: Boolean): Long =
      memo.getOrElseUpdate(
        (node, passesFft, passesDac),
        node match
          case "out" if passesFft && passesDac => 1
          case "out"                           => 0
          case _                               =>
            val newPassesFft = passesFft || node.startsWith("fft")
            val newPassesDac = passesDac || node.startsWith("dac")
            deviceOutputs
              .getOrElse(node, Set())
              .toList
              .map(loop(_, newPassesFft, newPassesDac))
              .sum
              .toLong 
      )
    
    loop(node, false, false)
