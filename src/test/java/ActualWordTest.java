import org.hawoline.domain.ActualWord;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ActualWordTest {
  @Test
  public void test() {
    final ActualWord lowerCaseWord = new ActualWord("Milk");

    final ActualWord newLowerCaseWord = lowerCaseWord.performOpenLetter('i');
    assertEquals(".i..", newLowerCaseWord.getCurrentWord());
    assertEquals(".i..", newLowerCaseWord.getCurrentWord());
    final ActualWord wordMi = newLowerCaseWord.performOpenLetter('M');
    assertEquals("mi..", wordMi.getCurrentWord());
    assertEquals("mi..", newLowerCaseWord.performOpenLetter('m').getCurrentWord());
    assertEquals(".i..", newLowerCaseWord.performOpenLetter('p').getCurrentWord());

    final ActualWord wordWinning = new ActualWord("Winning");
    final ActualWord wordWinningWithOpenedILetter = wordWinning.performOpenLetter('i');
    assertEquals(".i..i..", wordWinningWithOpenedILetter.getCurrentWord());
    final ActualWord wordWinningWithOpenedIAndNLetter = wordWinningWithOpenedILetter.performOpenLetter('n');
    assertEquals(".innin.", wordWinningWithOpenedIAndNLetter.getCurrentWord());
  }

  @Test
  public void testRussianWord() {
    final ActualWord wordHello = new ActualWord("Привет");
    final ActualWord wordHelloWithPublicP = wordHello.performOpenLetter('П');
    assertEquals("п.....", wordHelloWithPublicP.getCurrentWord());
  }
}
