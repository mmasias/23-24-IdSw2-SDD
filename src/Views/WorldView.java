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
        // Obtener la posición del jugador (asumimos que el jugador es la primera
        // entidad)
        Point playerPosition = entities.get(0).getPosition();
        int playerX = playerPosition.getX();
        int playerY = playerPosition.getY();

        // Calcular el tamaño del área de visualización basado en el radio de visión
        int size = visionRadius * 2 + 1;
        String[][] displayMatrix = new String[size][size];

        // Inicializar la matriz con espacios en blanco
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                displayMatrix[i][j] = " ";
            }
        }

        // Llenar la matriz solo con los tiles dentro del radio de visión
        for (int i = -visionRadius; i <= visionRadius; i++) {
            for (int j = -visionRadius; j <= visionRadius; j++) {
                int mapX = (playerX + j + map.getWidth()) % map.getWidth();
                int mapY = (playerY + i + map.getHeight()) % map.getHeight();
                Tile readTile = map.getTile(new Point(mapY, mapX));
                displayMatrix[i + visionRadius][j + visionRadius] = readTile.getAsciiColor() + readTile.getAsciiSymbol()
                        + "\u001B[0m";
            }
        }

        // Colocar las entidades dentro del rango de visión
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
