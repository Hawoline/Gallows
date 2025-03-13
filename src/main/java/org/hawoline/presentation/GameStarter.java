package org.hawoline.presentation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import org.hawoline.data.WordsRepository;
import org.hawoline.domain.GameState;
import org.hawoline.domain.Keyboard;
import org.hawoline.domain.Mistakes;
import org.hawoline.domain.WordWithMask;

public class GameStarter {
  private final String ONE_OR_MORE_ENGLISH_LETTERS_PATTERN = "[a-z]+";
  private WordsRepository wordsRepository = new WordsRepository("words.txt");
  private List<String> words = wordsRepository.readWords();
  private Scanner scanner = new Scanner(System.in);
  private Mistakes mistakes;
  private Keyboard keyboard;
  private WordWithMask wordWithMask;
  private GameState gameState;
  private GallowsDrawer gallowsDrawer = new GallowsDrawer();
  public void start() {
    System.out.println("Привет! Добро пожаловать в игру «Виселица»! Твоя задача – угадать английское"
        + " слово. У тебя есть всего "+ Mistakes.MAX_MISTAKES_COUNT + " попыток. Готов? Тогда начнем!");
    while(true) {
      mistakes = new Mistakes();
      keyboard = new Keyboard();
      Random random = new Random();
      wordWithMask = new WordWithMask(words.get(random.nextInt(words.size())));
      gameState = new GameState(mistakes, keyboard, wordWithMask);
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
        if (scanner.hasNext(ONE_OR_MORE_ENGLISH_LETTERS_PATTERN)) {
          char ch = scanner.next().charAt(0);
          GameState newGameState = gameStates.get(statesCount++).nextState(ch);
          if (newGameState.getLoseCondition().isPlayerLose()) {
            gameStates.clear();
            drawState(newGameState);
            System.out.println("Вы проиграли");
            System.out.println("Загаданное слово: " + newGameState.getRightLettersInWord().getRightWord());
            break;
          }
          if (newGameState.getRightLettersInWord().rightWordEqualsCurrentWord()) {
            gallowsDrawer.draw(newGameState.getLoseCondition());
            System.out.println("Вы победили!");
            break;
          }
          drawState(newGameState);
          gameStates.add(newGameState);
        } else {
          scanner.next();
          GameState lastGameState = gameStates.get(statesCount);
          drawState(lastGameState);
          System.out.println("Вы ввели неверную букву.");
        }
        System.out.println();
      }
      System.out.println();
    }
    scanner.close();
  }

  private void drawState(GameState gameState) {
    System.out.println("Текущее слово: " + gameState.getRightLettersInWord().getCurrentWord());
    gallowsDrawer.draw(gameState.getLoseCondition());
  }
}
