import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import org.hawoline.domain.Mistakes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MistakesTest {
  private Mistakes mistakes;

  @BeforeEach
  void setUp() {
    mistakes = new Mistakes();
  }

  @Test
  public void testWhenPlayerLoseAfter7Mistakes() {
    Mistakes mistakes = this.mistakes.addMistake('k');
    assertEquals(1, mistakes.getCountOfMistakes());
    Mistakes mistakesWithTwoMistakes = mistakes.addMistake('l');
    assertEquals(2, mistakesWithTwoMistakes.getCountOfMistakes());
    Mistakes
        mistakesWithThreeMistakes = mistakesWithTwoMistakes.addMistake('a');
    assertEquals(3, mistakesWithThreeMistakes.getCountOfMistakes());
    Mistakes mistakesWithFourMistakes = mistakesWithThreeMistakes.addMistake('m');
    assertEquals(4, mistakesWithFourMistakes.getCountOfMistakes());
    Mistakes mistakesWithFiveMistakes = mistakesWithFourMistakes.addMistake('p');
    assertEquals(5, mistakesWithFiveMistakes.getCountOfMistakes());
    Mistakes mistakesWithSixMistakes = mistakesWithFiveMistakes.addMistake('b');
    assertEquals(6, mistakesWithSixMistakes.getCountOfMistakes());
    Mistakes playerLose = mistakesWithSixMistakes.addMistake('c');
    assertEquals(7, playerLose.getCountOfMistakes());
  }


  @Test
  public void testThatMistakesCannotAddSimilarLetters() {
    HashSet<Character> characters = new HashSet<>();
    characters.add('a');
    characters.add('b');
    characters.add('c');
    characters.add('c');
    mistakes = new Mistakes(characters);
    assertEquals(3, mistakes.getCountOfMistakes());
  }
}
