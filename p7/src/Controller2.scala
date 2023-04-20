import javafx.fxml.FXML
import javafx.scene.control.{Button, Label, TextField}

class Controller2 {

  @FXML
  private var buttonClickMe: Button = _
  @FXML
  private var label1: Label = _

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
