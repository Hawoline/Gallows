package org.hawoline.domain;

import java.util.ArrayList;
import java.util.List;

public final class Keyboard {
  private final String currentAlphabet;

  public Keyboard() {
    this("abcdefghijklmnopqrstuvwxyz");
  }

  private Keyboard(String currentAlphabet) {
    this.currentAlphabet = currentAlphabet;
  }

  public String getCurrentAlphabet() {
    return currentAlphabet;
  }

  public Keyboard tapLetter(char letter) {
    return new Keyboard(currentAlphabet.replace(String.valueOf(letter), ""));
  }

  public boolean isLetterTapped(char letter) {
    return currentAlphabet.contains(String.valueOf(letter));
  }
}
