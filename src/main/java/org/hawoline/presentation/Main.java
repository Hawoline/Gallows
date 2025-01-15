package org.hawoline.presentation;

import java.util.Scanner;

public class Main {
  private static final int START_NEW_GAME = 0;
  private static final int EXIT_GAME = 1;
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    while(!scanner.hasNextInt()) {
      System.out.println("Вы хотите начать новую игру или выйти?");
      System.out.println("0 - Начать новую игру.");
      System.out.println("1 - Выйти.");
    }
    int answer = scanner.nextInt();
    while (answer > 1 || answer < 0) {
      System.out.println("Вы хотите начать новую игру или выйти?");
      System.out.println("0 - Начать новую игру.");
      System.out.println("1 - Выйти.");
      if (!scanner.hasNextInt()) {
        System.out.println("Вы хотите начать новую игру или выйти?");
        System.out.println("0 - Начать новую игру.");
        System.out.println("1 - Выйти.");
      }
    }
  }
}