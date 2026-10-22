package ro.adrian;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

  @ParameterizedTest
  @MethodSource("triangles")
  void testCalculateSurfaceAndPerimeterForTriangle(
      double sideA, double sideB, double sideC, double expectedSurface, double expectedPerimeter) {

    // given
    Triangle triangle = new Triangle(sideA, sideB, sideC);

    // when
    double surface = triangle.surface();
    double perimeter = triangle.perimeter();

    // then
    assertEquals(expectedSurface, surface, 0.0001);
    assertEquals(expectedPerimeter, perimeter, 0.0001);
  }

  private static Stream<Arguments> triangles() {
    return Stream.of(
        Arguments.of(3.0, 4.0, 5.0, 6.0, 12.0),
        Arguments.of(5.0, 5.0, 6.0, 12.0, 16.0),
        Arguments.of(6.0, 8.0, 10.0, 24.0, 24.0));
  }
}
