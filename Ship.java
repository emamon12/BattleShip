package battleship;

import javafx.scene.Parent;

public class Ship extends Parent {

    private int xCoord;
    private int yCoord;

    private int length;
    private char orientation;

    private int health;

    /**
     *
     * @param xCoord
     * @param yCoord
     * @param length
     * @param orientation
     * @see Launch
     * @since version 0.1.2
     * @author Elijah Joshua Mamon
     *
     * constructor that initializes the ships.
     */
    public Ship(int xCoord, int yCoord, int length, char orientation) {

        this.length = length;
        this.orientation = orientation;
        this.health = length;
        this.xCoord = xCoord;
        this.yCoord = yCoord;

    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setOrientation(char orientation) {
        this.orientation = orientation;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setXcoord(int xCoord) {
        this.xCoord = xCoord;
    }

    public void setYcoord(int yCoord) {
        this.yCoord = yCoord;
    }

    public int getLength() {
        return this.length;
    }

    public char getOrientation() {
        return this.orientation;
    }

    public int getHealth() {
        return this.health;
    }

    public int getXcoord() {
        return this.xCoord;
    }

    public int getYcoord() {
        return this.yCoord;
    }

    /**
     *
     * @param shotX
     * @param shotY
     * @return boolean if hit
     * @since version 0.3.1
     * @author Ben Feldhake
     *
     *
     */
    public boolean isHit(int shotX, int shotY) {
        //System.out.println("\nOrientation: " + this.getOrientation() + " || xCoord: " + this.getXcoord() + " || yCoord: " + this.getYcoord() + " || length: " + this.getLength());
        if (this.getOrientation() == 'h') {
            if ((this.getXcoord() - shotX + this.getLength() > 0)
                    && (this.getXcoord() - shotX + this.getLength() <= this.getLength())
                    && this.getYcoord() == shotY) {
                hit();
                if (this.isAlive()) {
                    System.out.println("\nCoordinates (" + shotX + ", " + shotY + ") HIT!");
                }
                if (this.isAlive() == false) {
                    System.out.println("\nCoordinates (" + shotX + ", " + shotY + ") SINK!");
                }
                return true;
            } else {
                return false;
            }
        } else {
            if ((this.getYcoord() - shotY + this.getLength() > 0)
                    && (this.getYcoord() - shotY + this.getLength() <= this.getLength())
                    && this.getXcoord() == shotX) {
                hit();
                if (this.isAlive()) {
                    System.out.println("\nCoordinates (" + shotX + ", " + shotY + ") HIT!");
                }
                if (this.isAlive() == false) {
                    System.out.println("\nCoordinates (" + shotX + ", " + shotY + ") SINK!");
                }
                return true;
            } else {
                return false;
            }
        }

    }

    public void hit() {
        health--;
    }

    public boolean isAlive() {
        return health > 0;
    }
}
