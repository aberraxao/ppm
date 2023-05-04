import javafx.fxml.{FXML, FXMLLoader}
import javafx.scene.{Parent, Scene}
import javafx.scene.control.Button
import javafx.stage.{Modality, Stage}

class Controller {

  @FXML
  private var button1: Button = _
  @FXML
  private  var close:Button = _


  def onButton1Clicked(): Unit = {
    /*
    val secondStage: Stage = new Stage()
    secondStage.setScene(new Scene(new HBox(4, new Label("Second window"))))
    secondStage.show()
   */
    val secondStage: Stage = new Stage()
    secondStage.initOwner(button1.getScene().getWindow)
    secondStage.initModality(Modality.WINDOW_MODAL)
    val fxmlLoader = new FXMLLoader(getClass.getResource("GUI_2.fxml"))
    val mainViewRoot: Parent = fxmlLoader.load()
    val scene = new Scene(mainViewRoot)
    secondStage.setScene(scene)
    secondStage.show()
  }

  def onClosedButtonClicked() : Unit ={
    // The name of the method is misleading because it actually closes the window
    close.getScene.getWindow.hide()
  }

}
