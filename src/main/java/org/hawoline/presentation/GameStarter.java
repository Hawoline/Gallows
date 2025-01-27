package org.hawoline.presentation;

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
    WordsRepository wordsRepository = new WordsRepository("words.txt");
    List<String> words = wordsRepository.readWords();
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
      System.out.println("------------------------------\n"
          + "Вы хотите начать новую игру или выйти?");
      System.out.println("0 - Начать новую игру.");
      System.out.println("Любая другая клавиша - Выйти.");
      if (!scanner.hasNextInt() || scanner.nextInt() != 0) {
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
            System.out.println("Загаданное слово: " + newGameState.getRightLettersInWord().getRightWord());
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
          scanner.next();
          System.out.println("Вы ввели неверную букву.");
        }
      }
    }
    scanner.close();
  }
}
