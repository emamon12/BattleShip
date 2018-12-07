package battleship;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Launch extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Board b = new Board(false);

        //initializess the arrays in which the coordinates are stored -EM
        int[] carrierCoord = new int[5];
        int[] carrierCoordOther = new int[5];
        int[] battleshipCoord = new int[4];
        int[] battleshipCoordOther = new int[4];
        int[] cruiserCoord = new int[3];
        int[] cruiserCoordOther = new int[3];
        int[] submarineCoord = new int[3];
        int[] submarineCoordOther = new int[3];
        int[] destroyerCoord = new int[2];
        int[] destroyerCoordOther = new int[2];

        //initializes ships -EM
        Ship carrier = new Ship(0, 0, 5, 'h');
        Ship carrierOther = new Ship(0, 0, 5, 'h');
        Ship battleship = new Ship(0, 2, 4, 'h');
        Ship battleshipOther = new Ship(0, 2, 4, 'h');
        Ship cruiser = new Ship(0, 3, 3, 'h');
        Ship cruiserOther = new Ship(0, 3, 3, 'h');
        Ship submarine = new Ship(0, 6, 3, 'h');
        Ship submarineOther = new Ship(0, 6, 3, 'h');
        Ship destroyer = new Ship(0, 10, 2, 'h');
        Ship destroyerOther = new Ship(0, 10, 2, 'h');

        TurnCounter turn = new TurnCounter(1);

        //start of the ship input UI -EM
        primaryStage.setTitle("Ship Inputs");

        GridPane rootNode = new GridPane();
        rootNode.setPadding(new Insets(15));
        rootNode.setHgap(5);
        rootNode.setVgap(5);
        rootNode.setAlignment(Pos.CENTER);

        //sets the scene of the first player's UI. -EM
        Scene myScene = new Scene(rootNode, 700, 700);

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

        Button submitButton = new Button("Submit");
        rootNode.add(submitButton, 1, 10);
        GridPane.setHalignment(submitButton, HPos.LEFT);
        //adds a copy of the empty board -EM
        rootNode.add(b, 0, 11);
        //End of first input UI -EM

        submitButton.setOnAction(e -> {

            //Sets the (x,y) origin and orientation of each ships -EM
            //addition of an alive check for each ship whenever values are updated
            //by Ben Feldhake
            if (carrier.isAlive()) {
                carrier.setXcoord(Integer.valueOf(carrierX.getText()));
                carrier.setYcoord(Integer.valueOf(carrierY.getText()));
                carrier.setOrientation(carrierOrientation.getText().charAt(0));
                PopulateCoord.populateCoord(carrierCoord, carrier.getXcoord(),
                        carrier.getYcoord(), carrier.getOrientation());
            }
            if (battleship.isAlive()) {
                battleship.setXcoord(Integer.valueOf(battleshipX.getText()));
                battleship.setYcoord(Integer.valueOf(battleshipY.getText()));
                battleship.setOrientation(battleshipOrientation.getText().charAt(0));
                PopulateCoord.populateCoord(battleshipCoord, battleship.getXcoord(),
                        battleship.getYcoord(), battleship.getOrientation());
            }
            if (cruiser.isAlive()) {
                cruiser.setXcoord(Integer.valueOf(cruiserX.getText()));
                cruiser.setYcoord(Integer.valueOf(cruiserY.getText()));
                cruiser.setOrientation(cruiserOrientation.getText().charAt(0));
                PopulateCoord.populateCoord(cruiserCoord, cruiser.getXcoord(),
                        cruiser.getYcoord(), cruiser.getOrientation());
            }
            if (submarine.isAlive()) {
                submarine.setXcoord(Integer.valueOf(submarineX.getText()));
                submarine.setYcoord(Integer.valueOf(submarineY.getText()));
                submarine.setOrientation(submarineOrientation.getText().charAt(0));
                PopulateCoord.populateCoord(submarineCoord, submarine.getXcoord(),
                        submarine.getYcoord(), submarine.getOrientation());
            }
            if (destroyer.isAlive()) {
                destroyer.setXcoord(Integer.valueOf(destroyerX.getText()));
                destroyer.setYcoord(Integer.valueOf(destroyerY.getText()));
                destroyer.setOrientation(destroyerOrientation.getText().charAt(0));
                PopulateCoord.populateCoord(destroyerCoord, destroyer.getXcoord(),
                        destroyer.getYcoord(), destroyer.getOrientation());
            }
            //end of array population -EM.

            //starts the UI of ship input of Player 2. -EM
            primaryStage.setTitle("Ship Inputs Other");

            GridPane rootNodeOther = new GridPane();
            rootNodeOther.setPadding(new Insets(15));
            rootNodeOther.setHgap(5);
            rootNodeOther.setVgap(5);
            rootNodeOther.setAlignment(Pos.CENTER);

            Scene myOtherScene = new Scene(rootNodeOther, 700, 700);

            rootNodeOther.add(new Label("Carrier (X , Y) Coordinates:"), 0, 0);
            TextField carrierXOther = new TextField();
            rootNodeOther.add(carrierXOther, 1, 0);
            TextField carrierYOther = new TextField();
            rootNodeOther.add(carrierYOther, 2, 0);

            rootNodeOther.add(new Label("Carrier Orientation: "), 0, 1);
            TextField carrierOrientationOther = new TextField();
            rootNodeOther.add(carrierOrientationOther, 1, 1);

            rootNodeOther.add(new Label("Battleship (X , Y) Coordinates:"), 0, 2);
            TextField battleshipXOther = new TextField();
            rootNodeOther.add(battleshipXOther, 1, 2);
            TextField battleshipYOther = new TextField();
            rootNodeOther.add(battleshipYOther, 2, 2);

            rootNodeOther.add(new Label("Battleship Orientation: "), 0, 3);
            TextField battleshipOrientationOther = new TextField();
            rootNodeOther.add(battleshipOrientationOther, 1, 3);

            rootNodeOther.add(new Label("Cruiser (X , Y) Coordinates:"), 0, 4);
            TextField cruiserXOther = new TextField();
            rootNodeOther.add(cruiserXOther, 1, 4);
            TextField cruiserYOther = new TextField();
            rootNodeOther.add(cruiserYOther, 2, 4);

            rootNodeOther.add(new Label("Cruiser Orientation: "), 0, 5);
            TextField cruiserOrientationOther = new TextField();
            rootNodeOther.add(cruiserOrientationOther, 1, 5);

            rootNodeOther.add(new Label("Submarine (X , Y) Coordinates:"), 0, 6);
            TextField submarineXOther = new TextField();
            rootNodeOther.add(submarineXOther, 1, 6);
            TextField submarineYOther = new TextField();
            rootNodeOther.add(submarineYOther, 2, 6);

            rootNodeOther.add(new Label("Submarine Orientation: "), 0, 7);
            TextField submarineOrientationOther = new TextField();
            rootNodeOther.add(submarineOrientationOther, 1, 7);

            rootNodeOther.add(new Label("Destroyer (X , Y) Coordinates:"), 0, 8);
            TextField destroyerXOther = new TextField();
            rootNodeOther.add(destroyerXOther, 1, 8);
            TextField destroyerYOther = new TextField();
            rootNodeOther.add(destroyerYOther, 2, 8);

            rootNodeOther.add(new Label("Destroyer Orientation: "), 0, 9);
            TextField destroyerOrientationOther = new TextField();
            rootNodeOther.add(destroyerOrientationOther, 1, 9);

            Button submitButtonOther = new Button("Submit Other");
            rootNodeOther.add(submitButtonOther, 1, 10);
            GridPane.setHalignment(submitButtonOther, HPos.LEFT);

            rootNodeOther.add(b, 0, 11);

            primaryStage.setScene(myOtherScene);
            primaryStage.show();
            //end of ship input UI of Player 2. - EM
            submitButtonOther.setOnAction(f -> {

                //Sets the other player's X, Y origins, and the orientation per ships. -EM
                //addition of an alive check for each ship whenever values are updated
                //by Ben Feldhake
                if (carrierOther.isAlive()) {
                    carrierOther.setXcoord(Integer.valueOf(carrierXOther.getText()));
                    carrierOther.setYcoord(Integer.valueOf(carrierYOther.getText()));
                    carrierOther.setOrientation(carrierOrientationOther.getText().charAt(0));
                    PopulateCoord.populateCoord(carrierCoordOther, carrierOther.getXcoord(),
                            carrierOther.getYcoord(), carrierOther.getOrientation());
                }
                if (battleshipOther.isAlive()) {
                    battleshipOther.setXcoord(Integer.valueOf(battleshipXOther.getText()));
                    battleshipOther.setYcoord(Integer.valueOf(battleshipYOther.getText()));
                    battleshipOther.setOrientation(battleshipOrientationOther.getText().charAt(0));
                    PopulateCoord.populateCoord(battleshipCoordOther, battleshipOther.getXcoord(),
                            battleshipOther.getYcoord(), battleshipOther.getOrientation());
                }
                if (cruiserOther.isAlive()) {
                    cruiserOther.setXcoord(Integer.valueOf(cruiserXOther.getText()));
                    cruiserOther.setYcoord(Integer.valueOf(cruiserYOther.getText()));
                    cruiserOther.setOrientation(cruiserOrientationOther.getText().charAt(0));
                    PopulateCoord.populateCoord(cruiserCoordOther, cruiserOther.getXcoord(),
                            cruiserOther.getYcoord(), cruiserOther.getOrientation());
                }
                if (submarineOther.isAlive()) {
                    submarineOther.setXcoord(Integer.valueOf(submarineXOther.getText()));
                    submarineOther.setYcoord(Integer.valueOf(submarineYOther.getText()));
                    submarineOther.setOrientation(submarineOrientationOther.getText().charAt(0));
                    PopulateCoord.populateCoord(submarineCoordOther, submarineOther.getXcoord(),
                            submarineOther.getYcoord(), submarineOther.getOrientation());
                }
                if (destroyerOther.isAlive()) {
                    destroyerOther.setXcoord(Integer.valueOf(destroyerXOther.getText()));
                    destroyerOther.setYcoord(Integer.valueOf(destroyerYOther.getText()));
                    destroyerOther.setOrientation(destroyerOrientationOther.getText().charAt(0));
                    PopulateCoord.populateCoord(destroyerCoordOther, destroyerOther.getXcoord(),
                            destroyerOther.getYcoord(), destroyerOther.getOrientation());
                }
                //end of the ship object manipulation. -EM

                //these two board calls populate the board accordingly to player -EM
                Board playerOnePlacement = new Board(carrierCoord, battleshipCoord,
                        cruiserCoord, submarineCoord, destroyerCoord, carrier,
                        battleship, cruiser, submarine, destroyer);

                Board playerTwoPlacement = new Board(carrierCoordOther, battleshipCoordOther,
                        cruiserCoordOther, submarineCoordOther, destroyerCoordOther,
                        carrierOther, battleshipOther, cruiserOther,
                        submarineOther, destroyerOther);
                //end of the two board calls

                //start the display of the first state of the Battleship game of Player 1 -EM
                primaryStage.setTitle("Battleship: Player 1");

                GridPane playerOneBoard = new GridPane();

                playerOneBoard.setPadding(new Insets(15));
                playerOneBoard.setHgap(5);
                playerOneBoard.setVgap(5);
                playerOneBoard.setAlignment(Pos.CENTER);

                Scene oneBoard = new Scene(playerOneBoard, 1000, 500);

                playerOneBoard.add(new Label("Player 1 Board"), 0, 0);
                playerOneBoard.add(new Label("Player 2 Board"), 1, 0);

                playerOneBoard.add(playerOnePlacement, 0, 1);
                playerOneBoard.add(b, 1, 1);

                //Ben Feldhake -- Adding shot functionality maybe?
                playerOneBoard.add(new Label("Shoot at (X , Y):"), 0, 2);
                TextField shotX = new TextField();
                playerOneBoard.add(shotX, 0, 3);
                TextField shotY = new TextField();
                playerOneBoard.add(shotY, 1, 3);

                //need these for shots to get recognized globally -BF
                TextField shotXOther = new TextField();
                TextField shotYOther = new TextField();

                //this button switches the state of the current board to player 2's board -EM
                Button playerOneSwitch = new Button("Player 1 - Fire Shot");
                //this button switches the state of the current board to player 1's board -EM
                Button playerTwoSwitch = new Button("Player 2 - Fire Shot");

                playerOneBoard.add(playerOneSwitch, 1, 4);
                GridPane.setHalignment(playerOneSwitch, HPos.CENTER);
                playerOneBoard.add(new Label("Turn: " + turn.getTurn()), 0, 4);

                primaryStage.setScene(oneBoard);
                primaryStage.setResizable(false);
                primaryStage.show();
                //end scene

                //starts the next state of the Battleship game of Player 2 -EM
                playerOneSwitch.setOnAction(g -> {
                    primaryStage.setTitle("Battleship: Player 2");

                    //Check for if the shot hits a ship and subtract health - BF
                    //System.out.println("Shot Coordinates: (" + Integer.valueOf(shotX.getText()) + ", " + Integer.valueOf(shotY.getText()) + ")\n");
                    carrierOther.isHit(Integer.valueOf(shotX.getText()), Integer.valueOf(shotY.getText()));
                    battleshipOther.isHit(Integer.valueOf(shotX.getText()), Integer.valueOf(shotY.getText()));
                    cruiserOther.isHit(Integer.valueOf(shotX.getText()), Integer.valueOf(shotY.getText()));
                    submarineOther.isHit(Integer.valueOf(shotX.getText()), Integer.valueOf(shotY.getText()));
                    destroyerOther.isHit(Integer.valueOf(shotX.getText()), Integer.valueOf(shotY.getText()));
                    System.out.println("\nPlayer 2\n==================================");
                    System.out.println("Player 2 carrier: " + carrierOther.getHealth());
                    System.out.println("Player 2 battleship: " + battleshipOther.getHealth());
                    System.out.println("Player 2 cruiser: " + cruiserOther.getHealth());
                    System.out.println("Player 2 submarine: " + submarineOther.getHealth());
                    System.out.println("Player 2 destroyer: " + destroyerOther.getHealth());

                    if (!carrierOther.isAlive()
                            && !battleshipOther.isAlive()
                            && !cruiserOther.isAlive()
                            && !submarineOther.isAlive()
                            && !destroyerOther.isAlive()) {

                        System.out.println("\n==================");
                        System.out.println("\nPlayer 1 wins!");
                        System.out.println("\n==================");
                    }

                    turn.setTurn(turn.getTurn() + 1);

                    GridPane playerTwoBoard = new GridPane();

                    playerTwoBoard.setPadding(new Insets(15));
                    playerTwoBoard.setHgap(5);
                    playerTwoBoard.setVgap(5);
                    playerTwoBoard.setAlignment(Pos.CENTER);

                    Scene twoBoard = new Scene(playerTwoBoard, 1000, 500);

                    playerTwoBoard.add(new Label("Player 2 Board"), 0, 0);
                    playerTwoBoard.add(new Label("Player 1 Board"), 1, 0);

                    playerTwoBoard.add(playerTwoPlacement, 0, 1);
                    playerTwoBoard.add(b, 1, 1);

                    //Ben Feldhake -- Adding shot functionality maybe?
                    playerTwoBoard.add(new Label("Shoot at (X , Y):"), 0, 2);
                    playerTwoBoard.add(shotXOther, 0, 3);
                    playerTwoBoard.add(shotYOther, 1, 3);

                    playerTwoBoard.add(playerTwoSwitch, 1, 4);
                    GridPane.setHalignment(playerTwoSwitch, HPos.CENTER);
                    playerTwoBoard.add(new Label("Turn: " + turn.getTurn()), 0, 4);

                    primaryStage.setScene(twoBoard);
                    primaryStage.setResizable(false);
                    primaryStage.show();
                });
                //starts the next state of the Battleship game of Player 1. -EM
                playerTwoSwitch.setOnAction(h -> {
                    primaryStage.setTitle("Battleship: Player 1");

                    //Check for if the shot hits a ship and subtract health - BF
                    carrier.isHit(Integer.valueOf(shotXOther.getText()), Integer.valueOf(shotYOther.getText()));
                    battleship.isHit(Integer.valueOf(shotXOther.getText()), Integer.valueOf(shotYOther.getText()));
                    cruiser.isHit(Integer.valueOf(shotXOther.getText()), Integer.valueOf(shotYOther.getText()));
                    submarine.isHit(Integer.valueOf(shotXOther.getText()), Integer.valueOf(shotYOther.getText()));
                    destroyer.isHit(Integer.valueOf(shotXOther.getText()), Integer.valueOf(shotYOther.getText()));
                    System.out.println("\nPlayer 1\n==================================");
                    System.out.println("Player 1 carrier: " + carrier.getHealth());
                    System.out.println("Player 1 battleship: " + battleship.getHealth());
                    System.out.println("Player 1 cruiser: " + cruiser.getHealth());
                    System.out.println("Player 1 submarine: " + submarine.getHealth());
                    System.out.println("Player 1 destroyer: " + destroyer.getHealth());

                    if (!carrier.isAlive()
                            && !battleship.isAlive()
                            && !cruiser.isAlive()
                            && !submarine.isAlive()
                            && !destroyer.isAlive()) {

                        System.out.println("\n==================");
                        System.out.println("\nPlayer 2 wins!");
                        System.out.println("\n==================");
                    }

                    turn.setTurn(turn.getTurn() + 1);

                    GridPane playerOneBoardNext = new GridPane();

                    playerOneBoardNext.setPadding(new Insets(15));
                    playerOneBoardNext.setHgap(5);
                    playerOneBoardNext.setVgap(5);
                    playerOneBoardNext.setAlignment(Pos.CENTER);

                    Scene oneBoardNext = new Scene(playerOneBoardNext, 1000, 500);

                    playerOneBoardNext.add(new Label("Player 1 Board"), 0, 0);
                    playerOneBoardNext.add(new Label("Player 2 Board"), 1, 0);

                    playerOneBoardNext.add(playerOnePlacement, 0, 1);
                    playerOneBoardNext.add(b, 1, 1);

                    //Ben Feldhake -- Adding shot functionality maybe?
                    playerOneBoardNext.add(new Label("Shoot at (X , Y):"), 0, 2);
                    playerOneBoardNext.add(shotX, 0, 3);
                    playerOneBoardNext.add(shotY, 1, 3);

                    playerOneBoardNext.add(playerOneSwitch, 1, 4);
                    GridPane.setHalignment(playerOneSwitch, HPos.CENTER);
                    playerOneBoardNext.add(new Label("Turn: " + turn.getTurn()), 0, 4);

                    primaryStage.setScene(oneBoardNext);
                    primaryStage.setResizable(false);
                    primaryStage.show();
                });
            });
        });
        primaryStage.setScene(myScene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

//Ben Feldhake -- If we want to hook up the shots firing, it would have to work something like this
//if (Integer.valueOf(shotX.getText()) == *ship.getXCoord() && Integer.valueOf(shotY.getText()) == *ship.getYCoord()) {
//  *ship.setHealth(ship.getHealth() - 1);
//}
