package bounce;

import static org.junit.Assert.assertEquals;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;

public class TestDynamicRectangleShape {
    private MockPainter painter;

    @Before
    public void setUp() {
        painter = new MockPainter();
    }

    @Test
    public void testBounceOffLeft() {
        DynamicRectangleShape shape = new DynamicRectangleShape(100, 20, -12, 15, Color.RED);
        shape.paint(painter);
        shape.move(200, 200);
        shape.paint(painter);
        assertEquals("(rectangle 100,20,25,35)(setColor java.awt.Color[r=255,g=0,b=0])(filled rectangle 88,35,25,35)(setColor java.awt.Color[r=0,g=0,b=0])", painter.toString());
    }

    @Test
    public void testBounceOffRight() {
        DynamicRectangleShape shape = new DynamicRectangleShape(100, 20, 12, 15, Color.RED);
        shape.paint(painter);
        shape.move(200, 200);
        shape.paint(painter);
        assertEquals("(rectangle 100,20,25,35)(setColor java.awt.Color[r=255,g=0,b=0])(filled rectangle 112,35,25,35)(setColor java.awt.Color[r=0,g=0,b=0])", painter.toString());
    }

    @Test
    public void testBounceOffTop() {
        DynamicRectangleShape shape = new DynamicRectangleShape(100, 20, 12, -15, Color.RED);
        shape.paint(painter);
        shape.move(200, 200);
        shape.paint(painter);
        assertEquals("(rectangle 100,20,25,35)(rectangle 112,5,25,35)", painter.toString());
    }

    @Test
    public void testBounceOffBottom() {
        DynamicRectangleShape shape = new DynamicRectangleShape(100, 20, 12, 15, Color.RED);
        shape.paint(painter);
        shape.move(200, 200);
        shape.paint(painter);
        assertEquals("(rectangle 100,20,25,35)(rectangle 112,35,25,35)", painter.toString());
    }

    // Now for the corners, remember the vertical wall determines the appearance

    @Test
    public void testBounceOffTopRight() {
        DynamicRectangleShape shape = new DynamicRectangleShape(100, 20, 12, -15, Color.RED);
        shape.paint(painter);
        shape.move(200, 200);
        shape.paint(painter);
        assertEquals("(rectangle 100,20,25,35)(setColor java.awt.Color[r=255,g=0,b=0])(filled rectangle 112,5,25,35)(setColor java.awt.Color[r=0,g=0,b=0])", painter.toString());
    }
    @Test
    public void testBounceOffTopLeft() {
        DynamicRectangleShape shape = new DynamicRectangleShape(100, 20, -12, -15, Color.RED);
        shape.paint(painter);
        shape.move(200, 200);
        shape.paint(painter);
        assertEquals("(rectangle 100,20,25,35)(setColor java.awt.Color[r=255,g=0,b=0])(filled rectangle 88,5,25,35)(setColor java.awt.Color[r=0,g=0,b=0])", painter.toString());
    }

    @Test
    public void testBounceOffBottomRight() {
        DynamicRectangleShape shape = new DynamicRectangleShape(100, 20, 12, 15, Color.RED);
        shape.paint(painter);
        shape.move(200, 200);
        shape.paint(painter);
        assertEquals("(rectangle 100,20,25,35)(setColor java.awt.Color[r=255,g=0,b=0])(filled rectangle 112,35,25,35)(setColor java.awt.Color[r=0,g=0,b=0])", painter.toString());
    }

    @Test
    public void testBounceOffBottomLeft() {
        DynamicRectangleShape shape = new DynamicRectangleShape(100, 20, -12, 15, Color.RED);
        shape.paint(painter);
        shape.move(200, 200);
        shape.paint(painter);
        assertEquals("(rectangle 100,20,25,35)(setColor java.awt.Color[r=255,g=0,b=0])(filled rectangle 88,35,25,35)(setColor java.awt.Color[r=0,g=0,b=0])", painter.toString());
    }
// Add more test cases for other bounce scenarios
}
