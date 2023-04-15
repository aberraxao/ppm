package PuttingItAllTogether

import scala.annotation.tailrec
import scala.collection.SortedMap

object Main extends App {

  val cont = Container("Name", Map())

  val options = SortedMap[Int, CommandLineOption](
    1 -> new CommandLineOption("Add", Container.addEntry(IO_Utils.prompt("Key"),
      IO_Utils.prompt("Value"))),
    2 -> CommandLineOption("Remove", Container.removeEntry(IO_Utils.prompt("Key"))),
    3 -> CommandLineOption("Update", Container.updateEntry(IO_Utils.prompt("Key"),
      IO_Utils.prompt("Value"))),
    4 -> CommandLineOption("Show map content", IO_Utils.printContainer),
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
