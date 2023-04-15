package Ficha5

import scala.annotation.tailrec

object Main {

  def main(args: Array[String]): Unit = {

    val state: Turma = Turma("id22", List((11, "as", RegimeOPT.Ordinario, Some(1), Some(20)), (12, "Jose", RegimeOPT.TrabEstud, Some(13), None)))

    mainLoop(state)

    @tailrec
    def mainLoop(state: Turma) {

      IO_Utils.showPrompt()
      val userInput = IO_Utils.getUserInput()

      // handle the result
      userInput match {
        case "C" => {
          IO_Utils.showOptionsNum()
          val userInputNum = IO_Utils.getUserInput()
          IO_Utils.showOptionsNP()
          val userInputNP = IO_Utils.getUserInput()
          if (IO_Utils.myToInt(userInputNum) != None) {
            val newState = state.changeNP(IO_Utils.myToInt(userInputNum).get,
              IO_Utils.toNT(userInputNP))
            IO_Utils.printTurmaState(newState)
            mainLoop(newState)
          }
          else {
            IO_Utils.showPrompt("Wrong number!")
            mainLoop(state)
          }
        }
        case _ => {
          IO_Utils.printTurmaState(state)
        }
      }
    }
  }

}
