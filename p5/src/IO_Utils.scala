package p5

import p5.Turma.NT

import scala.io.StdIn.readLine
import scala.util.Try

object IO_Utils {

  def showPrompt(): Unit = {
    print("\n(c)hangeNT, or (q)uit: ")
  }

  def showOptionsNum(): Unit = {
    print("\nNúmero:")
  }

  def showOptionsNP(): Unit = {
    print("\nNP or N(one): ")
  }

  def getUserInput(): String = readLine.trim.toUpperCase

  def myToInt(s: String): Option[Int] = {
    if (Try(s.toInt).isSuccess) Some(s.toInt) else None
  }

  def toNT(s: String): NT = s match {
    case "N" => None
    case d => if (Try(d.toFloat).isSuccess) Some(d.toFloat) else None
  }

  def printTurmaState(turmaState: Turma): Unit = {
    println(s"ID: ${turmaState.id}\nAlunos: ${turmaState.alunos}")
  }

  def showPrompt(s: String): Unit = {
    println(s)
  }
}
