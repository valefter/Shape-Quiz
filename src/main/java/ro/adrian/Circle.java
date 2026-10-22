package ro.adrian;

import java.util.Objects;

public class Circle implements Shape {

  private double radius;

  public Circle(double radius) {
    if (radius <= 0) {
      throw new IllegalArgumentException("Radius must be positive.");
    }

    this.radius = radius;
  }

  @Override
  public double surface() {
    return Math.PI * radius * radius;
  }

  @Override
  public double perimeter() {
    return 2 * Math.PI * radius;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    Circle circle = (Circle) o;
    return Double.compare(radius, circle.radius) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(radius);
  }
}
