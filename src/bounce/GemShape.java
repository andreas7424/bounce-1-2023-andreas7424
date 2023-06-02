package bounce;

public class GemShape extends Shape {

    public GemShape(int x, int y, int deltaX, int deltaY) {
        super(x, y, deltaX, deltaY);
        width = 40; // Set the initial width
        height = 40; // Set the initial height
    }

    @Override
    public void paint(Painter painter) {
        int[] xPoints;
        int[] yPoints;

        // Check if the width is less than 40 pixels to determine the shape type
        if (width < 40) {
            xPoints = new int[]{x, x + width / 2, x + width, x + width / 2};
            yPoints = new int[]{y + height / 2, y, y + height / 2, y + height};
        } else {
            xPoints = new int[]{x + 20, x + width / 2, x + width - 20, x + width / 2};
            yPoints = new int[]{y, y + height / 2, y, y + height};
        }

        // Use the provided Painter object to draw a polygon shape (gem) based on the points
        painter.drawPolygon(xPoints, yPoints, 4);
    }
}