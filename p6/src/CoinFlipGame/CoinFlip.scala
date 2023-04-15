package CoinFlipGame

import CoinFlipGame.CoinFlipUtils.{getUserInput, printGameOver, printGameState, printableFlipResult, showPrompt, tossCoin}

import scala.annotation.tailrec
import scala.util.Random

case class GameState(numFlips: Int, numCorrect: Int)

object CoinFlip extends App {

  val r = MyRandom(11)
  val s = GameState(0, 0)
  val history = List(): List[GameState]

  mainLoop(s, r, history)

  def printGameStateHistory(lst: List[GameState]): Unit = {
    println("History: ")
    lst map (x => printGameState(x) + "\n")
  }
  @tailrec
  def mainLoop(gameState: GameState, random: RandomWithState, history: List[GameState])
  {
    showPrompt()
    val userInput = getUserInput()

    // handle the result
    userInput match {
      case "N" => {
        val newHistory = history ++ List(gameState)
        mainLoop(GameState(0, 0), random, newHistory)
      }
      case "H" | "T" => {
        val coinTossResult = tossCoin(random)
        val newNumFlips = gameState.numFlips + 1
        if (userInput == coinTossResult._1) {
          val newNumCorrect = gameState.numCorrect + 1
          val newGameState = gameState.copy(numFlips = newNumFlips, numCorrect = newNumCorrect)
          printGameState(printableFlipResult(coinTossResult._1), newGameState)
          mainLoop(newGameState, coinTossResult._2, history)
        } else {
          val newGameState = gameState.copy(numFlips = newNumFlips)
          printGameState(printableFlipResult(coinTossResult._1), newGameState)
          mainLoop(newGameState, coinTossResult._2, history)
        }
      }

      case _ => {
        printGameOver()
        printGameState(gameState)
        printGameStateHistory(history)
        // return out of the recursion here
      }
    }
  }

}
