package GameOfLife;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        Startview startview = new Startview(primaryStage);
        Scene startScene = new Scene(startview);
        primaryStage.setTitle("Game of life: Configuration");
        primaryStage.setScene(startScene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
