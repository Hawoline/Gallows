import org.hawoline.domain.RightLettersInWord;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RightLettersInWordTest {
  @Test
  public void test() {
    final RightLettersInWord lowerCaseWord = new RightLettersInWord("Milk");

    final RightLettersInWord newLowerCaseWord = lowerCaseWord.performOpenLetter('i');
    assertEquals(".i..", newLowerCaseWord.getCurrentWord());
    assertEquals(".i..", newLowerCaseWord.getCurrentWord());
    final RightLettersInWord wordMi = newLowerCaseWord.performOpenLetter('M');
    assertEquals("mi..", wordMi.getCurrentWord());
    assertEquals("mi..", newLowerCaseWord.performOpenLetter('m').getCurrentWord());
    assertEquals(".i..", newLowerCaseWord.performOpenLetter('p').getCurrentWord());

    final RightLettersInWord wordWinning = new RightLettersInWord("Winning");
    final RightLettersInWord wordWinningWithOpenedILetter = wordWinning.performOpenLetter('i');
    assertEquals(".i..i..", wordWinningWithOpenedILetter.getCurrentWord());
    final RightLettersInWord wordWinningWithOpenedIAndNLetter = wordWinningWithOpenedILetter.performOpenLetter('n');
    assertEquals(".innin.", wordWinningWithOpenedIAndNLetter.getCurrentWord());
  }

  @Test
  public void testRussianWord() {
    final RightLettersInWord wordHello = new RightLettersInWord("Привет");
    final RightLettersInWord wordHelloWithPublicP = wordHello.performOpenLetter('П');
    assertEquals("п.....", wordHelloWithPublicP.getCurrentWord());
  }
}
