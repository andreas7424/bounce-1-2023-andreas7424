package bounce;

import java.awt.*;

/**
 * Implementation of the Painter interface that delegates drawing to a
 * java.awt.Graphics object.
 *
 * @author Ian Warren
 */
public class GraphicsPainter implements Painter {
    // Delegate object.
    private Graphics g;
    private Color color;

    /**
     * Creates a GraphicsPainter object and sets its Graphics delegate.
     */
    public GraphicsPainter(Graphics g) {
        this.g = g;
    }

    /**
     * see bounce.Painter.drawRect
     */
    public void drawRect(int x, int y, int width, int height) {

        g.drawRect(x, y, width, height);
    }

    /**
     * see bounce.Painter.drawOval
     */
    public void drawOval(int x, int y, int width, int height) {

        g.drawOval(x, y, width, height);
    }

    @Override
    public void drawPolygon(int[] xPoints, int[] yPoints, int numPoints) {
        g.drawPolygon(xPoints, yPoints, numPoints);
    }

    public void fillRect(int x, int y, int width, int height) {
        g.fillRect(x, y, width, height);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
        g.setColor(color);
    }
}







