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
        assertEquals("(polygon 125,20,125,70,150,120,175,70,175,20,150,-30)", painter.toString());
    }

    @Test
    public void testPaintRegularGemShape() {
        GemShape shape = new GemShape(50, 50, 4, 6);
        shape.paint(painter);
        assertEquals("(polygon 75,50,75,100,100,150,125,100,125,50,100,0)", painter.toString());
    }
}


