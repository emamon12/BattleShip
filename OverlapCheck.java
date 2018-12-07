package battleship;

public class OverlapCheck {
    /**
     *
     * @param carrierArray
     * @param battleshipArray
     * @param cruiserArray
     * @param submarineArray
     * @param destroyerArray
     * @param carrier
     * @param battleship
     * @param cruiser
     * @param submarine
     * @param destroyer
     * @return if overlap returns true, else it is false.
     * @see Launch
     * @since version 0.3.1
     * @author Elijah Joshua Mamon
     * 
     * checks whether or not any coordinates overlap
     */
    public static boolean overlapCheck(int[] carrierArray, int[] battleshipArray, int[] cruiserArray,
            int[] submarineArray, int[] destroyerArray, 
            Ship carrier, Ship battleship, Ship cruiser, Ship submarine, 
            Ship destroyer){
        
        int[] shipCoordinates = new int[carrier.getLength() + battleship.getLength() + 
                cruiser.getLength() + submarine.getLength() + destroyer.getLength()];
        
        popShipArray(carrierArray, carrier, shipCoordinates, 0);
        popShipArray(battleshipArray, battleship, shipCoordinates, 
                carrier.getLength());
        popShipArray(cruiserArray, cruiser, shipCoordinates, 
                carrier.getLength() + battleship.getLength());
        popShipArray(submarineArray, submarine, shipCoordinates, 
                carrier.getLength() + battleship.getLength() +
                        cruiser.getLength());
        popShipArray(destroyerArray, destroyer, shipCoordinates, 
                carrier.getLength() + battleship.getLength() +
                        cruiser.getLength() + submarine.getLength());
        
        for (int i = 0; i < shipCoordinates.length; i++) {
            for (int j = i + 1; j < shipCoordinates.length; j++) {
                if (shipCoordinates[i]  == shipCoordinates[j]) {
                    return true;
                }
                else{
                    return false;
                }
            }
        }
        return false;
    }
    /**
     * @param shipArray
     * @param currShip
     * @param shipCoordinates
     * @param indexOffset
     * @see OverlapCheck
     * @since version 0.3.1
     * @author Elijah Joshua Mamon
     * 
     * populates a coordinate array
     */
    public static void popShipArray(int[] shipArray, Ship currShip, int[] shipCoordinates,
            int indexOffset){
        for (int j = 0; j < currShip.getLength(); j++) {
            if (currShip.getOrientation() == 'h') {
                shipCoordinates[j + indexOffset] = (currShip.getYcoord() * 10) + shipArray[j];
            }
            else{
                shipCoordinates[j + indexOffset] = (shipArray[j] * 10) + currShip.getXcoord();
            }
        }
    }
}
