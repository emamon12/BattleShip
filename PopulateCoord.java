/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

/**
 *
 * @author ElijahJoshua
 */
public class PopulateCoord {
   
    public static void populateCoord(int[] shipArray, int xCoord, int yCoord,
            char orientation){
        //populates the arrays of coordinates. Increments positively from the
        //initial.
        for (int i = 0; i < shipArray.length; i++) {
            if (orientation == 'h') {
                shipArray[i] = xCoord;
                xCoord++;
            }
            else{
                shipArray[i] = yCoord;
                yCoord++;
            }
        }
    }
}
