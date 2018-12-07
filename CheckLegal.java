package battleship;

/**
 * @see Launch
 * @since version 0.2.5
 * @author Esmir Karabas
 *
 * checks whether or not the ships are within the bounds of the board.
 */
public class CheckLegal {

    public boolean isLegal(int[] shipArray, int xCoord, int yCoord,
            char orientation, int player) {
        if (orientation == 'h') {
            if (xCoord + shipArray.length > 10) {
                return false;
            }
        } else {
            if (yCoord + shipArray.length > 10) {
                return false;
            }
        }
        return true;
    }
}
