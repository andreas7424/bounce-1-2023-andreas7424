package bounce;

public class GemShape extends Shape {

    public GemShape(int x, int y, int deltaX, int deltaY) {
        super(x, y, deltaX, deltaY);
        width = 100; // Set the initial width
        height = 100; // Set the initial height
    }

    @Override
    public void paint(Painter painter) {
        int[] xPoints;
        int[] yPoints;

        if (width < 40) {
            xPoints = new int[]{x + width / 2, x, x + width / 2, x + width};
            yPoints = new int[]{y, y + height / 2, y + height, y + height / 2};
        } else {
            xPoints = new int[]{x + width / 4, x + width * 3 / 4, x + width, x + width / 2};
            yPoints = new int[]{y, y + height / 2, y + height, y + height / 2};
        }

        painter.drawPolygon(xPoints, yPoints, xPoints.length);
    }
}












