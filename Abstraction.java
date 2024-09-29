// Abstract class
abstract class Shape {
    // Abstract method for calculating area
    abstract double area();

    // Abstract method for calculating perimeter
    abstract double perimeter();
}

// Concrete class for Rectangle
class Rectangle extends Shape {
    double length, width;

    // Constructor
    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    // Overriding the area method
    @Override
    double area() {
        return length * width;
    }

    // Overriding the perimeter method
    @Override
    double perimeter() {
        return 2 * (length + width);
    }
}

// Main class
public class Abstraction {
    public static void main(String[] args) {
        // Creating objects of Circle and Rectangle       // Circle with radius 5
        Shape rectangle = new Rectangle(4.0, 6.0);  // Rectangle with length 4 and width 6

        System.out.println("Rectangle Area: " + rectangle.area());           // Output: Rectangle Area: 24.0
        System.out.println("Rectangle Perimeter: " + rectangle.perimeter()); // Output: Rectangle Perimeter: 20.0
    }
}
