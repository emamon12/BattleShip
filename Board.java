import java.util.ArrayList;
import java.util.List;

import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

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
}