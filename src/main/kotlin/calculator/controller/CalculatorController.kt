package calculator.controller
import javafx.event.ActionEvent
import javafx.scene.control.Label
import javafx.scene.control.TextField
import javafx.scene.layout.*
import com.jfoenix.controls.*
import tornadofx.*

class CalculatorController: View() {
  var result: Int =  0
  var operation: String = ""
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

  /* +, -, x, ÷  */
  fun onOperationClick(e: ActionEvent) {
    if (count.text.isNullOrEmpty()) return
    result = count.text.toInt()

    count.text = ""
    val text = e.getSource()
    if (text is JFXButton) {
      println(text.getText())
      operation = text.getText()
    }
  }

  fun onCalculateClick() {
    if (count.text.isNullOrEmpty()) return
    when (operation) {
      "+" -> {
        result += count.text.toInt()
      }
      "-" -> {
        result -= count.text.toInt()
      }
      "x" -> {
        println("kakeru")
        result *= count.text.toInt()
      }
      "÷" -> {
        println("waru")
        result /= count.text.toInt()
      }
    }
    count.text = result.toString()
  }

  fun onClearClick() {
    count.text = ""
    result = 0
  }
}
