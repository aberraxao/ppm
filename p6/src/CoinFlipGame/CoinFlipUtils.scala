package CoinFlipGame

import scala.io.StdIn.readLine
import scala.util.Random

object CoinFlipUtils {

  def showPrompt(): Unit = {
    print("\n(h)eads, (t)ails, (n)ew or (q)uit: ")
  }

  def getUserInput(): String = readLine.trim.toUpperCase

  def printableFlipResult(flip: String): String = flip match {
    case "H" => "Heads"
    case "T" => "Tails"
  }

  def printGameState(printableFlipResult: String, gameState: GameState): Unit = {
    print(s"Flip was $printableFlipResult. ")
    printGameState(gameState)
  }

  def printGameState(gameState: GameState): Unit = {
    println(s"#Flips: ${gameState.numFlips}, #Correct: ${gameState.numCorrect}")
  }

  def printGameOver(): Unit = println("\n=== GAME OVER ===")

  // returns "H" for heads, "T" for tails
  def tossCoin(r: RandomWithState): (String, RandomWithState) = {
    val (i, state) = r.nextInt(2)
    i match {
      case 0 => ("H", state)
      case 1 => ("T", state)
    }
  }

}
