package Views;

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
        Tile[][] tiles = map.getTiles();
        String[][] displayMatrix = new String[map.getHeight()][map.getWidth()];

        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                displayMatrix[i][j] = tiles[i][j].getAsciiSymbol();
            }
        }

        for (Entity entity : entities) {
            int x = entity.getPosition().getX();
            int y = entity.getPosition().getY();

            displayMatrix[y][x] = entity.getCurrentTransport().getAsciiSymbol();
        }

        for (String[] row : displayMatrix) {
            for (String symbol : row) {
                System.out.print(symbol + " ");
            }
            System.out.println();
        }
    }
}