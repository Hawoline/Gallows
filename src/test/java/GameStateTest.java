import org.hawoline.domain.WordWithMask;
import org.hawoline.domain.Mistakes;
import org.hawoline.domain.GameState;
import org.hawoline.domain.Keyboard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameStateTest {
  private Mistakes mistakes;
  private Keyboard keyboard;
  private WordWithMask wordWithMask;
  private GameState gameState;
  private static final String SOME_FOOD_WORD_FOR_TEST = "potato";

  @BeforeEach
  void setUp() {
    mistakes = new Mistakes();
    keyboard = new Keyboard();
    wordWithMask = new WordWithMask(SOME_FOOD_WORD_FOR_TEST);
    gameState = new GameState(mistakes, keyboard, wordWithMask);
  }

  @Test
  public void testLoseAfterSevenMistakes() {
    /*
    Алгоритм работы игры:
    1. Вводим букву
    2. Проверяем существует буква? + A
    2.1 Существует.
    - Открыть букву в слове
    - Проверить, победил игрок?:
    2.1.1 Если победил, то Закончить игру.
    2.1.2 -> 1.
    2.2 Если не существует, то добавить счетчик ошибок
    - Проверить проиграл ли игрок
    2.2.1 Если проиграл, то конец игры и вывод сообщения, что игрок проиграл
    2.2.2 -> 1.

    Состояние игры содержит:
    1. Введенная буква
    2. Само скрытое слово
    3. Количество ошибок
    4. Игрок победил или нет

    Также результат игры:
    1. Победа
    2. Проигрыш
     */
    assertEquals("......", gameState.getRightLettersInWord().getCurrentWord());
    final char letterF = 'f';
    GameState firstFalseLetterTappedState = gameState.nextState(letterF);
    final char letterB = 'b';
    GameState secondFalseLetterTappedState = firstFalseLetterTappedState.nextState(letterB);
    final char letterC = 'c';
    GameState thirdFalseLetterTappedState = secondFalseLetterTappedState.nextState(letterC);
    final char letterD = 'd';
    GameState fourthFalseLetterTappedState = thirdFalseLetterTappedState.nextState(letterD);
    final char letterE = 'e';
    GameState fifthFalseLetterTappedState = fourthFalseLetterTappedState.nextState(letterE);
    assertEquals("......", fifthFalseLetterTappedState.getRightLettersInWord().getCurrentWord());
    assertEquals(5, fifthFalseLetterTappedState.getLoseCondition().getCountOfMistakes());
    final char letterG = 'g';
    GameState sixthFalseLetterTappedState = fifthFalseLetterTappedState.nextState(letterG);
    final char letterH = 'h';
    GameState gameOverState = sixthFalseLetterTappedState.nextState(letterH);
  }

  @Test
  public void testWinCondition() {
    final char letterP = 'p';
    GameState firstTrueLetterTappedState = gameState.nextState(letterP);
    final char letterO = 'o';
    GameState secondTrueLetterTappedState = firstTrueLetterTappedState.nextState(letterO);
    final char letterT = 't';
    GameState thirdTrueLetterTappedState = secondTrueLetterTappedState.nextState(letterT);
    final char letterA = 'a';
    GameState fourthTrueLetterTappedState = thirdTrueLetterTappedState.nextState(letterA);
    assertEquals(SOME_FOOD_WORD_FOR_TEST, fourthTrueLetterTappedState.getRightLettersInWord().getCurrentWord());
  }

  //TODO test again tapped letter in keyboard;
  @Test
  public void testAgainTappedLetter() {
    final char letterP = 'p';
    GameState firstTrueLetterTappedState = gameState.nextState(letterP);
    GameState firstTrueLetterTappedAgainState = gameState.nextState(letterP);
    assertEquals(0, firstTrueLetterTappedAgainState.getLoseCondition().getCountOfMistakes());
    assertEquals("p.....", firstTrueLetterTappedAgainState.getRightLettersInWord().getCurrentWord());

    final char letterI = 'i';
    GameState firstFalseLetterTappedState = firstTrueLetterTappedAgainState.nextState(letterI);
    GameState firstFalseLetterTappedAgainState = firstFalseLetterTappedState.nextState(letterI);
    assertEquals(1, firstFalseLetterTappedAgainState.getLoseCondition().getCountOfMistakes());
    assertEquals("p.....", firstFalseLetterTappedAgainState.getRightLettersInWord().getCurrentWord());
  }
}
