package bounce;

public class BorderShape extends Shape {
    private Shape shape;
    private int borderWidth;

    public BorderShape(Shape shape, int borderWidth) {
        this.shape = shape;
        this.borderWidth = borderWidth;
    }

    @Override
    public void move(int width, int height) {
        shape.move(width, height);
        adjustBounds();
    }

    @Override
    public void paint(Painter painter) {
        shape.paint(painter);
        painter.drawRect(x, y, width, height);
    }

    private void adjustBounds() {
        x = shape.x() - borderWidth;
        y = shape.y() - borderWidth;
        width = shape.width() + 2 * borderWidth;
        height = shape.height() + 2 * borderWidth;
    }
}
