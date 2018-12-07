package battleship;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Cell extends Rectangle {

    public int x, y;
    public Ship ship = null;
    public boolean wasShot = false;

    private Board board;

    /**
     * 
     * @param x
     * @param y
     * @param board
     * @since version 0.1.1
     * @author Brandon
     * 
     * default cell constructor.
     */
    public Cell(int x, int y, Board board) {
        super(30, 30);
        this.x = x;
        this.y = y;
        this.board = board;
        setFill(Color.LIGHTGRAY);
        setStroke(Color.BLACK);
    }

    /**
     *
     * @param x
     * @param y
     * @param board any board that is using this cell.
     * @param f just used to differentiate from the other constructor.
     * @see Board
     * @since version 0.2.2
     * @author Elijah Joshua Mamon
     * 
     * This cell method changes the cell to green instead when called.
     * 
     */
    public Cell(int x, int y, Board board, boolean f) {
        super(30, 30);
        this.x = x;
        this.y = y;
        this.board = board;
        setFill(Color.GREEN);
        setStroke(Color.BLACK);
    }
}
