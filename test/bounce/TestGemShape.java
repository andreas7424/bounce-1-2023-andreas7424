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
        assertEquals("(polygon 100,25,110,20,120,25,110,30)", painter.toString());
    }

    @Test
    public void testPaintRegularGemShape() {
        GemShape shape = new GemShape(50, 50, 4, 6);
        shape.paint(painter);
        assertEquals("(polygon 70,50,65,65,85,65,80,50)", painter.toString());
    }
}
