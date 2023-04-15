package PuttingItAllTogether

case class Container(name:String, data : Map[String, String]){

}

object Container {

  def addEntryG(key: => String, value: =>String)(container: Container): Container =
  {
    new Container(container.name, container.data + (key -> value))
  }

  /*
  def addEntry(container: Container): Container =
  {
    val key:String = IO_Utils.prompt("Key")
    val value: String = IO_Utils.prompt("Value")

    new Container(container.name, container.data + (key -> value))
  }
   */


  //TODO

}
