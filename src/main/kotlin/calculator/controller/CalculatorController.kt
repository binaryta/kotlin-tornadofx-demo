package calculator.controller
import javafx.event.ActionEvent
import javafx.scene.control.Label
import javafx.scene.control.TextField
import javafx.scene.layout.*
import com.jfoenix.controls.*
import tornadofx.*

class CalculatorController: View() {
  var result: Int =  0
  val count: Label by fxid()
  override val root: VBox by fxml("/Calculator.fxml")

  init {
    count.text = ""
    with(root) {
      root.prefWidth = 250.0
      root.prefHeight = 400.0
    }
  }

  /* 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 */
  fun onNumberClick(e: ActionEvent) {
    val text = e.getSource()
    if (text is JFXButton) count.text += text.getText()
  }

  /* + */
  fun onPlusClick() {
    if (count.text.isNullOrEmpty()) return
    result = count.text.toInt()
    count.text = ""
  }

  /* - */
  fun onMinusClick() {
    if (count.text.isNullOrEmpty()) return
    result = count.text.toInt()
    count.text = ""
  }

  /* x */
  fun onMultipliedClick() {
    if (count.text.isNullOrEmpty()) return
    count.text = (count.text.toInt() + 1).toString()
  }

  /* / */
  fun onDivideClick() {
    if (count.text.isNullOrEmpty()) return
    count.text = (count.text.toInt() + 1).toString()
  }

  fun onCalculateClick(e: ActionEvent) {
    if (count.text.isNullOrEmpty()) return
    result += count.text.toInt()
    count.text = result.toString()
  }

  fun onClearClick() {
    count.text = ""
    result = 0
  }
}
