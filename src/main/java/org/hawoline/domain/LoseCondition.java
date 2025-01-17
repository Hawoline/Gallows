package org.hawoline.domain;

public final class LoseCondition {
  private final int countOfMistakes;
  private final boolean playerLose;
  private static final int MAX_MISTAKES_COUNT = 5;

  public LoseCondition(int countOfMistakes) {
    this(countOfMistakes, false);
  }
  private LoseCondition(int countOfMistakes, boolean playerLose) {
    this.countOfMistakes = countOfMistakes;
    this.playerLose = playerLose;
  }

  public int getCountOfMistakes() {
    return countOfMistakes;
  }

  public boolean isPlayerLose() {
    return playerLose;
  }

  public LoseCondition addMistake() {
    if (playerLose) {
      return this;
    }
    if (countOfMistakes < 0) {
      return new LoseCondition(0);
    }
    final int count = countOfMistakes + 1;
    if (count > MAX_MISTAKES_COUNT - 1) {
      return new LoseCondition(MAX_MISTAKES_COUNT, true);
    }
    return new LoseCondition(count);
  }
}
