import javafx.fxml.FXML
import javafx.scene.control.{Button, Label, TextField}

class Controller {

  @FXML
  private var button1: Button = _
  @FXML
  private var buttonClickMe: Button = _
  @FXML
  private var buttonToggle: Button = _
  @FXML
  private var textField1: TextField = _
  @FXML
  private var label1: Label = _

  def onButton1Clicked(): Unit = {
    textField1.setText("Hello World")
  }

  def onbuttonClickMeClicked(): Unit = {
    buttonClickMe.setText("Clicked")
    buttonClickMe.setOpacity(0.5)
  }

  def onButtonToggleToggled(): Unit = {
    label1.setVisible(true)
  }

  def onButtonToggleUntoggled(): Unit = {
    label1.setVisible(false)
  }

}
