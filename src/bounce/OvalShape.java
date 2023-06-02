package bounce;

public class OvalShape extends Shape {


    public OvalShape(int x, int y, int deltaX, int deltaY) {
        // Call the superclass Shape constructor to initialize the position and movement values
        super(x, y, deltaX, deltaY);
        width = 25; // Set the initial width
        height = 35; // Set the initial height
    }

    @Override
    public void paint(Painter painter) {
        painter.drawOval(x,y,width,height);
    }
}
