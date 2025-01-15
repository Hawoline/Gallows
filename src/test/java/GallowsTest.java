import org.hawoline.domain.Gallows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GallowsTest {
  private final Gallows gallows = new Gallows(0);
  @BeforeEach
  void setUp() {
  }

  @Test
  public void test() {
    Gallows gallowsWithOneMistakes = gallows.addMistake();
    assertEquals(1, gallowsWithOneMistakes.getCountOfMistakes());
    Gallows gallowsWithTwoMistakes = gallowsWithOneMistakes.addMistake();
    assertEquals(2, gallowsWithTwoMistakes.getCountOfMistakes());
    Gallows gallowsWithThreeMistakes = gallowsWithTwoMistakes.addMistake();
    assertEquals(3, gallowsWithThreeMistakes.getCountOfMistakes());
    Gallows gallowsWithFourMistakes = gallowsWithThreeMistakes.addMistake();
    assertEquals(4, gallowsWithFourMistakes.getCountOfMistakes());
    Gallows gallowsWithFiveMistakes = gallowsWithFourMistakes.addMistake();
    assertEquals(5, gallowsWithFiveMistakes.getCountOfMistakes());
  }
}
