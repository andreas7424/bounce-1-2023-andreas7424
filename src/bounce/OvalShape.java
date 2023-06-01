package bounce;

public class OvalShape extends Shape {


    @Override
    public void paint(Painter painter) {
        painter.drawOval(x,y,width,height);
    }
}
