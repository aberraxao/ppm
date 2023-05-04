import javafx.fxml.{FXML, FXMLLoader}
import javafx.scene.{Parent, Scene}
import javafx.scene.control.{Button, Label}
import javafx.scene.layout.HBox
import javafx.stage.Stage

class Controller {

  @FXML
  private var button1: Button = _


  def onButton1Clicked(): Unit = {
    /*
    val secondStage: Stage = new Stage()
    secondStage.setScene(new Scene(new HBox(4, new Label("Second window"))))
    secondStage.show()
   */
    val secondStage: Stage = new Stage()
    val fxmlLoader = new FXMLLoader(getClass.getResource("GUI_2.fxml"))
    val mainViewRoot: Parent = fxmlLoader.load()
    val scene = new Scene(mainViewRoot)
    secondStage.setScene(scene)
    secondStage.show()
  }

}
