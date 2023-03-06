

import groovy.swing.*
import javax.swing.*

SwingBuilder swing = new SwingBuilder()

String operator
String number1Str

def calculation = { evt ->
    String btnLabel = evt.getActionCommand()

    switch (btnLabel) {
        case "0".."9":
            // number state
            textlabel.text += btnLabel
            println("number $btnLabel")
            break
        case ["/", "*", "+", "-"]:
            // operator state
            println("operator $btnLabel")
            operator = btnLabel
            number1Str = textlabel.text
            textlabel.text = ''
            break
        case "=":
            // calculation state
            int number1 = number1Str.toInteger()
            int number2 = textlabel.text.toInteger()
            int result
            switch (operator) {
                case "+":
                    result = number1 + number2
                    break
                case "-":
                    result = number1 - number2
                    break
                case "*":
                    result = number1 * number2
                    break
                case "/":
                    result = number1 / number2
                    break
            }
            textlabel.text = result.toString()
            break
        default:
            println("error")
    }
}

swing.frame(defaultCloseOperation: JFrame.EXIT_ON_CLOSE, pack: true, show: true) {
    textlabel = label('' )
    panel(layout: gridLayout(columns: 4, rows: 4)) {
        ["7", "8", "9", "/",
         "4", "5", "6", "*",
         "1", "2", "3", "_",
         "C", "0", "=", "+",
        ].each {
            button(
                    text: it,
                    actionPerformed: {evt -> calculation(evt)}
            )
        }
    }
}

