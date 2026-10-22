package ro.adrian;

import java.util.Objects;

public class Rectangle implements Shape {

  private double length;
  private double width;

  public Rectangle(double length, double width) {
    if (length <= 0 || width <= 0) {
      throw new IllegalArgumentException("Length and width must be positive.");
    }

    this.length = length;
    this.width = width;
  }

  @Override
  public double surface() {
    return length * width;
  }

  @Override
  public double perimeter() {
    return 2 * (length + width);
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    Rectangle rectangle = (Rectangle) o;
    return Double.compare(length, rectangle.length) == 0
        && Double.compare(width, rectangle.width) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(length, width);
  }
}
