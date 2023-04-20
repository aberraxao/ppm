import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.{Parent, Scene}
import javafx.stage.Stage

class ToggleGroupApp extends Application {
  override def start(primaryStage: Stage): Unit = {
    primaryStage.setTitle("Toggle Group App")
    val fxmlLoader =
      new FXMLLoader(getClass.getResource("Controller3.fxml"))
    val mainViewRoot: Parent = fxmlLoader.load()
    val scene = new Scene(mainViewRoot)
    primaryStage.setScene(scene)
    primaryStage.show()
  }
}

object FxTgGroupApp {
  def main(args: Array[String]): Unit = {
    Application.launch(classOf[ToggleGroupApp], args: _*)
  }
}