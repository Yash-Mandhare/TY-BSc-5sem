// Write a program to calculate perimeter and area of rectangle.
// (hint : area = length * breadth , perimeter=2*(length+breadth))

import java.util.Scanner;

public class RectanglePerimeterAreaCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the length of the rectangle: ");
        double length = input.nextDouble();

        System.out.print("Enter the breadth of the rectangle: ");
        double breadth = input.nextDouble();

        // Calculate area and perimeter
        double area = length * breadth;
        double perimeter = 2 * (length + breadth);

        System.out.println("Area of the rectangle: " + area);
        System.out.println("Perimeter of the rectangle: " + perimeter);

        input.close();
    }
}
