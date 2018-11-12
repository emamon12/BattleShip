package riperonibattleroni;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class Launch extends Application {

    private Board enemyBoard, playerBoard;  

    Board b = new Board(false);

        //VBox vbox = new VBox(50, enemyBoard, playerBoard);
      
    public void start(Stage primaryStage) throws Exception {
    	
    	StackPane root = new StackPane();
    	root.getChildren().add(b);
    	
        Scene scene = new Scene(root, 500,500);
        primaryStage.setTitle("Battleship");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

