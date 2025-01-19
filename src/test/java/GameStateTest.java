import org.hawoline.domain.RightLettersInWord;
import org.hawoline.domain.LoseCondition;
import org.hawoline.domain.GameState;
import org.hawoline.domain.Keyboard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameStateTest {
  private LoseCondition loseCondition;
  private Keyboard keyboard;
  private RightLettersInWord rightLettersInWord;
  private GameState gameState;
  private static final String SOME_FOOD_WORD_FOR_TEST = "potato";

  @BeforeEach
  void setUp() {
    loseCondition = new LoseCondition(0);
    keyboard = new Keyboard();
    rightLettersInWord = new RightLettersInWord(SOME_FOOD_WORD_FOR_TEST);
    gameState = new GameState(loseCondition, keyboard, rightLettersInWord);
  }

  @Test
  public void testLoseCondition() {
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
    assertFalse(gameState.getLoseCondition().isPlayerLose());
    final char letterF = 'f';
    GameState firstFalseLetterTappedState = gameState.tap(letterF);
    assertFalse(firstFalseLetterTappedState.getLoseCondition().isPlayerLose());
    final char letterB = 'b';
    GameState secondFalseLetterTappedState = firstFalseLetterTappedState.tap(letterB);
    assertFalse(secondFalseLetterTappedState.getLoseCondition().isPlayerLose());
    final char letterC = 'c';
    GameState thirdFalseLetterTappedState = secondFalseLetterTappedState.tap(letterC);
    assertFalse(thirdFalseLetterTappedState.getLoseCondition().isPlayerLose());
    final char letterD = 'd';
    GameState fourthFalseLetterTappedState = thirdFalseLetterTappedState.tap(letterD);
    assertFalse(fourthFalseLetterTappedState.getLoseCondition().isPlayerLose());
    final char letterE = 'e';
    GameState fifthFalseLetterTappedState = fourthFalseLetterTappedState.tap(letterE);
    assertEquals("......", fifthFalseLetterTappedState.getRightLettersInWord().getCurrentWord());
    assertEquals(5, fifthFalseLetterTappedState.getLoseCondition().getCountOfMistakes());
    assertTrue(fifthFalseLetterTappedState.getLoseCondition().isPlayerLose());
  }

  @Test
  public void testWinCondition() {
    final char letterP = 'p';
    GameState firstTrueLetterTappedState = gameState.tap(letterP);
    assertFalse(firstTrueLetterTappedState.getLoseCondition().isPlayerLose());
    final char letterO = 'o';
    GameState secondTrueLetterTappedState = firstTrueLetterTappedState.tap(letterO);
    assertFalse(secondTrueLetterTappedState.getLoseCondition().isPlayerLose());
    final char letterT = 't';
    GameState thirdTrueLetterTappedState = secondTrueLetterTappedState.tap(letterT);
    assertFalse(thirdTrueLetterTappedState.getLoseCondition().isPlayerLose());
    final char letterA = 'a';
    GameState fourthTrueLetterTappedState = thirdTrueLetterTappedState.tap(letterA);
    assertFalse(fourthTrueLetterTappedState.getLoseCondition().isPlayerLose());
    assertEquals(SOME_FOOD_WORD_FOR_TEST, fourthTrueLetterTappedState.getRightLettersInWord().getCurrentWord());
  }

  //TODO test again tapped letter in keyboard;
  @Test
  public void testAgainTappedLetter() {
    final char letterP = 'p';
    GameState firstTrueLetterTappedState = gameState.tap(letterP);
    assertFalse(firstTrueLetterTappedState.getLoseCondition().isPlayerLose());
    GameState firstTrueLetterTappedAgainState = gameState.tap(letterP);
    assertFalse(firstTrueLetterTappedAgainState.getLoseCondition().isPlayerLose());
    assertEquals(0, firstTrueLetterTappedAgainState.getLoseCondition().getCountOfMistakes());
    assertEquals("p.....", firstTrueLetterTappedAgainState.getRightLettersInWord().getCurrentWord());

    final char letterI = 'i';
    GameState firstFalseLetterTappedState = firstTrueLetterTappedAgainState.tap(letterI);
    GameState firstFalseLetterTappedAgainState = firstFalseLetterTappedState.tap(letterI);
    assertFalse(firstFalseLetterTappedAgainState.getLoseCondition().isPlayerLose());
    assertEquals(1, firstFalseLetterTappedAgainState.getLoseCondition().getCountOfMistakes());
    assertEquals("p.....", firstFalseLetterTappedAgainState.getRightLettersInWord().getCurrentWord());
  }
}
