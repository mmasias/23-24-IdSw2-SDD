package Controllers;

import Enums.CharacterType;
import Enums.TileTypes;
import Enums.TransportTypes;
import Models.Map;
import Models.Point;
import Models.Tile;
import Models.World;
import Views.WorldView;
import Models.Character;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class WorldController {

    private World world;
    private WorldView worldView;

    private void initializeWorldMap() {
        String path = " ";
        List<String[]> mapData = this.readFileContent(path);
        populateMap(mapData, world.getMap());
    }

    private void initializeWorldEntities() {
    }

    public List<String[]> readFileContent(String filePath) {

        List<String[]> listTiles = new ArrayList<String[]>();
        try {
            File file = new File(filePath);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(",", 0);
                listTiles.add(tokens);
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Failed to read file");
            System.out.println(e.getMessage());
        }
        return listTiles;
    }

    private void populateMap(List<String[]> mapData, Map worldMap) {
        for (int i = 0; i < mapData.size(); i++) {
            for (int j = 0; j < mapData.get(i).length; j++) {
                worldMap.updateTile(new Point(i, j), createTileByNumber(mapData.get(i)[j]));
            }
        }
    }

    private Tile createTileByNumber(String tileNumber) {
        for (TileTypes tileType : TileTypes.values()) {
            if (String.valueOf(tileType.getTileNumber()).equals(tileNumber)) {
                return new Tile(tileType);
            }
        }
        return null;
    }

    private char getRandomCharacterMovement() {
        Random random = new Random();
        char[] movements = { 'W', 'A', 'S', 'D' };
        return movements[random.nextInt(movements.length)];
    }

    private char getUserInput() {
        Scanner scanner = new Scanner(System.in);
        return processUserInput(Character.toUpperCase(scanner.nextLine().charAt(0)));
    }

    private char processUserInput(char input) {
        if (input == ('W' | 'A' | 'S' | 'D')) {
            return input;
        } else {
            return ' ';
        }
    }

    private void moveCharacter(Character character) {
        int[] movement = getCharacterMovement(character);
        Point newLocation = new Point(movement[0], movement[1]);

        if (movement[0] > world.getMap().getWidth())
            movement[0]--;
        if (movement[1] > world.getMap().getHeight())
            movement[1]--;
        if (movement[0] < 0)
            movement[0]++;
        if (movement[1] < 0)
            movement[1]++;

        updateTransportInUse(character, world.getMap().getTile(character.getPosition()).getType());

        character.moveTo(newLocation);
    }

    private int[] getCharacterMovement(Character character) {
        char direction = ' ';
        int[] actualLocation = character.getPosition().getLocation();

        if (character.getCharacterType() == CharacterType.Playable) {
            direction = getUserInput();
        } else {
            direction = getRandomCharacterMovement();
        }

        switch (direction) {
            case 'W':
                actualLocation[1]++;
                break;
            case 'A':
                actualLocation[0]--;
                break;
            case 'S':
                actualLocation[1]--;
                break;
            case 'D':
                actualLocation[0]++;
                break;
            default:
                break;
        }
        return actualLocation;
    }

    private void updateTransportInUse(Character character, TileTypes tileType) {
        for (int i = 0; i <= character.getAvailableTransports().length; i++) {
            List<TileTypes> availableTiles = character.getAvailableTransports()[i].getType().getTilesItCanMoveThrough();
            for (int j = 0; j <= availableTiles.size(); j++) {
                if (availableTiles.get(j) == tileType) {
                    character.setTransportInUse(character.getAvailableTransports()[i]);
                }
            }
        }
    }

}
