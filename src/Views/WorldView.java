package Views;

import java.util.List;
import Enums.CharacterType;
import Models.*;
import Models.Character;
import Enums.ImpreciseTime;

public class WorldView {
    private static final int VIEWPORT_SIZE = 16;
    private static final String BORDER_COLOR = "\u001B[44m";
    private static final String RESET_COLOR = "\u001B[0m";

    public void displayWorld(World world) {
        clearConsole();
        displayStats(world);
        displayViewport(world.getMap(), world.getEntities(), world.getTime());
    }

    private void displayStats(World world) {
        Time time = world.getTime();
        Character player = getPlayer(world.getEntities());
        if (player != null) {
            Point position = player.getPosition();
            Transport transport = player.getTransportInUse();
            System.out.printf("Current time: %s - %s%n", time.getPreciseTimeFormatted(), time.getImpreciseTime());
            System.out.printf("Player at (%d, %d) on transport: %s%n", position.getX(), position.getY(), transport != null ? transport.getType() : "None");
        } else {
            System.out.printf("Current time: %s - %s%n", time.getPreciseTimeFormatted(), time.getImpreciseTime());
            System.out.println("Player not found!");
        }
    }

    private void displayViewport(Map map, List<Entity> entities, Time time) {
        int viewDistance = calculateViewDistance(time.getImpreciseTime());
        Character player = getPlayer(entities);
        if (player == null) {
            return;
        }

        Point playerPosition = player.getPosition();
        int[] playerCoords = {playerPosition.getX(), playerPosition.getY()};

        int[] viewportBounds = calculateViewportBounds(map, playerCoords);
        Viewport viewport = new Viewport(viewportBounds[0], viewportBounds[1], viewportBounds[2], viewportBounds[3], viewDistance, time.getImpreciseTime());

        String[][] matrixMap = createDisplayMatrix(map, entities, viewport, playerCoords);
        printMatrixWithBorder(matrixMap);
        displayPrompt();
    }

    private int calculateViewDistance(ImpreciseTime time) {
        switch (time) {
            case Morning:
                return VIEWPORT_SIZE / 3;
            case Afternoon:
                return VIEWPORT_SIZE;
            case Evening:
                return VIEWPORT_SIZE / 3;
            case Night:
                return VIEWPORT_SIZE / 5;
            default:
                return VIEWPORT_SIZE;
        }
    }

    private String[][] createDisplayMatrix(Map map, List<Entity> entities, Viewport viewport, int[] playerCoords) {
        String[][] displayMatrix = initializeDisplayMatrix();
        fillDisplayMatrix(map, displayMatrix, viewport, playerCoords);
        addEntitiesToDisplayMatrix(displayMatrix, entities, viewport, playerCoords);
        return displayMatrix;
    }

    private String[][] initializeDisplayMatrix() {
        return new String[VIEWPORT_SIZE][VIEWPORT_SIZE];
    }

    private Character getPlayer(List<Entity> entities) {
        return (Character) entities.stream().filter(e -> e instanceof Character && ((Character) e).getCharacterType() == CharacterType.Playable).findFirst().orElse(null);
    }

    private int[] calculateViewportBounds(Map map, int[] playerCoords) {
        int playerX = playerCoords[0];
        int playerY = playerCoords[1];
        int mapWidth = map.getWidth();
        int mapHeight = map.getHeight();
        int viewportStartX = Math.max(0, playerX - VIEWPORT_SIZE / 2);
        int viewportStartY = Math.max(0, playerY - VIEWPORT_SIZE / 2);
        int viewportEndX = Math.min(mapWidth, playerX + VIEWPORT_SIZE / 2);
        int viewportEndY = Math.min(mapHeight, playerY + VIEWPORT_SIZE / 2);

        if (playerX < VIEWPORT_SIZE / 2) {
            viewportStartX = 0;
            viewportEndX = Math.min(mapWidth, VIEWPORT_SIZE);
        } else if (playerX > mapWidth - VIEWPORT_SIZE / 2) {
            viewportStartX = Math.max(0, mapWidth - VIEWPORT_SIZE);
            viewportEndX = mapWidth;
        }

        if (playerY < VIEWPORT_SIZE / 2) {
            viewportStartY = 0;
            viewportEndY = Math.min(mapHeight, VIEWPORT_SIZE);
        } else if (playerY > mapHeight - VIEWPORT_SIZE / 2) {
            viewportStartY = Math.max(0, mapHeight - VIEWPORT_SIZE);
            viewportEndY = mapHeight;
        }

        return new int[]{viewportStartX, viewportStartY, viewportEndX, viewportEndY};
    }

