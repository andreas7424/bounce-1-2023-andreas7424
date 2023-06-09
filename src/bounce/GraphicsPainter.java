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

    @Override
    public void translate(int x, int y) {
        g.translate(x, y);

    }
    @Override
    public void drawCentredText(String text, int x, int y, int width, int height) {
        // Determine the width of the text to be drawn, so can position correctly
        FontMetrics metrics = g.getFontMetrics();
        int textWidth = metrics.stringWidth(text);

        // Calculate the position to start the text, such that it's centered in the Shape
        int startX = x + width / 2 - textWidth / 2;
        int startY = y + height / 2;

        g.drawString(text, startX, startY);
    }


    }









