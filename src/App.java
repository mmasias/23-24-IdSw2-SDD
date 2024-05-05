import Controllers.WorldController;
import Models.World;
import Views.WorldView;

public class App {
    private final WorldController worldController;

    public App() {
        World gameWorld = new World();
        WorldView gameWorldView = new WorldView();

        this.worldController = new WorldController(gameWorld, gameWorldView);
    }

    private void initializeGame() {
        worldController.initializeGame();
    }

    private void runGameCycle() {
        worldController.runGameCycle();
    }

    public static void main(String[] args) {
        App app = new App();
        app.initializeGame();
        app.runGameCycle();
    }
}
