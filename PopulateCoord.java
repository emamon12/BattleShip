package battleship;

public class PopulateCoord {

    /**
     *
     * @param shipArray
     * @param xCoord
     * @param yCoord
     * @param orientation
     * @see Launch
     * @since version 0.1.3
     * @author Elijah Joshua Mamon
     *
     * Populates a coordinate array with given parameters. It increments
     * positively from the initial.
     */
    public static void populateCoord(int[] shipArray, int xCoord, int yCoord,
            char orientation) {

        for (int i = 0; i < shipArray.length; i++) {
            if (orientation == 'h') {
                shipArray[i] = xCoord;
                xCoord++;
            } else {
                shipArray[i] = yCoord;
                yCoord++;
            }
        }
    }
}
