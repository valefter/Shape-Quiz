package ro.adrian;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SquareTest {

  @ParameterizedTest
  @MethodSource("squares")
  void testCalculateSurfaceAndPerimeterForSquare(
      double side, double expectedSurface, double expectedPerimeter) {

    // given
    Square square = new Square(side);

    // when
    double surface = square.surface();
    double perimeter = square.perimeter();

    // then
    assertEquals(expectedSurface, surface, 0.0001);
    assertEquals(expectedPerimeter, perimeter, 0.0001);
  }

  private static Stream<Arguments> squares() {
    return Stream.of(
        Arguments.of(1.0, 1.0, 4.0), Arguments.of(2.0, 4.0, 8.0), Arguments.of(3.0, 9.0, 12.0));
  }
}
