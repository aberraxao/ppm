import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.{Parent, Scene}
import javafx.stage.Stage

class App2 extends Application {
  override def start(primaryStage: Stage): Unit = {
    primaryStage.setTitle("Fx App")
    val fxmlLoader = new FXMLLoader(getClass.getResource("GUI_3.fxml"))
    val mainViewRoot: Parent = fxmlLoader.load()
    val scene = new Scene(mainViewRoot)
    primaryStage.setScene(scene)
    primaryStage.show()
  }
}

object FxApp2 {
  def main(args: Array[String]): Unit = {
    Application.launch(classOf[App2], args: _*)
  }
}