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

    // This method is called when the rectangle needs to be drawn. Depending on the current state, it will either draw only the outline or a filled rectangle.
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
    // This method is called when the rectangle moves. It first calls the superclass method to perform the actual move, then it checks if the rectangle has hit any of the sides of the window. If it hits the left or right side, the rectangle is set to be drawn filled in, if it hits the top or bottom side, it is set to be drawn as an outline.
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
