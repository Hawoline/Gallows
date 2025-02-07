package org.hawoline.domain;

public final class Keyboard {
  private final String currentAlphabet;

  public Keyboard() {
    this("abcdefghijklmnopqrstuvwxyz");
  }

  public Keyboard(String currentAlphabet) {
    this.currentAlphabet = currentAlphabet;
  }

  public String getCurrentAlphabet() {
    return currentAlphabet;
  }

  public Keyboard tapLetter(char letter) {
    return new Keyboard(currentAlphabet.replace(String.valueOf(letter), ""));
  }

  public boolean isLetterTapped(char letter) {
    return !currentAlphabet.contains(String.valueOf(letter));
  }
}
