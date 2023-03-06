import groovy.swing.SwingBuilder
import javax.swing.*
import java.awt.*
import java.awt.event.ActionEvent

def swing = new SwingBuilder()

def sharedPanel = {
    swing.panel() {
        label("Shared Panel")
    }
}



count = 0

def calculation = { evt ->
    count++
    textlabel.text = "Clicked ${count} time(s)."
    println "Clicked!"
}


swing.edt {
    frame(title: 'Frame', defaultCloseOperation: JFrame.EXIT_ON_CLOSE, pack: true, show: true) {
        vbox {
            textlabel = label('Click the button!')
            button(
                    text: 'Click Me',
                    actionPerformed: {evt -> calculation(evt)}
            )
            widget(sharedPanel())
            widget(sharedPanel())
        }
    }
}





