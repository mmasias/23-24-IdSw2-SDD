package Views;

import java.util.List;

import Models.*;

//(Lucía)

// TODO: #32 Consider separating the console display functionality into a separate class or method.

// TODO: #33 Enhance the displayMap method to support color output by integrating ANSI color codes read from Tile and Transport enums.


public class WorldView {
    public void displayWorld(World world) {
        displayTime(world.getTime());
        displayMap(world.getMap(), world.getEntities());
    }

    public void displayTime(Time time) {
        System.out.println("Hora actual: " + time.getPreciseTimeFormatted() + " - " + time.getImpreciseTime());
    }

    public void displayMap(Map map, List<Entity> entities) {
        String[][] displayMatrix = new String[map.getHeight()][map.getWidth()];

        for (int i = 0; i < map.getHeight(); i++) {
            for (int j = 0; j < map.getWidth(); j++) {
                displayMatrix[i][j] = map.getTile(new Point(i, j)).getAsciiSymbol();
            }
        }

        for (Entity entity : entities) {
            Point position = entity.getPosition();
            int x = position.getX();
            int y = position.getY();
            displayMatrix[y][x] = entity.getTransportInUse().getAsciiSymbol();
        }

        for (String[] row : displayMatrix) {
            for (String symbol : row) {
                System.out.print(symbol + " ");
            }
            System.out.println();
        }
    }
}