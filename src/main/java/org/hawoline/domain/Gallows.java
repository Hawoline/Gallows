package org.hawoline.domain;

public final class Gallows {
  private final int countOfMistakes;

  public Gallows(int countOfMistakes) {
    this.countOfMistakes = countOfMistakes;
  }

  public int getCountOfMistakes() {
    return countOfMistakes;
  }

  public Gallows addMistake() {
    if (countOfMistakes < 0) {
      throw new IllegalStateException("Min count of mistakes = 0");
    }
    final int count = countOfMistakes + 1;
    return new Gallows(count);
  }
}
