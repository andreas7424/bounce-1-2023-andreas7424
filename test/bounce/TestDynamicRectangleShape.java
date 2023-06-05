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
    public void testPaintSolidAfterBounceOffLeftWall() {
        DynamicRectangleShape shape = new DynamicRectangleShape(0, 20, -5, 0, Color.RED);
        shape.move(500, 500);
        shape.paint(painter);
        assertEquals("(filledRectangle 0,20,25,35,java.awt.Color[r=255,g=0,b=0])", painter.toString());
    }

    @Test
    public void testPaintSolidAfterBounceOffRightWall() {
        DynamicRectangleShape shape = new DynamicRectangleShape(475, 20, 5, 0, Color.BLUE);
        shape.move(500, 500);
        shape.paint(painter);
        assertEquals("(filledRectangle 475,20,25,35,java.awt.Color[r=0,g=0,b=255])", painter.toString());
    }

    @Test
    public void testPaintOutlineAfterBounceOffTopWall() {
        DynamicRectangleShape shape = new DynamicRectangleShape(20, 0, 0, -5, Color.GREEN);
        shape.move(500, 500);
        shape.paint(painter);
        assertEquals("(rectangle 20,0,25,35)", painter.toString());
    }

    @Test
    public void testPaintOutlineAfterBounceOffBottomWall() {
        DynamicRectangleShape shape = new DynamicRectangleShape(20, 465, 0, 5, Color.YELLOW);
        shape.move(500, 500);
        shape.paint(painter);
        assertEquals("(rectangle 20,465,25,35)", painter.toString());
    }

    @Test
    public void testPaintSolidAfterBounceOffTopRightCorners() {
        DynamicRectangleShape shape = new DynamicRectangleShape(475, 0, 5, -5, Color.CYAN);
        shape.move(500, 500);
        shape.paint(painter);
        assertEquals("(filledRectangle 475,0,25,35,java.awt.Color[r=0,g=255,b=255])", painter.toString());
    }

    @Test
    public void testPaintSolidAfterBounceOffTopLeftCorners() {
        DynamicRectangleShape shape = new DynamicRectangleShape(0, 0, -5, -5, Color.MAGENTA);
        shape.move(500, 500);
        shape.paint(painter);
        assertEquals("(filledRectangle 0,0,25,35,java.awt.Color[r=255,g=0,b=255])", painter.toString());
    }

    @Test
    public void testPaintOutlineAfterBounceOffBottomRightCorners() {
        DynamicRectangleShape shape = new DynamicRectangleShape(475, 465, 5, 5, Color.ORANGE);
        shape.move(500, 500);
        shape.paint(painter);
        assertEquals("(filledRectangle 475,465,25,35,java.awt.Color[r=255,g=200,b=0])", painter.toString());
    }

    @Test
    public void testPaintOutlineAfterBounceOffBottomLeftCorners() {
        DynamicRectangleShape shape = new DynamicRectangleShape(0, 465, -5, 5, Color.PINK);
        shape.move(500, 500);
        shape.paint(painter);
        assertEquals("(filledRectangle 0,465,25,35,java.awt.Color[r=255,g=175,b=175])", painter.toString());
    }
}
