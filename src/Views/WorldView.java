package Views;

import java.util.List;

import Models.*;

//(Lucía)

// TODO: #32 Consider separating the console display functionality into a separate class or method.

// TODO: #33 Enhance the displayMap method to support color output by integrating ANSI color codes read from Tile and Transport enums.


public class WorldView {
    public void displayWorld(World world) {
        displayTime(world.getTime());
        displayIntoConsole(world.getMap(), world.getEntities());
    }

    public void displayTime(Time time) {
        System.out.println("Hora actual: " + time.getCurrentTime() + " - " + time.getTimeOfDay());
    }

    private String[][] displayMap(Map map, List<Entity> entities) {
        String[][] displayMatrix = new String[map.getHeight()][map.getWidth()];

        for (int i = 0; i < map.getHeight(); i++) {
            for (int j = 0; j < map.getWidth(); j++) {
                Tile readTile = map.getTile(new Point(i, j));
                displayMatrix[i][j] = readTile.getAsciiColor() + readTile.getAsciiSymbol() + "\u001B[0m";
            }
        }

        for (Entity entity : entities) {
            Point position = entity.getPosition();
            int x = position.getX();
            int y = position.getY();
            displayMatrix[y][x] = entity.getTransportInUse().getAsciiSymbol();
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