package bounce;

import java.awt.*;

/**
 * Interface to represent a type that offers primitive drawing methods.
 *
 * @author Ian Warren
 */
public interface Painter {
    /**
     * Draws a rectangle. Parameters x and y specify the top left corner of the
     * oval. Parameters width and height specify its width and height.
     */
    public void drawRect(int x, int y, int width, int height);

    /**
     * Draws an oval. Parameters x and y specify the top left corner of the
     * oval. Parameters width and height specify its width and height.
     */
    public void drawOval(int x, int y, int width, int height);

    void drawPolygon(int[] xPoints, int[] yPoints, int i);
    public void fillRect(int x, int y, int width, int height);
    public Color getColor();
    void setColor(Color color);

    void translate(int x, int y);

    void drawCentredText(String text, int x, int y, int width, int height);

}
