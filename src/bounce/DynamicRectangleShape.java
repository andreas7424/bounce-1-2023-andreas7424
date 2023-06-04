package bounce;

import java.awt.Color;

public class DynamicRectangleShape extends Shape {
    private Color fillColor;
    private boolean solid;

    public DynamicRectangleShape(int x, int y, int deltaX, int deltaY) {
        super(x, y, deltaX, deltaY);
        this.fillColor = Color.BLACK;
        this.solid = true;
    }

    public DynamicRectangleShape(int x, int y, int deltaX, int deltaY, Color fillColor) {
        super(x, y, deltaX, deltaY);
        this.fillColor = fillColor;
        this.solid = true;
    }

    @Override
    public void move(int width, int height) {
        super.move(width, height);

        // Check if bouncing off the left or right wall
        if (x == 0 || x + width == width - this.width) {
            solid = true;
        }

        // Check if bouncing off the top or bottom wall
        if (y == 0 || y + height == height - this.height) {
            solid = false;
        }
    }

    @Override
    public void paint(Painter painter) {
        if (solid) {
            painter.setColor(fillColor);
            painter.fillRect(x, y, width, height);
            painter.setColor(Color.BLACK);
        } else {
            painter.drawRect(x, y, width, height);
        }
    }
}
