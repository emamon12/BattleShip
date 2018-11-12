package riperonibattleroni;

import javafx.scene.Parent;

public class Ship extends Parent {
    private int xCoord;
    private int yCoord;
    
    private int length;
    private char orientation;
 
    private int health;

    public Ship(int xCoord, int yCoord, int length, boolean vertical,
            char orientation) {
        
        this.length = length;
        this.orientation = orientation;
        this.health = length;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
      
    }
    
    public void setLength(int length){
        this.length = length;
    }
    
    public void setOrientation(char orientation){
        this.orientation = orientation;
    }
    
    public void setHealth(int health){
        this.health = health;
    }
    
    public void setXcoord(int xCoord){
        this.xCoord = xCoord;
    }
    
    public void setYcoord(int yCoord){
        this.yCoord = yCoord;
    }
    
    public int getLength(){
        return this.length;
    }
    
    public char getOrientation(){
        return this.orientation;
    }
    
    public int getHealth(){
        return this.health;
    }
    
    public int getXcoord(){
        return this.xCoord;
    }
    
    public int getYcoord(){
        return this.yCoord;
    }
    
    public void hit() {
        health--;
    }

    public boolean isAlive() {
        return health > 0;
    }
}

  

