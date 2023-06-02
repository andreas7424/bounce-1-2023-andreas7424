package bounce;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestGemShape {
    private MockPainter painter;

    @Before
    public void setUp() {
        painter = new MockPainter();
    }

    @Test
    public void testPaintSmallGemShape() {
        GemShape shape = new GemShape(100, 20, 12, 15);
        shape.paint(painter);
        assertEquals("(polygon 110,20,130,20,140,60,120,40)", painter.toString());
    }

    @Test
    public void testPaintRegularGemShape() {
        GemShape shape = new GemShape(50, 50, 4, 6);
        shape.paint(painter);
        assertEquals("(polygon 60,50,80,50,90,90,70,70)", painter.toString());
    }
}
