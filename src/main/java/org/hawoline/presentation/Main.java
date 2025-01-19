package org.hawoline.presentation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import org.hawoline.domain.GameState;
import org.hawoline.domain.Keyboard;
import org.hawoline.domain.LoseCondition;
import org.hawoline.domain.RightLettersInWord;

public class Main {
  private static final int START_NEW_GAME = 0;
  private static final int EXIT_GAME = 1;
  private static List<String> words = new ArrayList<>();

  public static void main(String[] args) {
    words.add("ant");
    words.add("baboon");
    words.add("badger");
    words.add("bat");
    words.add("bear");
    words.add("beaver");
    words.add("camel");
    words.add("cat");
    words.add("clam");
    words.add("cobra");
    words.add("cougar");
    words.add("coyote");
    words.add("crow");
    words.add("deer");
    words.add("dog");
    words.add("donkey");
    words.add("duck");
    words.add("eagle");
    words.add("ferret");
    words.add("fox");
    words.add("frog");
    words.add("goat");
    words.add("goose");
    words.add("hawk");
    words.add("lion");
    words.add("lizard");
    words.add("llama");
    words.add("mole");
    words.add("monkey");
    words.add("moose");
    words.add("mouse");
    words.add("mule");
    words.add("newt");
    words.add("otter");
    words.add("owl");
    words.add("panda");
    words.add("parrot");
    words.add("pigeon");
    words.add("python");
    words.add("rabbit");
    words.add("ram");
    words.add("rat");
    words.add("raven");
    words.add("rhino");
    words.add("salmon");
    words.add("seal");
    words.add("shark");
    words.add("sheep");
    words.add("skunk");
    words.add("sloth");
    words.add("snake");
    words.add("spider");
    words.add("stork");
    words.add("swan");
    words.add("tiger");
    words.add("toad");
    words.add("trout");
    words.add("turkey");
    words.add("turtle");
    words.add("weasel");
    words.add("whale");
    words.add("wolf");
    words.add("wombat");
    words.add("zebra");
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
        if (scanner.hasNext("[a-z]")) {
          char ch = scanner.next().charAt(0);
          GameState newGameState = gameStates.get(statesCount++).tap(ch);
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
          break;
        }
      }
    }
  }

}