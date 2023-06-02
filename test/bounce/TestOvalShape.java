package bounce;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


/**
 * A class that implements test cases aimed at identifying bugs in the
 * implementations of classes Shape and RectangleShape.
 *
 * @author Ian Warren
 */
public class TestOvalShape {
    // Fixture object that is used by the tests.
    private MockPainter painter;

    /**
     * This method is called automatically by the JUnit test-runner immediately
     * before each @Test method is executed. setUp() recreates the fixture so
     * that there no side effects from running individual tests.
     */
    @Before
    public void setUp() {

        painter = new MockPainter();
    }

    /**
     * Test to perform a simple (non-bouncing) movement, and to ensure that a
     * Shape's position after the movement is correct.
     */
    @Test
    public void testSimpleMove() {
        OvalShape shape = new OvalShape(100, 20, 12, 15);
        shape.paint(painter);
        shape.move(500, 500);
        shape.paint(painter);
        assertEquals("(oval 100,20,25,35)(oval 112,35,25,35)", painter.toString());
    }

    /**
     * Test to perform a bounce movement off the right-most boundary and to
     * ensure that the Shape's position after the movement is correct.
     */
    @Test
    public void testShapeMoveWithBounceOffRight() {
        OvalShape shape = new OvalShape(100, 20, 12, 15);
        shape.paint(painter);
        shape.move(135, 10000);
        shape.paint(painter);
        shape.move(135, 10000);
        shape.paint(painter);
        assertEquals("(oval 100,20,25,35)(oval 110,35,25,35)(oval 98,50,25,35)", painter.toString());
    }

    /**
     * Test to perform a bounce movement off the left-most boundary and to
     * ensure that the Shape's position after the movement is correct.
     */
    @Test
    public void testShapeMoveWithBounceOffLeft() {
        OvalShape shape = new OvalShape(10, 20, -12, 15);
        shape.paint(painter);
        shape.move(10000, 10000);
        shape.paint(painter);
        shape.move(10000, 10000);
        shape.paint(painter);
        assertEquals("(oval 10,20,25,35)(oval 0,35,25,35)(oval 12,50,25,35)", painter.toString());
    }

    /**
     * Test to perform a bounce movement off the bottom right corner and to
     * ensure that the Shape's position after the movement is correct.
     */
    @Test
    public void testShapeMoveWithBounceOffBottomAndRight() {
        OvalShape shape = new OvalShape(90, 90, 12, 15);
        shape.paint(painter);
        shape.move(125, 135);
        shape.paint(painter);
        shape.move(125, 135);
        shape.paint(painter);
        assertEquals("(oval 90,90,25,35)(oval 100,100,25,35)(oval 88,85,25,35)", painter.toString());
    }
}
