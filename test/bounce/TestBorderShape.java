package bounce;

import static org.junit.Assert.assertEquals;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;

public class TestBorderShape {
    private MockPainter painter;

    @Before
    public void setUp() {
        painter = new MockPainter();
    }

    @Test
    public void testPaintBorderAroundRectangleShape() {
        Shape rectangleShape = new RectangleShape(50, 50, 3, 2);
        BorderShape borderShape = new BorderShape(rectangleShape, 2);

        borderShape.paint(painter);

        assertEquals("(rectangle 50,50,25,35)(rectangle 48,48,29,39)(rectangle 49,49,27,37)", painter.toString());
    }

    @Test
    public void testPaintMultipleBordersAroundRectangleShape() {
        Shape rectangleShape = new RectangleShape(50, 50, 3, 2);
        BorderShape borderShape1 = new BorderShape(rectangleShape, 2);
        BorderShape borderShape2 = new BorderShape(borderShape1, 4);

        borderShape2.paint(painter);

        assertEquals(
                "(rectangle 50,50,25,35)(rectangle 48,48,29,39)(rectangle 49,49,27,37)(rectangle 44,44,37,47)(rectangle 45,45,35,45)(rectangle 46,46,33,43)(rectangle 47,47,31,41)",
                painter.toString()
        );
    }

}



