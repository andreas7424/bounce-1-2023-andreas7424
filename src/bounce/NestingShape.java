package bounce;

import java.util.*;

public class NestingShape extends Shape {

    // shapeList is a List that holds all the shapes contained by this NestingShape.
    private List<Shape> shapeList;

    // Constructor initialises the NestingShape with specified position, speed, and size, and initialises the shapeList.
    public NestingShape(int x, int y, int deltaX, int deltaY, int width, int height) {
        super(x, y, deltaX, deltaY, width, height);
        this.shapeList = new ArrayList<>();
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
        shapeList.add(shape);
    }

    // remove() method attempts to remove a shape from this NestingShape.
    public void remove(Shape shape) {
        shape.setParent(null);
        shapeList.remove(shape);
    }

    public Shape shapeAt(int index) {

        return shapeList.get(index);
    }

    public int shapeCount() {

        return shapeList.size();
    }

    // indexOf() method returns the index of the specified shape in the shapeList.
    public int indexOf(Shape shape) {

        return shapeList.indexOf(shape);
    }

    // contains() method checks whether this NestingShape contains the specified shape.
    public boolean contains(Shape shape) {
        return shapeList.contains(shape);
    }
    // Moves this NestingShape and all its children within the specified bounds..
    @Override
    public void move(int width, int height) {
        super.move(width, height);
        for (Shape shape : shapeList) {
            shape.move(this.width(), this.height());
        }
    }
    // Paints this NestingShape and all its children using the provided Painter object.
    @Override
    public void paint(Painter painter) {
        super.paint(painter);
        painter.drawRect(this.x(), this.y(), this.width(), this.height());
        painter.translate(this.x(), this.y());
        for (Shape shape : shapeList) {
            shape.paint(painter);
        }
        // Restores the original coordinate system.
        painter.translate(-this.x(), -this.y());
    }
}
