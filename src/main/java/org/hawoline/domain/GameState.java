package org.hawoline.domain;

public final class GameState {
  private final Mistakes mistakes;
  private final Keyboard keyboard;
  private final RightLettersInWord rightLettersInWord;

  public GameState(Mistakes mistakes, Keyboard keyboard, RightLettersInWord rightLettersInWord) {
    this.mistakes = mistakes;
    this.keyboard = keyboard;
    this.rightLettersInWord = rightLettersInWord;
  }

  public Mistakes getLoseCondition() {
    return mistakes;
  }

  public Keyboard getKeyboard() {
    return keyboard;
  }

  public RightLettersInWord getRightLettersInWord() {
    return rightLettersInWord;
  }

  public GameState nextState(char letter) {
    if (keyboard.isLetterTapped(letter)) {
      return this;
    }
    final Keyboard keyboardWithTappedLetter = keyboard.tapLetter(letter);
    final RightLettersInWord rightLettersInWordAfterTap = rightLettersInWord.performOpenLetter(letter);
    if (rightLettersInWordAfterTap.getCurrentWord().equals(rightLettersInWord.getCurrentWord())) {
      Mistakes addedMistake = mistakes.addMistake(letter);
      return new GameState(addedMistake, keyboardWithTappedLetter, rightLettersInWordAfterTap);
    }

    return new GameState(mistakes, keyboardWithTappedLetter, rightLettersInWordAfterTap);
  }
}
