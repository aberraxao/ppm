import javafx.fxml.FXML
import javafx.scene.Scene
import javafx.scene.control.{Button, Label}
import javafx.scene.layout.HBox
import javafx.stage.Stage

class GUI_1 {

  @FXML
  private var button1:Button = _

  def onButton1Clicked(): Unit = {
    val secondStage: Stage = new Stage()
    secondStage.setScene(new Scene(new HBox(4, new Label("Second window"))))
    secondStage.show()
  }

}
