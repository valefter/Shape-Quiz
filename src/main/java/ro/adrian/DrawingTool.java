package ro.adrian;

import java.util.ArrayList;
import java.util.List;

public class DrawingTool {

  private final List<Shape> shapes = new ArrayList<>();

  public void addShape(Shape shape) {
    if (shape == null) {
      throw new IllegalArgumentException("Shape cannot be null.");
    }

    if (shapes.contains(shape)) {
      System.out.println("This shape already exists!");
      return;
    }

    shapes.add(shape);
  }

  public double calculateTotalSumOfPerimeters() {
    double sum = 0;

    for (Shape shape : shapes) {
      sum += shape.perimeter();
    }

    return sum;
  }

  public double calculateTotalSumOfSurfaces() {
    double sum = 0;

    for (Shape shape : shapes) {
      sum += shape.surface();
    }

    return sum;
  }
}