    private void fillDisplayMatrix(Map map, String[][] displayMatrix, Viewport viewport, int[] playerCoords) {
        int playerX = playerCoords[0];
        int playerY = playerCoords[1];
        int mapWidth = map.getWidth();
        int mapHeight = map.getHeight();
        int centerX = playerX;
        int centerY = playerY;

        for (int i = 0; i < VIEWPORT_SIZE; i++) {
            for (int j = 0; j < VIEWPORT_SIZE; j++) {
                int mapX = viewport.getViewportStartX() + j;
                int mapY = viewport.getViewportStartY() + i;
                if (mapX < mapWidth && mapY < mapHeight) {
                    int distance = (int) Math.sqrt(Math.pow(mapX - centerX, 2) + Math.pow(mapY - centerY, 2));
                    if (distance <= viewport.getViewDistance()) {
                        Tile readTile = map.getTile(new Point(mapX, mapY));
                        displayMatrix[i][j] = adjustColorForTime(readTile.getAsciiColor(), viewport.getTime()) + readTile.getAsciiSymbol() + RESET_COLOR;
                    } else {
                        displayMatrix[i][j] = "   ";
                    }
                } else {
                    displayMatrix[i][j] = "   ";
                }
            }
        }
    }

    private void addEntitiesToDisplayMatrix(String[][] displayMatrix, List<Entity> entities, Viewport viewport, int[] playerCoords) {
        int playerX = playerCoords[0];
        int playerY = playerCoords[1];
        int centerX = playerX;
        int centerY = playerY;

        for (Entity entity : entities) {
            if (entity instanceof Character && ((Character) entity).getCharacterType() == CharacterType.Playable) {
                Point position = entity.getPosition();
                int x = position.getX();
                int y = position.getY();
                if (x >= viewport.getViewportStartX() && x < viewport.getViewportEndX() && y >= viewport.getViewportStartY() && y < viewport.getViewportEndY()) {
                    int distance = (int) Math.sqrt(Math.pow(x - centerX, 2) + Math.pow(y - centerY, 2));
                    if (distance <= viewport.getViewDistance()) {
                        int displayX = x - viewport.getViewportStartX();
                        int displayY = y - viewport.getViewportStartY();
                        Transport entityTransport = entity.getTransportInUse();
                        Character entityCharacter = (Character) entity;
                        CharacterType characterType = entityCharacter.getCharacterType();
                        displayMatrix[displayY][displayX] = adjustColorForTime(characterType.getAsciiColor(), viewport.getTime()) + entityTransport.getAsciiSymbol() + RESET_COLOR;
                    }
                }
            }
        }
    }

    private String adjustColorForTime(String baseColor, ImpreciseTime time) {
        switch (time) {
            case Morning:
                return "\u001B[2m" + baseColor;
            case Afternoon:
                return baseColor;
            case Evening:
                return "\u001B[2m" + baseColor;
            case Night:
                return "\u001B[2;90m" + baseColor;
            default:
                return baseColor;
        }
    }

    private void printMatrixWithBorder(String[][] matrix) {
        String borderRow = BORDER_COLOR + " ".repeat(VIEWPORT_SIZE * 3 + 2) + RESET_COLOR;

        System.out.println(borderRow);

        for (String[] row : matrix) {
            System.out.print(BORDER_COLOR + " " + RESET_COLOR);
            for (String symbol : row) {
                System.out.print(symbol);
            }
            System.out.println(BORDER_COLOR + " " + RESET_COLOR);
        }

        System.out.println(borderRow);
    }

    private void displayPrompt() {
        System.out.println("Enter movement (WASD) or 'Q' to quit:");
    }

    private void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
