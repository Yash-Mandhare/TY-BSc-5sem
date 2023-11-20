// Write a program to create an abstract class named Shape that contains two integers and an
// empty method named printArea(). Provide three classes named Rectangle, Triangle and Circle
// such that each one of the classes extends the class Shape. Each one of the classes contain only
// the method printArea() that prints the area of the given shape. (use method overriding).

// Abstract class Shape
abstract class Shape {
    // Two integers common to all shapes
    protected int base;
    protected int height;

    // Constructor
    public Shape(int base, int height) {
        this.base = base;
        this.height = height;
    }

    // Abstract method to be implemented by subclasses
    public abstract void printArea();
}

// Rectangle class extending Shape
class Rectangle extends Shape {
    // Constructor
    public Rectangle(int base, int height) {
        super(base, height);
    }

    // Implementation of printArea for Rectangle
    @Override
    public void printArea() {
        int area = base * height;
        System.out.println("Area of Rectangle: " + area);
    }
}

// Triangle class extending Shape
class Triangle extends Shape {
    // Constructor
    public Triangle(int base, int height) {
        super(base, height);
    }

    // Implementation of printArea for Triangle
    @Override
    public void printArea() {
        double area = 0.5 * base * height;
        System.out.println("Area of Triangle: " + area);
    }
}

// Circle class extending Shape
class Circle extends Shape {
    // Constructor
    public Circle(int radius) {
        super(radius, radius); // Considering radius as both base and height for a circle
    }

    // Implementation of printArea for Circle
    @Override
    public void printArea() {
        double area = Math.PI * base * base;
        System.out.println("Area of Circle: " + area);
    }
}

// Main class to test the shapes
public class ShapeTest {
    public static void main(String[] args) {
        // Creating objects of each shape
        Rectangle rectangle = new Rectangle(5, 10);
        Triangle triangle = new Triangle(6, 8);
        Circle circle = new Circle(4);

        // Printing areas
        rectangle.printArea();
        triangle.printArea();
        circle.printArea();
    }
}
