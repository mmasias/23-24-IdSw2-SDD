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
        adjustVisionRadius(world.getTime());
        displayTime(world.getTime());
        displayIntoConsole(world.getMap(), world.getEntities());
    }

    public void displayTime(Time time) {
        System.out.println("Hora actual: " + time.getPreciseTimeFormatted() + " - " + time.getImpreciseTime() + " es el momento:: " + time.getImpreciseTime());
    }
    private void adjustVisionRadius(Time time) {
        switch (time.getImpreciseTime()){
            case Morning:
                setVisionRadius(8);
                break;
            case Afternoon:
                setVisionRadius(10);
                break;
            case Evening:
                setVisionRadius(5);
                break;
            case Night:
                setVisionRadius(3);
                break;
        }
    }

    private String[][] displayMap(Map map, List<Entity> entities) {

        Point playerPosition = entities.get(0).getPosition();
        int playerX = playerPosition.getX();
        int playerY = playerPosition.getY();

        int size = visionRadius * 2 + 1;
        String[][] displayMatrix = new String[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                displayMatrix[i][j] = " ";
            }
        }

        for (int i = -visionRadius; i <= visionRadius; i++) {
            for (int j = -visionRadius; j <= visionRadius; j++) {
                int mapX = (playerX + j + map.getWidth()) % map.getWidth();
                int mapY = (playerY + i + map.getHeight()) % map.getHeight();
                Tile readTile = map.getTile(new Point(mapY, mapX));
                displayMatrix[i + visionRadius][j + visionRadius] = readTile.getAsciiColor() + readTile.getAsciiSymbol()
                        + "\u001B[0m";
            }
        }

        for (Entity entity : entities) {
            Point position = entity.getPosition();
            int x = (position.getX() - playerX + visionRadius + map.getWidth()) % map.getWidth();
            int y = (position.getY() - playerY + visionRadius + map.getHeight()) % map.getHeight();
            if (Math.abs(position.getY() - playerY) <= visionRadius
                    && Math.abs(position.getX() - playerX) <= visionRadius) {
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
