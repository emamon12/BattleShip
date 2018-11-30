package battleship;

import javafx.scene.Parent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Board extends Parent{
    private VBox rows = new VBox();
    private boolean enemy = false;
    public int ships = 5;
   
    public Board(boolean enemy) {
        this.enemy = enemy;
        
        for (int y = 0; y < 10; y++) {
            HBox row = new HBox();
            for (int x = 0; x < 10; x++) {
                Cell c = new Cell(x, y, this);
                row.getChildren().add(c);
            }
            rows.getChildren().add(row);
        }
        getChildren().add(rows);
    }
    /**
     *
     * @see Launch
     * @since version 0.2.2
     * @author Elijah Joshua Mamon
     * <p>
     * A specialized Board constructor that when a coordinate is found in
     * the coordinate array, when the Cell is created, it colors it a Green.<p/>
     */
    Board(int[] carrierArray, int[] battleshipArray, int[] cruiserArray,
            int[] submarineArray, int[] destroyerArray, 
            Ship carrier, Ship battleship, Ship cruiser, Ship submarine, 
            Ship destroyer){
        
        //when the coordinate is found within the coordinate arrays, it becomes false.
        boolean coordNotFound;
        
        for (int y = 0; y < 10; y++) {
            HBox row = new HBox();
            for (int x = 0; x < 10; x++) {
                coordNotFound = true;
                /*if the orientation is horizontal, it only checks the array
                * whenever the initial Y coordinate is similar to the y value.
                * if they are similar, compares the value of x to the value of
                * all of the values of the array -EM
                */
                if (carrier.getOrientation() == 'h' &&
                        carrier.getYcoord() == y) {
                    for (int i = 0; i < carrierArray.length; i++) {
                        if (carrierArray[i] == x) {
                            Cell c = new Cell(x, y, this, true);
                            row.getChildren().add(c);
                            coordNotFound = false;
                        }
                    }
                }
                /*if the orientation is vertical, it only checks the array
                * whenever the initial X coordinate is similar to the y value.
                * if they are similar, compares the value of y to the value of
                * all of the values of the array. This is done for all ships. -EM
                */ 
                else if(carrier.getOrientation() == 'v' &&
                        carrier.getXcoord() == x) {
                    for (int j = 0; j < carrierArray.length; j++) {
                        if (carrierArray[j] == y) {
                            Cell c = new Cell(x, y, this, true);
                            row.getChildren().add(c);
                            coordNotFound = false;
                        }
                    }
                }
                
                if (battleship.getOrientation() == 'h' &&
                        battleship.getYcoord() == y) {
                    for (int i = 0; i < battleshipArray.length; i++) {
                        if (battleshipArray[i] == x) {
                            Cell c = new Cell(x, y, this, true);
                            row.getChildren().add(c);
                            coordNotFound = false;
                        }
                    }
                }
                else if(battleship.getOrientation() == 'v' &&
                        battleship.getXcoord() == x) {
                    for (int j = 0; j < battleshipArray.length; j++) {
                        if (battleshipArray[j] == y) {
                            Cell c = new Cell(x, y, this, true);
                            row.getChildren().add(c);
                            coordNotFound = false;
                        }
                    }
                }
                
                if (cruiser.getOrientation() == 'h' &&
                        cruiser.getYcoord() == y) {
                    for (int i = 0; i < cruiserArray.length; i++) {
                        if (cruiserArray[i] == x) {
                            Cell c = new Cell(x, y, this, true);
                            row.getChildren().add(c);
                            coordNotFound = false;
                        }
                    }
                }
                else if(cruiser.getOrientation() == 'v' &&
                        cruiser.getXcoord() == x) {
                    for (int j = 0; j < cruiserArray.length; j++) {
                        if (cruiserArray[j] == y) {
                            Cell c = new Cell(x, y, this, true);
                            row.getChildren().add(c);
                            coordNotFound = false;
                        }
                    }
                }
                
                if (submarine.getOrientation() == 'h' &&
                        submarine.getYcoord() == y) {
                    for (int i = 0; i < submarineArray.length; i++) {
                        if (submarineArray[i] == x) {
                            Cell c = new Cell(x, y, this, true);
                            row.getChildren().add(c);
                            coordNotFound = false;
                        }
                    }
                }
                else if(submarine.getOrientation() == 'v' &&
                        submarine.getXcoord() == x) {
                    for (int j = 0; j < submarineArray.length; j++) {
                        if (submarineArray[j] == y) {
                            Cell c = new Cell(x, y, this, true);
                            row.getChildren().add(c);
                            coordNotFound = false;
                        }
                    }
                }
                
                if (destroyer.getOrientation() == 'h' &&
                        destroyer.getYcoord() == y) {
                    for (int i = 0; i < destroyerArray.length; i++) {
                        if (destroyerArray[i] == x) {
                            Cell c = new Cell(x, y, this, true);
                            row.getChildren().add(c);
                            coordNotFound = false;
                        }
                    }
                }
                else if(destroyer.getOrientation() == 'v' &&
                        destroyer.getXcoord() == x) {
                    for (int j = 0; j < destroyerArray.length; j++) {
                        if (destroyerArray[j] == y) {
                            Cell c = new Cell(x, y, this, true);
                            row.getChildren().add(c);
                            coordNotFound = false;
                        }
                    }
                }
                /*if the coordinate is not found within any array, it colors it
                as usual -EM
                */
                if (coordNotFound) {
                    Cell c = new Cell(x, y, this);
                    row.getChildren().add(c);
                }
            }
            rows.getChildren().add(row);
        }
        getChildren().add(rows);
    }
}