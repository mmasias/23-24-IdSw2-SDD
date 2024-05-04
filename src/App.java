import Controllers.WorldController;
import Models.World;
import Views.WorldView;

// (Eduardo)
// TODO: #38 Remove unused methods 
// (Recinos)
// TODO: #39 Update Domain Model Diagrams to reflect the latest project structure and relationships between classes. 
// (JuanJo)
// TODO: #40 Design correct Use Cases Diagrams to ensure that all user interactions and system functionalities are accurately represented. (JuanJo)

public class App {

    private WorldController worldController;

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
