package org.hawoline.domain;

public final class ActualWord {
  private final String rightWord;
  private final String currentWord;

  public ActualWord(final String rightWord) {
    this(rightWord, rightWord.replaceAll("\\D", "."));
  }
  private ActualWord(final String rightWord, final String currentWord) {
    this.rightWord = rightWord.toLowerCase();
    this.currentWord = currentWord;
  }

  public String getCurrentWord() {
    return currentWord;
  }

  public ActualWord performOpenLetter(final char letter) {
    if (!letterExistsInRightWord(letter) || isWin() || letterExistsInCurrentWord(letter)) {
      return this;
    }
    return wordWithOpenedLetter(letter);
  }

  private ActualWord wordWithOpenedLetter(char letter) {
    final char[] rightWordChars = rightWord.toCharArray();
    final char[] currentWordLetters = currentWord.toCharArray();
    final char lowerCaseLetter = Character.toLowerCase(letter);
    for (int i = 0; i < rightWordChars.length; i++) {
      if (rightWordChars[i] == lowerCaseLetter) {
        currentWordLetters[i] = lowerCaseLetter;
      }
    }

    final String result = new String(currentWordLetters);
    return new ActualWord(rightWord, result);
  }

  private boolean letterExistsInRightWord(final char letter) {
    char lowerCaseLetter = Character.toLowerCase(letter);
    int lastIndexOfLetter = rightWord.lastIndexOf(lowerCaseLetter);
    return lastIndexOfLetter != -1;
  }

  private boolean letterExistsInCurrentWord(char letter) {
    char lowerCaseLetter = Character.toLowerCase(letter);
    int lastIndexOfLetter = currentWord.lastIndexOf(lowerCaseLetter);
    return lastIndexOfLetter != -1;
  }

  private boolean isWin() {
    return rightWord.equals(currentWord);
  }

  public boolean rightWordEqualsCurrentWord() {
    return rightWord.equals(currentWord);
  }
}
