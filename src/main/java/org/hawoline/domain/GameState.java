package org.hawoline.domain;

import java.util.Scanner;

public final class GameState {
  private final LoseCondition loseCondition;
  private final Keyboard keyboard;
  private final RightLettersInWord rightLettersInWord;

  public GameState(LoseCondition loseCondition, Keyboard keyboard, RightLettersInWord rightLettersInWord) {
    this.loseCondition = loseCondition;
    this.keyboard = keyboard;
    this.rightLettersInWord = rightLettersInWord;
  }

  public LoseCondition getLoseCondition() {
    return loseCondition;
  }

  public Keyboard getKeyboard() {
    return keyboard;
  }

  public RightLettersInWord getRightLettersInWord() {
    return rightLettersInWord;
  }

  public GameState tap(char letter) {
    if (keyboard.isLetterTapped(letter)) {
      return this;
    }
    final Keyboard keyboardWithTappedLetter = keyboard.tapLetter(letter);
    final RightLettersInWord rightLettersInWordAfterTap = rightLettersInWord.performOpenLetter(letter);
    if (rightLettersInWordAfterTap.getCurrentWord().equals(rightLettersInWord.getCurrentWord())) {
      LoseCondition addedMistake = loseCondition.addMistake();
      return new GameState(addedMistake, keyboardWithTappedLetter, rightLettersInWordAfterTap);
    }

    return new GameState(loseCondition, keyboardWithTappedLetter, rightLettersInWordAfterTap);
  }
}
