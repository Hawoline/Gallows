package org.hawoline.presentation;

import org.hawoline.domain.Mistakes;

public class GallowsDrawer {

  private static final int ROW_COUNT_IN_STATE = 5;
  private String[] initialState = {
      "|---",
      "|",
      "|",
      "|",
      "|"
  };
  private String[] stateWith1Mistakes = {
      "|---",
      "|  |",
      "|",
      "|",
      "|"
  };
  private String[] stateWith2Mistakes = {
      "|---",
      "|  |",
      "|  o",
      "|",
      "|"
  };
  private String[] stateWith3Mistakes = {
      "|---",
      "|  |",
      "|  o",
      "| /",
      "|\n"
  };
  private String[] stateWith4Mistakes = {
      "|---",
      "|  |",
      "|  o",
      "| /|",
      "|"
  };
  private String[] stateWith5Mistakes = {
      "|---",
      "|  |",
      "|  o",
      "| /|\\",
      "|"
  };
  private String[] stateWith6Mistakes = {
      "|---",
      "|  |",
      "|  o",
      "| /|\\",
      "| /"
  };
  private String[] stateWith7Mistakes = {
      "|---",
      "|  |",
      "|  o",
      "| /|\\",
      "| / \\"
  };
  private String[][] states = {
      initialState, stateWith1Mistakes, stateWith2Mistakes, stateWith3Mistakes, stateWith4Mistakes,
      stateWith5Mistakes, stateWith6Mistakes, stateWith7Mistakes
  };

  public void draw(Mistakes mistakes) {
    System.out.println("Ошибок " + mistakes.getCountOfMistakes() + ":" + mistakes.getMistakes());
    String[] picture = states[mistakes.getCountOfMistakes()];
    for (int rowInOneState = 0; rowInOneState < 5; rowInOneState++) {
      System.out.println(picture[rowInOneState]);
    }
  }
}
