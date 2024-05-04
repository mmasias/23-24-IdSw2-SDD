package Controllers;

import Enums.CharacterType;
import Enums.TileTypes;
import Enums.TransportTypes;
import Models.Character;
import Models.Entity;
import Models.Map;
import Models.Point;
import Models.Tile;
import Models.Transport;
import Models.World;
import Views.WorldView;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
// (Jorge)
// TODO: #30 Refactor the initialization methods to reduce coupling between the map data reading and the World model.
// TODO: #31 Implement error handling strategies for better resilience, such as retries for file reading or fallbacks for missing data.
public class WorldController {

  private World world;
  private WorldView worldView;

  public WorldController(World world, WorldView worldView) {
    this.world = world;
    this.worldView = worldView;
  }

  public void initializeGame() {
    System.out.println("Initializing game...");
    initializeWorldMap();
    initializeWorldEntities();
    System.out.println("Initialization complete, displaying world.");
    worldView.displayWorld(world);
  }

  public void runGameCycle() {
    Scanner scanner = new Scanner(System.in);
    try {
      while (true) {
        System.out.println("Cycle begins.");
        moveCharacters(scanner);
        world.simulateCycle();
        worldView.displayWorld(world);
        System.out.println("Cycle ends. Press Enter to continue...");
        scanner.nextLine();
      }
    } finally {
      scanner.close();
    }
  }

  private void initializeWorldMap() {
    String path = "src/Data/Map.csv";
    System.out.println("Reading map data from: " + path);
    try {
      List<String[]> mapData = readFileContent(path);
      if (mapData.isEmpty()) {
        System.out.println(
          "Map data is empty or file is incorrectly formatted."
        );
        return;
      }
      populateMap(mapData, world.getMap());
      System.out.println("Map populated successfully.");
    } catch (IOException e) {
      System.out.println("Error reading map file: " + e.getMessage());
    } catch (IllegalArgumentException e) {
      System.out.println("Error in map data: " + e.getMessage());
    }
  }

  private void initializeWorldEntities() {
    System.out.println("Initializing world entities...");
    int npcAmount = 3;
    createPlayer();

    for (int i = 0; i < npcAmount; i++) {
      createNPC();
    }
    System.out.println("World entities initialized.");
  }

  private void createPlayer() {
    Transport[] playerTransports = new Transport[TransportTypes.values()
      .length];
    for (int i = 0; i < TransportTypes.values().length; i++) {
      playerTransports[i] = new Transport(TransportTypes.values()[i]);
    }
    createCharacter(playerTransports, CharacterType.Playable);
  }

  private void createNPC() {
    List<TransportTypes> randomTypes = new ArrayList<>(
      Arrays.asList(TransportTypes.values())
    );
    Collections.shuffle(randomTypes);
    Transport[] npcTransports = new Transport[2];
    for (int i = 0; i < npcTransports.length; i++) {
      npcTransports[i] = new Transport(randomTypes.get(i));
    }
    createCharacter(npcTransports, CharacterType.NonPlayable);
  }

  private void createCharacter(Transport[] transports, CharacterType type) {
    System.out.println("Creating a character of type: " + type);
    for (Transport transport : transports) {
      for (TileTypes tileType : transport
        .getType()
        .getTilesItCanMoveThrough()) {
        Point position = world.getMap().getRandomTilePositionOfType(tileType);
        if (position != null) {
          Character character = new Character(
            position,
            transport,
            type,
            transports
          );
          world.addEntity(character);
          System.out.println(
            "Character successfully created at (" +
            position.getX() +
            ", " +
            position.getY() +
            ")"
          );
          return;
        }
      }
    }
  }

