import javafx.fxml.FXML
import javafx.scene.control.{Button, Label, TextField}

class Controller {

  @FXML
  private var textField1: TextField = _

  def onButton1Clicked(): Unit = {
    textField1.setText("Hello World")
  }

}
