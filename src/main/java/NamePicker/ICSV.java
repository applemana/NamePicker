package NamePicker;

import java.util.List;

public interface ICSV {

  /**
   * Creates a list of people that where read from the CSV.
   * @param fileName The name of the CSV file to be read.
   * @return A list of people read from the CSV.
   */
  List<IPerson> readCSV(String fileName);
}
