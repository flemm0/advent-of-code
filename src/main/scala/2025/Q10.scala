package aoc2025

import scala.collection.immutable.Queue


object Q10:
  
  enum IndicatorLight(state: Char):
    case Off extends IndicatorLight('.')
    case On extends IndicatorLight('#')

  object IndicatorLight:
    def fromChar(c: Char): IndicatorLight =
      c match
        case '.' => Off
        case '#' => On
        case _   => throw IllegalArgumentException(s"Invalid light character: $c")
    def toChar(light: IndicatorLight): Char =
      light match
        case Off => '.'
        case On  => '#'
  
  case class LightDiagram(lights: List[IndicatorLight]):
    def flipLights(wiring: List[Int]): LightDiagram =
      val newLights = lights.zipWithIndex
        .map { case (light, idx) =>
          if wiring.contains(idx) then
            light match
              case IndicatorLight.Off => IndicatorLight.On
              case IndicatorLight.On  => IndicatorLight.Off
          else light
        }
      LightDiagram(newLights)
    // def applyWiringSchemantics(wirings: List[List[Int]]): LightDiagram =
    //   wirings.foldLeft(this) { (diagram, wiring) =>
    //     diagram.flipLights(wiring)
    //   }

  case class LightDiagramState(diagram: LightDiagram, presses: Int)

  def parseInput(fname: String): List[(LightDiagram, List[List[Int]])] =
    val lines = scala.io.Source.fromResource(fname).getLines().toList
    lines.map { line =>
      val elements = line.split(" ")
      val lightDiagram = LightDiagram(
        elements.head.filter(c => c != '[' && c != ']').toList
          .map(IndicatorLight.fromChar)
      )
      val wirings = elements.drop(1).init.map { wiringStr =>
        wiringStr.split(",")
          .toList
          .map(_.filter(_.isDigit).toInt)
      }
      .toList
      (lightDiagram, wirings)
    }

  /**
    * Instead of queuing all possible combinations of wirings, we could
    * instead keep track of the "state" of the light diagram after each press
    * and how many presses it took to get there.
    * 
    * All states of one button presses are searched first, then all buttons
    * are pressed on the states returned after the first press to get all
    * states of two presses, and so on. This way, the memory usage of the
    * queue is reduced significantly.
    * 
    * The set will also keep track of visited states to avoid re-processing
    * the same state multiple times.
    * 
    * The BFS approach will model nodes as the current "state" of the light diagram,
    * and edges as the application of a wiring scheme (button press) to that state.
    */
  @annotation.tailrec
  def configureMachineWithFewestPresses(
    input: (LightDiagram, List[List[Int]]),  // will need to pass the buttons in here
    queue: Queue[LightDiagramState],
    visited: Set[LightDiagramState]
  ): Int =
    queue.dequeueOption match
      case None => -1 // No solution found
      case Some((lightDiagramState, remainingQueue)) =>
        val newStates = input._2.indices.map { i =>
          val newDiagram = lightDiagramState.diagram.flipLights(input._2(i))
          LightDiagramState(newDiagram, lightDiagramState.presses + 1)
        }.toList
        newStates.find(_.diagram == input._1) match
          case Some(solutionState) => solutionState.presses
          case None =>
            configureMachineWithFewestPresses(
              input,
              remainingQueue.enqueueAll(newStates.filterNot(visited.contains)),
              visited ++ newStates
            )

  def configureAllMachines(
    inputs: List[(LightDiagram, List[List[Int]])]
  ): Int =
    inputs.map { case (desiredDiagram, wirings) =>
      configureMachineWithFewestPresses(
        (desiredDiagram, wirings),
        Queue(LightDiagramState(
          LightDiagram(List.fill(desiredDiagram.lights.size)(IndicatorLight.Off)),
          0
        )),
        Set.empty[LightDiagramState]
      )
    }
    .sum
