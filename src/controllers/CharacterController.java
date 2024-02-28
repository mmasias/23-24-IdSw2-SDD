package Controllers;

import Models.Character;
import Models.Transport;

public class CharacterController {

  private Character character;

  public CharacterController(Character character) {
    this.character = character;
  }

  public void updateTransportInUse(Transport newTransport) {
    for (Transport transport : this.character.getAvailableTransports()) {
      if (transport.getType() == newTransport.getType()) {
        this.character.setTransportInUse(newTransport);
      }
    }
  }

  public void moveCharacter(int x, int y) {
    this.character.setPosition(x, y);
  }
}