package bounce;

import java.awt.Color;

public class DynamicRectangleShape extends Shape {
    private Color fillColor;
    private boolean isFilled;

    public DynamicRectangleShape(int x, int y, int deltaX, int deltaY, int width, int height, Color fillColor) {
        super(x, y, deltaX, deltaY, width, height);
        this.fillColor = fillColor;
        this.isFilled = false; // Initially, the shape is not filled
    }

    @Override
    public void paint(Painter painter) {
        if (isFilled) {
            // If the shape is filled, use the fillRect method of the painter
            painter.setColor(fillColor);
            painter.fillRect(x, y, width, height);
        } else {
            // If the shape is not filled, use the drawRect method of the painter
            painter.setColor(Color.BLACK); // Use black color for outline
            painter.drawRect(x, y, width, height);
        }
    }

    @Override
    public void move(int width, int height) {
        // Update the shape's position
        super.move(width, height);

        // Check if the shape has bounced off the walls
        if (x <= 0 || x + width >= width) {
            // Bounced off the left or right wall, change appearance to filled
            isFilled = true;
        } else if (y <= 0 || y + height >= height) {
            // Bounced off the top or bottom wall, change appearance to outline
            isFilled = false;
        }
    }
}

