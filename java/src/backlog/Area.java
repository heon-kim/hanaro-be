package backlog;

abstract class Shape {
    abstract double calArea();
}

class Circle extends Shape {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double calArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    double width, height;

    Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    double calArea() {
        return width * height;
    }
}

public class Area {
    public static void main(String[] args) {
        Shape[] shapes = { new Circle(5.0), new Rectangle(3, 4), new Circle(1) };

        double totalArea = 0;
        for (Shape shape : shapes) {
            totalArea += shape.calArea();
        }

        System.out.println("면적의 합: " + totalArea);
    }
}