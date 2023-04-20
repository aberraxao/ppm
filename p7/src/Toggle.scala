import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.{Parent, Scene}
import javafx.stage.Stage

class ToggleApp extends Application {
  override def start(primaryStage: Stage): Unit = {
    primaryStage.setTitle("ToggleApp")
    val fxmlLoader =
      new FXMLLoader(getClass.getResource("Controller2.fxml"))
    val mainViewRoot: Parent = fxmlLoader.load()
    val scene = new Scene(mainViewRoot)
    primaryStage.setScene(scene)
    primaryStage.show()
  }
}

object TgApp {
  def main(args: Array[String]): Unit = {
    Application.launch(classOf[ToggleApp], args: _*)
  }
}