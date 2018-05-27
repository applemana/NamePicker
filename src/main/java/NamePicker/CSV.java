package NamePicker;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents the reading and parsing of a CSV file.
 *
 * @author Appleman
 */
public class CSV implements ICSV {

  /**
   * Creates a new instance of a CSV given no parameters.
   */
  public CSV() {

  }

  /**
   * Creates a list of people that where read from the CSV.
   * @param fileName The name of the CSV file to be read.
   * @return A list of people read from the CSV.
   */
  public List<IPerson> readCSV(String fileName) {
    List<IPerson> family = new ArrayList<>();
    family = parseFile(fileName, family);
    return family;
  }

  /**
   * Reads and parses the file into individual components.
   * @param fileName The name of the CSV to be parsed.
   * @param family   The list of people that are extracted from the CSV.
   * @return family
   */
  private List<IPerson> parseFile(String fileName, List<IPerson> family) {
    String splitter = ",";
    IPerson person;
    String line;
    String[] wholeString;

    try (BufferedReader nodeFile = new BufferedReader(new FileReader(fileName))) {

      while ((line = nodeFile.readLine()) != null) {
        wholeString = line.split(splitter);
        person = new Person(wholeString[0], wholeString[1]);
        family.add(person);
        }
    } catch (FileNotFoundException fnfe) {
      System.out.println("*** A file was not found : " + fnfe.getMessage());
      fnfe.printStackTrace();
    } catch (IOException e) {
      System.out.println("*** IOException  : " + e.getMessage());
      e.printStackTrace();
    }
    return family;
  }
}
