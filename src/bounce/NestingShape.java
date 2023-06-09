package bounce;

import java.util.*;

public class NestingShape extends Shape {

    // children is a List that holds all the shapes contained by this NestingShape.
    private List<Shape> children;

    // Constructor initialises the NestingShape with specified position, speed, and size, and initialises the children List.
    public NestingShape(int x, int y, int deltaX, int deltaY, int width, int height) {
        super(x, y, deltaX, deltaY, width, height);
        this.children = new ArrayList<>();
    }


    // add() method attempts to add a shape to this NestingShape.
    public void add(Shape shape) {
        // If the shape is too large to fit within this NestingShape, an exception is thrown.
        if (!shape.fitsWithinBounds(this.width(), this.height())) {
            throw new IllegalArgumentException("Shape doesn't fit within the bounds");
        }
        // If the shape is already contained within another NestingShape, an exception is thrown.
        if (shape.parent() != null) {
            throw new IllegalArgumentException("Shape is already part of a NestingShape");
        }
        shape.setParent(this);
        children.add(shape);
    }

    // remove() method attempts to remove a shape from this NestingShape.
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

    // indexOf() method returns the index of the specified shape in the children List.
    public int indexOf(Shape shape) {

        return children.indexOf(shape);
    }

    // contains() method checks whether this NestingShape contains the specified shape.
    public boolean contains(Shape shape) {
        return children.contains(shape);
    }
    // move() method updates the position of this NestingShape and all of its children.
    @Override
    public void move(int width, int height) {
        super.move(width, height);
        for (Shape shape : children) {
            shape.move(this.width(), this.height());
        }
    }
    // paint() method draws this NestingShape and all of its children on the screen.
    @Override
    public void paint(Painter painter) {
        super.paint(painter);
        painter.drawRect(this.x(), this.y(), this.width(), this.height());
        painter.translate(this.x(), this.y());
        for (Shape shape : children) {
            shape.paint(painter);
        }
        // Restores the original coordinate system.
        painter.translate(-this.x(), -this.y());
    }
}
