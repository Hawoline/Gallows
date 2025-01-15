import org.hawoline.domain.ActualWord;
import org.hawoline.domain.Gallows;
import org.hawoline.domain.GameState;
import org.hawoline.domain.Keyboard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameStateTest {
  private Gallows gallows;
  private Keyboard keyboard;
  private ActualWord actualWord;
  private GameState gameState;

  @BeforeEach
  void setUp() {
    gallows = new Gallows(0);
    keyboard = new Keyboard();
    actualWord = new ActualWord("Potato");
    gameState = new GameState(gallows, keyboard, actualWord);
  }

  @Test
  public void test() {
    /*
    Алгоритм работы игры:
    1. Вводим букву
    2. Проверяем существует буква?:
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
  }
}
