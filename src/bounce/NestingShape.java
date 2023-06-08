package bounce;

import java.util.*;

public class NestingShape extends Shape {

    private List<Shape> children;

    public NestingShape(int x, int y, int deltaX, int deltaY, int width, int height) {
        super(x, y, deltaX, deltaY, width, height);
        this.children = new ArrayList<>();
    }

    public void add(Shape shape) {
        if (!shape.fitsWithinBounds(this.width(), this.height())) {
            throw new IllegalArgumentException("Shape doesn't fit within the bounds");
        }
        if (shape.parent() != null) {
            throw new IllegalArgumentException("Shape is already part of a NestingShape");
        }
        shape.setParent(this);
        children.add(shape);
    }

    public void remove(Shape shape) {
        shape.setParent(null);
        children.remove(shape);
    }

    public Shape shapeAt(int index) {
        return children.get(index);
    }

    public int shapeCount() {
        return children.size();
    }

    public int indexOf(Shape shape) {
        return children.indexOf(shape);
    }

    public boolean contains(Shape shape) {
        return children.contains(shape);
    }

    @Override
    public void move(int width, int height) {
        super.move(width, height);
        for (Shape shape : children) {
            shape.move(this.width(), this.height());
        }
    }

    @Override
    public void paint(Painter painter) {
        painter.drawRect(this.x(), this.y(), this.width(), this.height());
        painter.translate(this.x(), this.y());
        for (Shape shape : children) {
            shape.paint(painter);
        }
        painter.translate(-this.x(), -this.y());
    }
}
