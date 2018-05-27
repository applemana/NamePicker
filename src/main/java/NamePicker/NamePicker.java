package NamePicker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * This program will read names and emails from a file, randomly assign each person a partner, and
 * will send the individual an email with the partners name.
 *
 * @author Appleman
 */
public class NamePicker {
  private static final String FILE_NAME = "Contact Info.csv";

  /**
   * Creates a new instance of a NamePicker given no parameters.
   */
  public NamePicker() {
  }

  /**
   * The main method of the Name Picker program.
   * @param args Command line arguments.
   */
  public static void main(String[] args) {
    IEmail email = new Email();
    ICSV csv = new CSV();

    List<IPerson> family = csv.readCSV(FILE_NAME);
    Map<IPerson, IPerson> giversAndReceivers = assignPartners(family);

    for (Map.Entry<IPerson, IPerson> partners : giversAndReceivers.entrySet()) {
      email.sendEmail(partners.getKey(), partners.getValue());
    }
  }

  /**
   * Assigns a partner to each person in the provided list. A partner cannot be partners with
   * themselves.
   * @param family The list people to be paired up.
   * @return A map containing each person and their partner.
   */
  private static Map<IPerson, IPerson> assignPartners(List<IPerson> family) {
    Map<IPerson, IPerson> picks = new HashMap<>();
    List<IPerson> copy = new ArrayList<IPerson>(family);
    try {
      for (IPerson person : family) {
        IPerson receiver = assignGiftReceiver(copy, person);
        picks.put(person, receiver);
      }
    } catch (UnsupportedOperationException uoe) {
      assignPartners(family);
    }

    return picks;
  }

  /**
   * Assignes a partner to the given person.
   * @param copy    A copy of the original list of people.
   * @param person  The person that will be assigned a partner.
   * @return A Person that will be partnered up with person.
   * @throws UnsupportedOperationException when copy gets to a size of 1 and that Person == person.
   */
  private static IPerson assignGiftReceiver(List<IPerson> copy, IPerson person) {
    Random random = new Random();
    int rand = random.nextInt(copy.size());
    IPerson receiver = copy.get(rand);

    if (!receiver.getName().equals(person.getName())) {
        copy.remove(rand);
        return receiver;
    } else if (copy.size() == 1) {
        throw new UnsupportedOperationException("Person and Receiver will continue to be the same.");
    } else {
        return assignGiftReceiver(copy, person);
    }
  }
}
