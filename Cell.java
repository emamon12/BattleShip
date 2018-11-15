package battleship;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Cell extends Rectangle {
    public int x, y;
    public Ship ship = null;
    public boolean wasShot = false;

    private Board board;

    public Cell(int x, int y, Board board) {
        super(30, 30);
        this.x = x;
        this.y = y;
        this.board = board;
        setFill(Color.LIGHTGRAY);
        setStroke(Color.BLACK);
    }
    
    //currently unused may be used to color a cell a different color.
    //boolean f isnt used
    public Cell(int x, int y, Board board, boolean f) {
        super(30, 30);
        this.x = x;
        this.y = y;
        this.board = board;
        setFill(Color.GREEN);
        setStroke(Color.BLACK);
    }
}
	