package bounce;

import java.awt.Color;

public class DynamicRectangleShape extends Shape {
    private Color fillColor;
    private boolean outlineOnly;// Boolean to check if we only want to draw the outline of the rectangle

    public DynamicRectangleShape(int x, int y, int deltaX, int deltaY, Color fillColor) {
        super(x, y, deltaX, deltaY);
        this.fillColor = fillColor;
        this.outlineOnly = true;
    }

    @Override
    public void paint(Painter painter) {
        if (outlineOnly) {
            painter.drawRect(x, y, width, height);
        } else {
            painter.setColor(fillColor);
            painter.fillRect(x, y, width, height);
            painter.setColor(Color.BLACK); // Reset color to black
        }
    }

    @Override
    public void move(int width, int height) {
        super.move(width, height);

        if (x == 0 || x + this.width == width) {
            outlineOnly = false; // Bounce off left or right wall, switch to solid figure
        } else if (y == 0 || y + this.height == height) {
            outlineOnly = true; // Bounce off top or bottom wall, switch to outline only
        }
    }
}
