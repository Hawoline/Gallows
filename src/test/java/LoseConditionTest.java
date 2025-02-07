import org.hawoline.domain.LoseCondition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoseConditionTest {
  private final LoseCondition loseCondition = new LoseCondition(0);
  @BeforeEach
  void setUp() {
  }

  @Test
  public void testWhenPlayerLoseAfter7Mistakes() {
    LoseCondition mistakesWithOneLoseCondition = loseCondition.addMistake();
    assertEquals(1, mistakesWithOneLoseCondition.getCountOfMistakes());
    assertFalse(mistakesWithOneLoseCondition.isPlayerLose());
    LoseCondition mistakesWithTwoLoseCondition = mistakesWithOneLoseCondition.addMistake();
    assertEquals(2, mistakesWithTwoLoseCondition.getCountOfMistakes());
    assertFalse(mistakesWithTwoLoseCondition.isPlayerLose());
    LoseCondition
        mistakesWithThreeLoseCondition = mistakesWithTwoLoseCondition.addMistake();
    assertEquals(3, mistakesWithThreeLoseCondition.getCountOfMistakes());
    assertFalse(mistakesWithThreeLoseCondition.isPlayerLose());
    LoseCondition loseConditionWithFourMistakes = mistakesWithThreeLoseCondition.addMistake();
    assertEquals(4, loseConditionWithFourMistakes.getCountOfMistakes());
    assertFalse(loseConditionWithFourMistakes.isPlayerLose());
    LoseCondition loseConditionWithFiveMistakes = loseConditionWithFourMistakes.addMistake();
    assertEquals(5, loseConditionWithFiveMistakes.getCountOfMistakes());
    assertFalse(loseConditionWithFiveMistakes.isPlayerLose());
    LoseCondition loseConditionWithSixMistakes = loseConditionWithFiveMistakes.addMistake();
    assertEquals(6, loseConditionWithSixMistakes.getCountOfMistakes());
    assertFalse(loseConditionWithSixMistakes.isPlayerLose());
    LoseCondition playerLose = loseConditionWithSixMistakes.addMistake();
    assertEquals(7, playerLose.getCountOfMistakes());
    assertTrue(playerLose.isPlayerLose());
  }
}
