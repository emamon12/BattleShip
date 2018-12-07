package battleship;

/**
 * @see Launch
 * @since version 0.3.1
 * @author Elijah Joshua Mamon
 *
 * counts how many turns have passed.
 */
public class TurnCounter {

    private int turn;

    public TurnCounter(int turn) {
        this.turn = turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public int getTurn() {
        return this.turn;
    }
}
