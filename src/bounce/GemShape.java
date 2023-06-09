package bounce;

public class GemShape extends Shape {

    // Constructor for GemShape. Sets the initial position of the GemShape, as well as initial width and height.
    public GemShape(int x, int y, int deltaX, int deltaY) {
        super(x, y, deltaX, deltaY);
        width = 100; // Set the initial width
        height = 100; // Set the initial height
    }

    @Override
    public void paint(Painter painter) {
        super.paint(painter);
        int[] xPoints;
        int[] yPoints;

        // If the width of the GemShape is less than 40, make it a diamond shape
        if (width < 40) {
            xPoints = new int[]{x + width / 2, x, x + width / 2, x + width};
            yPoints = new int[]{y, y + height / 2, y + height, y + height / 2};
            // If the width of the GemShape is 40 or more, make it a hexagonal shape
        } else {
            xPoints = new int[]{x + width / 4, x + width / 4, x + width / 2, x + width * 3 / 4, x + width * 3 / 4, x + width / 2};
            yPoints = new int[]{y, y + height / 2, y + height, y + height / 2, y, y - height / 2};
        }

        painter.drawPolygon(xPoints, yPoints, xPoints.length);
    }
}












