package NamePicker;

/**
 * Represents a situation where the index provided for a given list is out of bounds.
 */
public class UnsupportedOperationException extends RuntimeException {

  public UnsupportedOperationException(String message) {
    super(message);
  }
}
