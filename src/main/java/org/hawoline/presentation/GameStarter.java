package org.hawoline.presentation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import org.hawoline.data.WordsRepository;
import org.hawoline.domain.GameState;
import org.hawoline.domain.Keyboard;
import org.hawoline.domain.LoseCondition;
import org.hawoline.domain.RightLettersInWord;

public class GameStarter {
  public void start() {
    WordsRepository repository = new WordsRepository("words.txt");
    List<String> words = repository.readWords();
    Scanner scanner = new Scanner(System.in);
    LoseCondition loseCondition;
    Keyboard keyboard;
    RightLettersInWord rightLettersInWord;
    GameState gameState;

    while(true) {
      loseCondition = new LoseCondition(0);
      keyboard = new Keyboard();
      Random random = new Random();
      rightLettersInWord = new RightLettersInWord(words.get(random.nextInt(words.size())));
      gameState = new GameState(loseCondition, keyboard, rightLettersInWord);
      List<GameState> gameStates = new ArrayList<>();
      gameStates.add(gameState);
      System.out.println("Вы хотите начать новую игру или выйти?");
      System.out.println("0 - Начать новую игру.");
      System.out.println("Любая другая клавиша - Выйти.");
      if (!scanner.hasNextInt() || scanner.nextInt() != 0) {
        System.out.println("Вы хотите начать новую игру или выйти?");
        System.out.println("0 - Начать новую игру.");
        System.out.println("Любая другая клавиша - Выйти.");
        break;
      }
      int statesCount = 0;
      while (true) {
        System.out.println("Введите букву для отгадки:");
        final String oneOrMoreEnglishLettersPattern = "[a-z]+";
        if (scanner.hasNext(oneOrMoreEnglishLettersPattern)) {
          char ch = scanner.next().charAt(0);
          GameState newGameState = gameStates.get(statesCount++).nextState(ch);
          if (newGameState.getLoseCondition().isPlayerLose()) {
            System.out.println("Вы проиграли");
            break;
          }
          if (newGameState.getRightLettersInWord().rightWordEqualsCurrentWord()) {
            System.out.println("Вы победили");
            break;
          }
          System.out.println("Текущее слово: " + newGameState.getRightLettersInWord().getCurrentWord());
          System.out.println("Количество ошибок: " + newGameState.getLoseCondition().getCountOfMistakes());
          gameStates.add(newGameState);
        } else {
          System.out.println("Вы ввели неверную букву.");
        }
      }
    }
  }
}
