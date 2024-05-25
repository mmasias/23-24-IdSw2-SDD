package Views;

import java.util.List;
import Enums.CharacterType;
import Models.*;
import Models.Character;

public class WorldView {
    private int visionRadius = 5;

    public void setVisionRadius(int radius) {
        this.visionRadius = radius;
    }

    public void displayWorld(World world) {
        displayTime(world.getTime());
        displayIntoConsole(world.getMap(), world.getEntities());
    }

    public void displayTime(Time time) {
        System.out.println("Hora actual: " + time.getPreciseTimeFormatted() + " - " + time.getImpreciseTime());
    }

    private String[][] displayMap(Map map, List<Entity> entities) {
        String[][] displayMatrix = new String[map.getHeight()][map.getWidth()];

        Point playerPosition = entities.get(0).getPosition();
        int playerX = playerPosition.getX();
        int playerY = playerPosition.getY();

        for (int i = 0; i < map.getHeight(); i++) {
            for (int j = 0; j < map.getWidth(); j++) {
                if (Math.abs(i - playerY) <= visionRadius && Math.abs(j - playerX) <= visionRadius) {
                    Tile readTile = map.getTile(new Point(i, j));
                    displayMatrix[i][j] = readTile.getAsciiColor() + readTile.getAsciiSymbol() + "\u001B[0m";
                } else {
                    displayMatrix[i][j] = " ";
                }
            }
        }

        for (Entity entity : entities) {
            Point position = entity.getPosition();
            int x = position.getX();
            int y = position.getY();
            if (Math.abs(y - playerY) <= visionRadius && Math.abs(x - playerX) <= visionRadius) {
                Transport entityTransport = entity.getTransportInUse();
                Character entityCharacter = (Character) entity;
                CharacterType characterType = entityCharacter.getCharacterType();
                displayMatrix[y][x] = characterType.getAsciiColor() + entityTransport.getAsciiSymbol() + "\u001B[0m";
            }
        }
        return displayMatrix;
    }

    public void displayIntoConsole(Map map, List<Entity> entities) {
        String[][] matrixMap = displayMap(map, entities);
        for (String[] row : matrixMap) {
            for (String symbol : row) {
                System.out.print(symbol + " ");
            }
            System.out.println();
        }
    }
}