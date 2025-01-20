package org.hawoline.data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordsRepository {
  private final String filename;

  public WordsRepository(String filename) {
    this.filename = filename;
  }

  public List<String> readWords() {
    List<String> words = new ArrayList<>();
    try {
      File file = new File(filename);
      Scanner myReader = new Scanner(file);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        words.add(data);
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }

    return words;
  }
}
