import org.hawoline.domain.WordWithMask;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordWithMaskTest {
  @Test
  public void test() {
    final WordWithMask lowerCaseWord = new WordWithMask("Milk");

    final WordWithMask newLowerCaseWord = lowerCaseWord.performOpenLetter('i');
    assertEquals(".i..", newLowerCaseWord.getCurrentWord());
    assertEquals(".i..", newLowerCaseWord.getCurrentWord());
    final WordWithMask wordMi = newLowerCaseWord.performOpenLetter('M');
    assertEquals("mi..", wordMi.getCurrentWord());
    assertEquals("mi..", newLowerCaseWord.performOpenLetter('m').getCurrentWord());
    assertEquals(".i..", newLowerCaseWord.performOpenLetter('p').getCurrentWord());

    final WordWithMask wordWinning = new WordWithMask("Winning");
    final WordWithMask wordWinningWithOpenedILetter = wordWinning.performOpenLetter('i');
    assertEquals(".i..i..", wordWinningWithOpenedILetter.getCurrentWord());
    final WordWithMask wordWinningWithOpenedIAndNLetter = wordWinningWithOpenedILetter.performOpenLetter('n');
    assertEquals(".innin.", wordWinningWithOpenedIAndNLetter.getCurrentWord());
  }

  @Test
  public void testRussianWord() {
    final WordWithMask wordHello = new WordWithMask("Привет");
    final WordWithMask wordHelloWithPublicP = wordHello.performOpenLetter('П');
    assertEquals("п.....", wordHelloWithPublicP.getCurrentWord());
  }
}
