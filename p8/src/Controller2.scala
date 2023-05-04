import javafx.fxml.FXML
import javafx.scene.AmbientLight
import javafx.scene.control.Slider
import javafx.scene.shape.Box
import javafx.scene.transform.Rotate

class Controller2 {

  @FXML
  private var ambientLight: AmbientLight = _
  @FXML
  private var box: Box = _
  @FXML
  private var slider: Slider = _

  def onLightOnClicked(): Unit = {
    ambientLight.setLightOn(true)
  }

  def onLightOffClicked(): Unit = {
    ambientLight.setLightOn(false)
  }

  def onMouseDragged(): Unit = {
    box.setRotationAxis(Rotate.X_AXIS)
    box.setRotate(slider.getValue)
  }
}
