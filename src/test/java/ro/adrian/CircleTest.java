package ro.adrian;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CircleTest {

  @ParameterizedTest
  @MethodSource("circles")
  void testCalculateSurfaceAndPerimeterForCircle(
      double radius, double expectedSurface, double expectedPerimeter) {

    // given
    Circle circle = new Circle(radius);

    // when
    double surface = circle.surface();
    double perimeter = circle.perimeter();

    // then
    assertEquals(expectedSurface, surface, 0.0001);
    assertEquals(expectedPerimeter, perimeter, 0.0001);
  }

  private static Stream<Arguments> circles() {
    return Stream.of(
        Arguments.of(1.0, Math.PI, 2 * Math.PI),
        Arguments.of(2.0, 4 * Math.PI, 4 * Math.PI),
        Arguments.of(3.0, 9 * Math.PI, 6 * Math.PI));
  }
}
