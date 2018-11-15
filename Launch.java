package battleship;

import java.util.Scanner;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class Launch extends Application {

    private Board enemyBoard, playerBoard;  

    Board b = new Board(false);

        //VBox vbox = new VBox(50, enemyBoard, playerBoard);
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        //initializess the arrays in which the coordinates are stored -EM
        int[] carrierCoord = new int[5];
        int[] battleshipCoord = new int[4];
        int[] cruiserCoord = new int[3];
        int[] submarineCoord = new int[3];
        int[] destroyerCoord = new int[2];
       
        //initializes ships
        Ship carrier =  new Ship(0,0,5,'h');
        Ship battleship = new Ship(0,2,4,'h');
        Ship cruiser = new Ship(0,3,3,'h');
        Ship submarine = new Ship(0,6,3,'h');
        Ship destroyer = new Ship(0,10,2,'h');
       
        //start of the ship input UI -EM
        primaryStage.setTitle("Ship Inputs");

        GridPane rootNode = new GridPane();
        rootNode.setPadding(new Insets(15));
        rootNode.setHgap(5);
        rootNode.setVgap(5);
        rootNode.setAlignment(Pos.CENTER);

        Scene myScene = new Scene(rootNode, 500, 500);

        rootNode.add(new Label("Carrier (X , Y) Coordinates:"), 0, 0);
        TextField carrierX = new TextField();
        rootNode.add(carrierX, 1, 0);
        TextField carrierY = new TextField();
        rootNode.add(carrierY, 2, 0);
        
        rootNode.add(new Label("Carrier Orientation: "), 0, 1);
        TextField carrierOrientation = new TextField();
        rootNode.add(carrierOrientation, 1, 1);
       
        rootNode.add(new Label("Battleship (X , Y) Coordinates:"), 0, 2);
        TextField battleshipX = new TextField();
        rootNode.add(battleshipX, 1, 2);
        TextField battleshipY = new TextField();
        rootNode.add(battleshipY, 2, 2);
        
        rootNode.add(new Label("Battleship Orientation: "), 0, 3);
        TextField battleshipOrientation = new TextField();
        rootNode.add(battleshipOrientation, 1, 3);
        
        rootNode.add(new Label("Cruiser (X , Y) Coordinates:"), 0, 4);
        TextField cruiserX = new TextField();
        rootNode.add(cruiserX, 1, 4);
        TextField cruiserY = new TextField();
        rootNode.add(cruiserY, 2, 4);
        
        rootNode.add(new Label("Cruiser Orientation: "), 0, 5);
        TextField cruiserOrientation = new TextField();
        rootNode.add(cruiserOrientation, 1, 5);
        
        rootNode.add(new Label("Submarine (X , Y) Coordinates:"), 0, 6);
        TextField submarineX = new TextField();
        rootNode.add(submarineX, 1, 6);
        TextField submarineY = new TextField();
        rootNode.add(submarineY, 2, 6);
        
        rootNode.add(new Label("Submarine Orientation: "), 0, 7);
        TextField submarineOrientation = new TextField();
        rootNode.add(submarineOrientation, 1, 7);
        
        rootNode.add(new Label("Destroyer (X , Y) Coordinates:"), 0, 8);
        TextField destroyerX = new TextField();
        rootNode.add(destroyerX, 1, 8);
        TextField destroyerY = new TextField();
        rootNode.add(destroyerY, 2, 8);
        
        rootNode.add(new Label("Destroyer Orientation: "), 0, 9);
        TextField destroyerOrientation = new TextField();
        rootNode.add(destroyerOrientation, 1, 9);
        
        Button aButton = new Button("Submit");
        rootNode.add(aButton, 1, 10);
        GridPane.setHalignment(aButton, HPos.LEFT);

        aButton.setOnAction(e -> {
            //the first couple blocks sets the desired initial X,Y coordinates
            //and orientation -EM
            carrier.setXcoord(Integer.valueOf(carrierX.getText()));
            carrier.setYcoord(Integer.valueOf(carrierY.getText()));
            carrier.setOrientation(carrierOrientation.getText().charAt(0));
            
            battleship.setXcoord(Integer.valueOf(battleshipX.getText()));
            battleship.setYcoord(Integer.valueOf(battleshipY.getText()));
            battleship.setOrientation(battleshipOrientation.getText().charAt(0));
            
            cruiser.setXcoord(Integer.valueOf(cruiserX.getText()));
            cruiser.setYcoord(Integer.valueOf(cruiserY.getText()));
            cruiser.setOrientation(cruiserOrientation.getText().charAt(0));
            
            submarine.setXcoord(Integer.valueOf(submarineX.getText()));
            submarine.setYcoord(Integer.valueOf(submarineY.getText()));
            submarine.setOrientation(submarineOrientation.getText().charAt(0));
            
            destroyer.setXcoord(Integer.valueOf(destroyerX.getText()));
            destroyer.setYcoord(Integer.valueOf(destroyerY.getText()));
            destroyer.setOrientation(destroyerOrientation.getText().charAt(0));
            
            //populates the coordinate arrays -EM
            PopulateCoord.populateCoord(carrierCoord, carrier.getXcoord(),   
                    carrier.getYcoord(), carrier.getOrientation());
            PopulateCoord.populateCoord(battleshipCoord, battleship.getXcoord(),
                    battleship.getYcoord(), battleship.getOrientation());
            PopulateCoord.populateCoord(cruiserCoord, cruiser.getXcoord(),
                    cruiser.getYcoord(), cruiser.getOrientation());
            PopulateCoord.populateCoord(submarineCoord, submarine.getXcoord(),
                    submarine.getYcoord(), submarine.getOrientation());
            PopulateCoord.populateCoord(destroyerCoord, destroyer.getXcoord(),
                    destroyer.getYcoord(), destroyer.getOrientation());
        
        
            StackPane root = new StackPane();
            root.getChildren().add(b);
    	
            Scene scene = new Scene(root, 500,500);
            primaryStage.setTitle("Battleship");
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();
        });

        primaryStage.setScene(myScene);

        primaryStage.show();
        
        /*
    	StackPane root = new StackPane();
    	root.getChildren().add(b);
    	
        Scene scene = new Scene(root, 500,500);
        primaryStage.setTitle("Battleship");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
        */
    }

    public static void main(String[] args) {
       launch(args);
    }
}

