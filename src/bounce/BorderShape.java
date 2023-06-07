package bounce;

import java.awt.Color;

public class BorderShape extends Shape {
    private Shape shape;
    private int borderWidth;

    // Constructor. This sets the inner shape and border width when a new BorderShape is created.
    public BorderShape(Shape shape, int borderWidth) {
        this.shape = shape;
        this.borderWidth = borderWidth;
        adjustPositionAndDimensions();
    }

    // This method paints the border shape. It paints the inner shape first, then draws the border.
    private void adjustPositionAndDimensions() {
        int shapeX = shape.x() - borderWidth;
        int shapeY = shape.y() - borderWidth;
        int shapeWidth = shape.width() + (2 * borderWidth);
        int shapeHeight = shape.height() + (2 * borderWidth);

        this.x = shapeX;
        this.y = shapeY;
        this.width = shapeWidth;
        this.height = shapeHeight;
    }

// Draw the border. It draws the border in multiple iterations to achieve the border width.
    @Override
    public void paint(Painter painter) {
        shape.paint(painter);
        for (int i = 0; i < borderWidth; i++) {
            int x = shape.x() - borderWidth + i;
            int y = shape.y() - borderWidth + i;
            int width = shape.width() + (2 * borderWidth) - (2 * i);
            int height = shape.height() + (2 * borderWidth) - (2 * i);

            painter.drawRect(x, y, width, height);
        }
    }

    @Override
    public void move(int width, int height) {
        shape.move(width, height);
        adjustPositionAndDimensions();
    }
}
