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
    
    //currently unused looking to use for to change board states -EM
    public Board(int[] carrierArray, int[] battleshipArray, int[] cruiserArray,
            int[] submarineArray, int[] destroyerArray, int xCoord, int yCoord,
            char carrierOrientation, char battleshipOrentation,
            char cruiserOrientation, char submarineOrientation,
            char destroyerOrientation){
        
        this.enemy = enemy;
        
        for (int y = 0; y < 10; y++) {
            HBox row = new HBox();
            
            for (int x = 0; x < 10; x++) {
                
                if (carrierOrientation == 'h') {
                    for (int i = 0; i < carrierArray.length; i++) {
                        if (carrierArray[i] == y) {
                            Cell c = new Cell(x,y,this, true);
                        }
                    }
                }
                else if(carrierOrientation == 'v'){
                    for (int i = 0; i < carrierArray.length; i++) {
                        if (carrierArray[i] == x) {
                            Cell c = new Cell(x,y,this, true);
                        }
                    }
                }
                Cell c = new Cell(x, y, this);
                row.getChildren().add(c);
            }
            rows.getChildren().add(row);
        }
        
        /*for (int i = 0; i < shipArray.length; i++) {
            HBox row = new HBox();
            if (orientation == 'h') {
                Cell c = new Cell(shipArray[i], yCoord, this);
                row.getChildren().add(c);
            }
            else{
                Cell c = new Cell(xCoord, shipArray[i], this);
               row.getChildren().add(c);
            }
        }
        
        getChildren().add(rows);
    */}
}