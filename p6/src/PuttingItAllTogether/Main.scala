package PuttingItAllTogether

import scala.annotation.tailrec
import scala.collection.SortedMap

object Main extends App {

  val cont = Container("Name", Map())

  val options = SortedMap[Int, CommandLineOption](
    1 -> new CommandLineOption("Add", Container.addEntryG(IO_Utils.prompt("Key"), IO_Utils.prompt("Value"))),
    //TODO
    0 -> new CommandLineOption("Exit", _ => sys.exit)
  )

  mainLoop(cont)

  @tailrec
  def mainLoop(cont: Container): Unit = {
    IO_Utils.optionPrompt(options) match {
      case Some(opt) => val newCont = opt.exec(cont); mainLoop(newCont)
      case _ => println("Invalid option"); mainLoop(cont)
    }
  }


}
