package Models;

import Enums.CharacterType;

public class Character extends Entity {

  private CharacterType type;
  private Transport[] availableTransports;

  public Character(
      Point startingPosition,
      Transport startingTransport,
      CharacterType type,
      Transport[] availableTransports) {
    super(startingPosition, startingTransport);
    this.type = type;
    this.availableTransports = availableTransports;
  }

  public Transport[] getAvailableTransports() {
    return availableTransports;
  }

  public CharacterType getCharacterType() {
    return type;
  }
}
