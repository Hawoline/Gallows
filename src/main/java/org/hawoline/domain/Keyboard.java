package org.hawoline.domain;

public final class Keyboard {
  private final String currentAlphabet;
  private final String sourceAlphabet;

  public Keyboard() {
    this("abcdefghijklmnopqrstuvwxyz", "abcdefghijklmnopqrstuvwxyz");
  }

  public Keyboard(String currentAlphabet, String sourceAlphabet) {
    this.currentAlphabet = currentAlphabet;
    this.sourceAlphabet = sourceAlphabet;
  }

  public String getCurrentAlphabet() {
    return currentAlphabet;
  }

  public Keyboard tapLetter(char letter) {
    return new Keyboard(currentAlphabet.replace(String.valueOf(letter), ""), sourceAlphabet);
  }

  public boolean isLetterTapped(char letter) {
    if (!sourceAlphabet.contains(String.valueOf(letter))) {
      throw new IllegalArgumentException("You put illegal character for game");
    }
    return !currentAlphabet.contains(String.valueOf(letter));
  }
}
