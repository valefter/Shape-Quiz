package ro.adrian;

import java.util.Objects;

public class Square implements Shape {

  private double side;

  public Square(double side) {
    if (side <= 0) {
      throw new IllegalArgumentException("Side must be positive.");
    }

    this.side = side;
  }

  @Override
  public double surface() {
    return side * side;
  }

  @Override
  public double perimeter() {
    return 4 * side;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    Square square = (Square) o;
    return Double.compare(side, square.side) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(side);
  }
}