  private List<String[]> readFileContent(String filePath) throws IOException {
    List<String[]> listTiles = new ArrayList<>();
    String correctedPath = filePath.replace("/", File.separator);
    File file = new File(correctedPath);

    if (!file.exists()) {
      throw new IOException("File does not exist: " + correctedPath);
    }

    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = br.readLine()) != null) {
        String[] tokens = line.split(",");
        listTiles.add(tokens);
      }
    }
    return listTiles;
  }

  private void populateMap(List<String[]> mapData, Map worldMap) {
    System.out.println("Populating map...");
    for (int i = 0; i < mapData.size(); i++) {
      for (int j = 0; j < mapData.get(i).length; j++) {
        String tileNumberStr = mapData.get(i)[j];
        Tile tile = createTileByNumber(tileNumberStr);
        if (tile == null) {
          System.out.println(
            "Invalid or unrecognized tile number at position (" +
            i +
            ", " +
            j +
            "): '" +
            tileNumberStr +
            "'"
          );
          continue;
        }
        worldMap.updateTile(new Point(i, j), tile);
        System.out.println(
          "Tile of type " + tile.getType() + " placed at (" + i + ", " + j + ")"
        );
      }
    }
  }

  private Tile createTileByNumber(String tileNumber) {
    tileNumber = tileNumber.trim();
    try {
      int number = Integer.parseInt(tileNumber);
      for (TileTypes tileType : TileTypes.values()) {
        if (tileType.getTileNumber() == number) {
          System.out.println(
            "Creating tile of type " + tileType + " for tile number " + number
          );
          return new Tile(tileType);
        }
      }
    } catch (NumberFormatException e) {
      System.out.println(
        "Error parsing tile number: '" + tileNumber + "' - " + e.getMessage()
      );
    }
    System.out.println(
      "No valid tile type found for tile number: " + tileNumber
    );
    return null;
  }

  private char getRandomCharacterMovement() {
    Random random = new Random();
    char[] movements = { 'W', 'A', 'S', 'D' };
    return movements[random.nextInt(movements.length)];
  }

  private char getUserInput(Scanner scanner) {
    System.out.print("Enter movement (WASD): ");
    String input = scanner.nextLine().toUpperCase();
    if (input.length() > 0 && "WASD".contains(input.substring(0, 1))) {
      return input.charAt(0);
    }
    return ' ';
  }

  private void moveCharacters(Scanner scanner) {
    for (Entity entity : world.getEntities()) {
      if (entity instanceof Character) {
        Character character = (Character) entity;
        Point currentPosition = character.getPosition();
        char direction = character.getCharacterType() == CharacterType.Playable
          ? getUserInput(scanner)
          : getRandomCharacterMovement();
        Point newPosition = getNewPosition(currentPosition, direction);

        if (isValidPosition(newPosition)) {
          updateTransportInUse(
            character,
            world.getMap().getTile(newPosition).getType()
          );
          character.moveTo(newPosition);
        }
      }
    }
  }

  private Point getNewPosition(Point currentPosition, char direction) {
    int x = currentPosition.getX();
    int y = currentPosition.getY();

    switch (direction) {
      case 'W':
        y -= 1;
        break;
      case 'S':
        y += 1;
        break;
      case 'A':
        x -= 1;
        break;
      case 'D':
        x += 1;
        break;
    }
    return new Point(x, y);
  }

  private boolean isValidPosition(Point position) {
    int x = position.getX();
    int y = position.getY();
    if (
      x < 0 ||
      x >= world.getMap().getWidth() ||
      y < 0 ||
      y >= world.getMap().getHeight()
    ) {
      return false;
    }
    TileTypes tileType = world.getMap().getTile(position).getType();
    return tileType != TileTypes.Wall;
  }

  private void updateTransportInUse(
    Character character,
    TileTypes newTileType
  ) {
    Transport[] availableTransports = character.getAvailableTransports();
    for (Transport transport : availableTransports) {
      List<TileTypes> availableTiles = transport
        .getType()
        .getTilesItCanMoveThrough();
      if (availableTiles.contains(newTileType)) {
        character.setTransportInUse(transport);
        break;
      }
    }
  }
}
