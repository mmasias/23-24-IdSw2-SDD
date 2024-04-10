package Views;

import java.util.List;

import Models.*;

public class WorldView {

    public void displayWorld(World world) {
        cleanScreen();
        displayTime(world.getTime());
        displayMap(world.getMap(), world.getEntities());
    }

    public void cleanScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void displayTime(Time time) {
        System.out.println("Hora actual: " + time.getCurrentTime() + " - " + time.getTimeOfDay());
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
            int x = position.getLocation()[0];
            int y = position.getLocation()[1];
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