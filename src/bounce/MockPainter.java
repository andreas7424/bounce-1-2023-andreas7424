package bounce;


import java.awt.*;

/**
 * Implementation of the Painter interface that does not actually do any
 * painting. A MockPainter implementation responds to Painter requests by
 * logging simply logging them. The contents of a MockPainter object's
 * log can be retrieved by a call to toString() on the MockPainter.
 *
 * @author Ian Warren
 */
public class MockPainter implements Painter {
    // Internal log.
    private StringBuffer log = new StringBuffer();
    private Color color;

    /**
     * Returns the contents of this MockPainter's log.
     */
    public String toString() {
        return log.toString();
    }


        /**
         * Logs the drawRect call.
         */
        public void drawRect ( int x, int y, int width, int height){
            log.append("(rectangle " + x + "," + y + "," + width + "," + height + ")");
        }

        /**
         * Logs the drawOval call.
         */
        public void drawOval ( int x, int y, int width, int height){
            log.append("(oval " + x + "," + y + "," + width + "," + height + ")");
        }


    public void drawPolygon(int[] xPoints, int[] yPoints, int numPoints) {
        log.append("(polygon ");
        for (int i = 0; i < numPoints; i++) {
            if (i > 0) {
                log.append(",");
            }
            log.append(xPoints[i]).append(",").append(yPoints[i]);
        }
        log.append(")");
    }


    public void fillRect(int x, int y, int width, int height) {
        log.append("(filledRectangle " + x + "," + y + "," + width + "," + height + "," + getColor() + ")");

    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public void translate(int x, int y) {

    }
}