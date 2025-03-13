import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.hawoline.domain.Keyboard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class KeyboardTest {
  private final char[] englishAlphabet = new char[26];

  @BeforeEach
  void setUp() {
    for (int i = 0; i < englishAlphabet.length; i++) {
      englishAlphabet[i] = (char) (97 + i);
    }
  }

  @Test
  public void testEnglishAlphabet() {
    char[] expectedAlphabet = new char[] {
        'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
        's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
    };
    for (int i = 0; i < expectedAlphabet.length; i++) {
      assertEquals(expectedAlphabet[i], englishAlphabet[i]);
    }
  }
  @Test
  public void testNewGameKeyboard() {
    final Keyboard keyBoard = new Keyboard();
    final Keyboard keyboardWithTappedLetterA = keyBoard.tapLetter('a');
    final String englishAlphabetWithoutA = new String(englishAlphabet).replace("a", "");
    assertEquals(englishAlphabetWithoutA, keyboardWithTappedLetterA.getCurrentAlphabet());

    Keyboard a = new Keyboard();
    for (int i = 0; i < englishAlphabet.length; i++) {
       a = a.tapLetter((char) (97 + i));
    }
    assertEquals("", a.getCurrentAlphabet());
    a = a.tapLetter('a');
    assertEquals("", a.getCurrentAlphabet());
  }
}
