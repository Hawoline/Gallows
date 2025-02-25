package org.hawoline.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class Mistakes {
  public static final int MAX_MISTAKES_COUNT = 7;
  private final Set<Character> mistakes;

  public Mistakes() {
    this(new HashSet<>());
  }
  public Mistakes(Set<Character> mistakes) {
    this.mistakes = new HashSet<>(mistakes);
  }


  public int getCountOfMistakes() {
    return mistakes.size();
  }

  public Set<Character> getMistakes() {
    return mistakes;
  }

  public Mistakes addMistake(char mistake) {
    if (getCountOfMistakes() > MAX_MISTAKES_COUNT - 1) {
      return this;
    }
    mistakes.add(mistake);
    return new Mistakes(mistakes);
  }

  public boolean isPlayerLose() {
    return getCountOfMistakes() >= MAX_MISTAKES_COUNT;
  }
}
