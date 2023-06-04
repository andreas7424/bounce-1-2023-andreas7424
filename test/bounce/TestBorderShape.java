package bounce;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestBorderShape {
    private MockPainter painter;

    @Before
    public void setUp() {
        painter = new MockPainter();
    }

    @Test
    public void testMove() {
        RectangleShape shape = new RectangleShape(100, 100, 5, 5);
        BorderShape borderShape = new BorderShape(shape, 2);
        borderShape.move(500, 500);
        assertEquals(105, shape.x());
        assertEquals(105, shape.y());
        assertEquals(25, shape.width());
        assertEquals(25, shape.height());
    }

    @Test
    public void testPaint() {
        RectangleShape shape = new RectangleShape(100, 100, 5, 5);
        BorderShape borderShape = new BorderShape(shape, 2);
        borderShape.paint(painter);
        assertEquals("(rectangle 98,98,29,29)(rectangle 100,100,25,25)", painter.toString());
    }
}
