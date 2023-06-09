package bounce;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


/**
 * Simple GUI program to show an animation of shapes. Class AnimationViewer is
 * a special kind of GUI component (JPanel), and as such an instance of
 * AnimationViewer can be added to a JFrame object. A JFrame object is a
 * window that can be closed, minimised, and maximised. The state of an
 * AnimationViewer object comprises a list of Shapes and a Timer object. An
 * AnimationViewer instance subscribes to events that are published by a Timer.
 * In response to receiving an event from the Timer, the AnimationViewer iterates
 * through a list of Shapes requesting that each Shape paints and moves itself.
 *
 * @author Ian Warren
 */
@SuppressWarnings("serial")
public class AnimationViewer extends JPanel implements ActionListener {
    // Frequency in milliseconds for the Timer to generate events.
    private static final int DELAY = 20;

    // Collection of Shapes to animate.
    private List<Shape> shapes;

    private Timer timer = new Timer(DELAY, this);

    /**
     * Creates an AnimationViewer instance with a list of Shape objects and
     * starts the animation.
     */
    public AnimationViewer() {
        shapes = new ArrayList<Shape>();

        // Populate the list of Shapes.
        RectangleShape rectangleShape = new RectangleShape(0, 0, 2, 3);
        rectangleShape.setText("Rectangle");
        shapes.add(rectangleShape);


        OvalShape ovalShape = new OvalShape(50, 50, 4, 6);
        ovalShape.setText("Oval");
        shapes.add(ovalShape);

        GemShape gemShape = new GemShape(100, 20, 12, 15);
        gemShape.setText("Gem");
        shapes.add(gemShape);

        DynamicRectangleShape dynamicRectangleShape = new DynamicRectangleShape(200, 200, 3, 2, Color.RED);
        dynamicRectangleShape.setText("Dynamic Rectangle");
        shapes.add(dynamicRectangleShape);

        // Create a RectangleShape and wrap it with a BorderShape
        RectangleShape borderRectangle = new RectangleShape(200, 200, 3, 2);
        borderRectangle.setText("Border Rectangle");
        BorderShape borderShape = new BorderShape(borderRectangle, 2);
        shapes.add(borderShape);

        // Create a NestingShape and add some shapes to it.
        NestingShape nestingShape = new NestingShape(30, 30, 2, 2, 50, 50);
        OvalShape nestedOvalShape = new OvalShape(5, 5, 2, 2);
        nestedOvalShape.setText("Nested Oval");
        RectangleShape nestedRectangleShape = new RectangleShape(5, 5, 2, 2, 20, 20);
        nestedRectangleShape.setText("Nested Rectangle");
        nestingShape.add(nestedOvalShape);
        nestingShape.add(nestedRectangleShape);
        nestingShape.setText("Nesting Shape");
        shapes.add(nestingShape);

        timer.start();
    }

    /**
     * Called by the Swing framework whenever this AnimationViewer object
     * should be repainted. This can happen, for example, after an explicit
     * repaint() call or after the window that contains this AnimationViewer
     * object has been opened, exposed or moved.
     */
    public void paintComponent(Graphics g) {
        // Call inherited implementation to handle background painting.
        super.paintComponent(g);

        // Calculate bounds of animation screen area.
        int width = getSize().width;
        int height = getSize().height;

        // Create a GraphicsPainter that Shape objects will use for drawing.
        // The GraphicsPainter delegates painting to a basic Graphics object.
        Painter painter = new GraphicsPainter(g);

        // Progress the animation.
        for (Shape s : shapes) {
            s.paint(painter);
            s.move(width, height);
        }
    }

    /**
     * Notifies this AnimationViewer object of an ActionEvent. ActionEvents are
     * received by the Timer.
     */
    public void actionPerformed(ActionEvent e) {
        // Request that the AnimationViewer repaints itself. The call to
        // repaint() will cause the AnimationViewer's paintComponent() method
        // to be called.
        repaint();
    }


    /**
     * Main program method to create an AnimationViewer object and display this
     * within a JFrame window.
     */
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Animation viewer");
                frame.add(new AnimationViewer());

                // Set window properties.
                frame.setSize(500, 500);
                frame.setLocationRelativeTo(null);
                frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}
