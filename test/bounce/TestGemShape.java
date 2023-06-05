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
        assertEquals("(polygon 125,20,175,70,200,120,150,70)", painter.toString());
    }

    @Test
    public void testPaintRegularGemShape() {
        GemShape shape = new GemShape(50, 50, 4, 6);
        shape.paint(painter);
        assertEquals("(polygon 75,50,125,100,150,150,100,100)", painter.toString());
    }
}

