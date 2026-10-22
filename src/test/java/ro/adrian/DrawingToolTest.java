package ro.adrian;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class DrawingToolTest {

  @ParameterizedTest
  @MethodSource("singleShapes")
  void testCalculateTotalsForOneShape(
      Shape shape, double expectedSurface, double expectedPerimeter) {

    // given
    DrawingTool drawingTool = new DrawingTool();

    // when
    drawingTool.addShape(shape);

    // then
    assertEquals(expectedSurface, drawingTool.calculateTotalSumOfSurfaces(), 0.0001);
    assertEquals(expectedPerimeter, drawingTool.calculateTotalSumOfPerimeters(), 0.0001);
  }

  private static Stream<Arguments> singleShapes() {
    return Stream.of(
        Arguments.of(new Circle(1), Math.PI, 2 * Math.PI),
        Arguments.of(new Square(2), 4.0, 8.0),
        Arguments.of(new Rectangle(2, 3), 6.0, 10.0),
        Arguments.of(new Triangle(3, 4, 5), 6.0, 12.0));
  }

  @Test
  void testCalculateTotalsForTwoDifferentShapes() {
    // given
    DrawingTool drawingTool = new DrawingTool();

    // when
    drawingTool.addShape(new Square(2));
    drawingTool.addShape(new Rectangle(2, 3));

    // then
    assertEquals(10.0, drawingTool.calculateTotalSumOfSurfaces(), 0.0001);
    assertEquals(18.0, drawingTool.calculateTotalSumOfPerimeters(), 0.0001);
  }

  @Test
  void testAddAllFourTypesOfShapes() {
    // given
    DrawingTool drawingTool = new DrawingTool();

    // when
    drawingTool.addShape(new Circle(1));
    drawingTool.addShape(new Square(2));
    drawingTool.addShape(new Rectangle(2, 3));
    drawingTool.addShape(new Triangle(3, 4, 5));

    // then
    assertEquals(16 + Math.PI, drawingTool.calculateTotalSumOfSurfaces(), 0.0001);

    assertEquals(30 + 2 * Math.PI, drawingTool.calculateTotalSumOfPerimeters(), 0.0001);
  }

  @Test
  void testNotAddTheSameShapeTwice() {
    // given
    DrawingTool drawingTool = new DrawingTool();
    drawingTool.addShape(new Circle(2));

    // when
    drawingTool.addShape(new Circle(2));

    // then
    assertEquals(4 * Math.PI, drawingTool.calculateTotalSumOfSurfaces(), 0.0001);
    assertEquals(4 * Math.PI, drawingTool.calculateTotalSumOfPerimeters(), 0.0001);
  }

  @Test
  void testAllowDifferentCircles() {
    // given
    DrawingTool drawingTool = new DrawingTool();

    // when
    drawingTool.addShape(new Circle(1));
    drawingTool.addShape(new Circle(2));

    // then
    assertEquals(5 * Math.PI, drawingTool.calculateTotalSumOfSurfaces(), 0.0001);
    assertEquals(6 * Math.PI, drawingTool.calculateTotalSumOfPerimeters(), 0.0001);
  }

  @ParameterizedTest
  @MethodSource("invalidShapes")
  void testInvalidShapes(
      String shapeType, double a, double b, double c, String expectedErrorMessage) {

    // given + when + then
    assertThatThrownBy(
            () -> {
              switch (shapeType) {
                case "Circle" -> new Circle(a);
                case "Square" -> new Square(a);
                case "Rectangle" -> new Rectangle(a, b);
                case "Triangle" -> new Triangle(a, b, c);
                default -> throw new IllegalArgumentException("Unknown shape type");
              }
            })
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage(expectedErrorMessage);
  }

  private static Stream<Arguments> invalidShapes() {
    return Stream.of(
        Arguments.of("Circle", 0.0, 0.0, 0.0, "Radius must be positive."),
        Arguments.of("Square", -2.0, 0.0, 0.0, "Side must be positive."),
        Arguments.of("Rectangle", 2.0, 0.0, 0.0, "Length and width must be positive."),
        Arguments.of("Triangle", 1.0, 2.0, 10.0, "The sides do not form a valid triangle."));
  }
}
