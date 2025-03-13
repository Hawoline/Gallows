package org.hawoline.domain;

public final class GameState {
  private final Mistakes mistakes;
  private final Keyboard keyboard;
  private final WordWithMask wordWithMask;

  public GameState(Mistakes mistakes, Keyboard keyboard, WordWithMask wordWithMask) {
    this.mistakes = mistakes;
    this.keyboard = keyboard;
    this.wordWithMask = wordWithMask;
  }

  public Mistakes getLoseCondition() {
    return mistakes;
  }

  public Keyboard getKeyboard() {
    return keyboard;
  }

  public WordWithMask getRightLettersInWord() {
    return wordWithMask;
  }

  public GameState nextState(char letter) {
    if (keyboard.isLetterTapped(letter)) {
      return this;
    }
    final Keyboard keyboardWithTappedLetter = keyboard.tapLetter(letter);
    final WordWithMask wordWithMaskAfterTap = wordWithMask.performOpenLetter(letter);
    if (letterNotOpened(wordWithMaskAfterTap.getCurrentWord())) {
      return new GameState(mistakes.addMistake(letter), keyboardWithTappedLetter,
          wordWithMaskAfterTap);
    }

    return new GameState(mistakes, keyboardWithTappedLetter, wordWithMaskAfterTap);
  }

  private boolean letterNotOpened(String word) {
    return word.equals(wordWithMask.getCurrentWord());
  }
}
