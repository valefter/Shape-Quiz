package ro.adrian;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {

  @ParameterizedTest
  @MethodSource("rectangles")
  void testCalculateSurfaceAndPerimeterForRectangle(
      double length, double width, double expectedSurface, double expectedPerimeter) {

    // given
    Rectangle rectangle = new Rectangle(length, width);

    // when
    double surface = rectangle.surface();
    double perimeter = rectangle.perimeter();

    // then
    assertEquals(expectedSurface, surface, 0.0001);
    assertEquals(expectedPerimeter, perimeter, 0.0001);
  }

  private static Stream<Arguments> rectangles() {
    return Stream.of(
        Arguments.of(2.0, 3.0, 6.0, 10.0),
        Arguments.of(4.0, 5.0, 20.0, 18.0),
        Arguments.of(1.0, 7.0, 7.0, 16.0));
  }
}
