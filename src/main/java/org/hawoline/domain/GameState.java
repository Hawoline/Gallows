package org.hawoline.domain;

import java.util.Scanner;

public final class GameState {
  private final Gallows gallows;
  private final Keyboard keyboard;
  private final ActualWord actualWord;

  public GameState(Gallows gallows, Keyboard keyboard, ActualWord actualWord) {
    this.gallows = gallows;
    this.keyboard = keyboard;
    this.actualWord = actualWord;
  }

  public Gallows getGallows() {
    return gallows;
  }

  public Keyboard getKeyboard() {
    return keyboard;
  }

  public ActualWord getActualWord() {
    return actualWord;
  }

  public void readLetter() {
    Scanner scanner = new Scanner(System.in);
    char letter = scanner.next().charAt(0);
  }
}
