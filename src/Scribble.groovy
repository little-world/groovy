import groovy.swing.SwingBuilder

import static javax.swing.JFrame.*
import javax.swing.JComponent
import java.awt.Graphics
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import java.awt.event.MouseListener

SwingBuilder swing = new SwingBuilder()

abstract class Shape {
    int x1, y1, x2, y2
    abstract def draw(Graphics g);
}

class Rect extends Shape {
    def draw(Graphics g) {
        g.drawRect(x1, y1, x2 - x1, y2 - y1)
    }
}

class Oval extends Shape{
    def draw(Graphics g) {
        g.drawOval(x1, y1, x2 - x1, y2 - y1)
    }
}




class PaintPanel extends JComponent {
    def shp = new Oval()

    def drawing = new ArrayList<Shape>()

    @Override
    void paint(Graphics g) {
        for (Shape s: drawing)
            s.draw(g)
    }
}



def pp = new PaintPanel()

def frame = swing.frame(defaultCloseOperation: EXIT_ON_CLOSE, size: [300, 400], show: true) {
    widget(pp)
}

pp.addMouseListener([
         mousePressed : { evt ->
            if (evt.getButton() == MouseEvent.BUTTON1)
                 pp.shp = new Rect()
            else
                 pp.shp = new Oval()

            pp.drawing.add(pp.shp)
            pp.shp.x1 = evt.getX()
            pp.shp.y1 = evt.getY()
         },
         mouseReleased: { evt ->
             pp.shp.x2 = evt.getX()
             pp.shp.y2 = evt.getY()
             pp.repaint()
         },
         mouseEntered : { evt -> println('en') },
         mouseExited  : { evt -> println('ex') },
         mouseClicked : { evt -> println('clicked') },
        ] as MouseListener )


def adapter = new MouseAdapter() {

    @Override
    void mousePressed(MouseEvent e) {
        println("pressed")
    }

    @Override
    void mouseReleased(MouseEvent e) {
        println("releasee")

    }
}








