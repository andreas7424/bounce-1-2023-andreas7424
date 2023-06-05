package bounce;

import java.awt.Color;

public class BorderShape extends Shape {
    private Shape shape;
    private int borderWidth;

    public BorderShape(Shape shape, int borderWidth) {
        this.shape = shape;
        this.borderWidth = borderWidth;
        adjustPositionAndDimensions();
    }

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
