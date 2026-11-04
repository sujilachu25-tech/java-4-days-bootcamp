abstract class Shape {
    abstract double calculateArea();
}

class Circle extends Shape {
    double radius = 5;

    double calculateArea() {
        return 3.14 * radius * radius;
    }
}

class Rectangle extends Shape {
    double length = 10;
    double width = 5;

    double calculateArea() {
        return length * width;
    }
}

class Triangle extends Shape {
    double base = 8;
    double height = 4;

    double calculateArea() {
        return 0.5 * base * height;
    }
}

public class Main {
    public static void main(String[] args) {

        Shape s;

        s = new Circle();
        System.out.println("Area of Circle: " + s.calculateArea());

        s = new Rectangle();
        System.out.println("Area of Rectangle: " + s.calculateArea());

        s = new Triangle();
        System.out.println("Area of Triangle: " + s.calculateArea());
    }
}
