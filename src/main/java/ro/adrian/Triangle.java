package ro.adrian;

import java.util.Objects;

public class Triangle implements Shape {

  private double sideA;
  private double sideB;
  private double sideC;

  public Triangle(double sideA, double sideB, double sideC) {
    if (sideA + sideB <= sideC || sideA + sideC <= sideB || sideB + sideC <= sideA) {
      throw new IllegalArgumentException("The sides do not form a valid triangle.");
    }

    this.sideA = sideA;
    this.sideB = sideB;
    this.sideC = sideC;
  }

  @Override
  public double surface() {
    double semiPerimeter = (sideA + sideB + sideC) / 2;
    return Math.sqrt(
        semiPerimeter
            * (semiPerimeter - sideA)
            * (semiPerimeter - sideB)
            * (semiPerimeter - sideC));
  }

  @Override
  public double perimeter() {
    return sideA + sideB + sideC;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    Triangle triangle = (Triangle) o;
    return Double.compare(sideA, triangle.sideA) == 0
        && Double.compare(sideB, triangle.sideB) == 0
        && Double.compare(sideC, triangle.sideC) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(sideA, sideB, sideC);
  }
}
