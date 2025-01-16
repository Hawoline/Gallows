import org.hawoline.domain.RightLettersInWord;
import org.hawoline.domain.LoseCondition;
import org.hawoline.domain.GameState;
import org.hawoline.domain.Keyboard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameStateTest {
  private LoseCondition loseCondition;
  private Keyboard keyboard;
  private RightLettersInWord rightLettersInWord;
  private GameState gameState;
  private static final String SOME_FOOD_WORD_FOR_TEST = "Potato";

  @BeforeEach
  void setUp() {
    loseCondition = new LoseCondition(0);
    keyboard = new Keyboard();
    rightLettersInWord = new RightLettersInWord(SOME_FOOD_WORD_FOR_TEST);
    gameState = new GameState(loseCondition, keyboard, rightLettersInWord);
  }

  @Test
  public void test() {
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

    Также результат игры:
    1. Победа
    2. Проигрыш
     */
    assertEquals("......", gameState.getRightLettersInWord().getCurrentWord());
    //assertEquals(gameState.getLoseCondition(), );
  }
}
