package aiminesweeper;

import java.util.Random;

// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// GRID CLASS ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
public class Grid {

	public static void main(String[] args) {
		Grid grid = new Grid(20, 20, 10);
		System.out.println(grid.toString());
	}
	
	// FIELD VARIABLES ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	private Square[][] gridSquares;
	private int totalBombs;
	// TODO: include a field variable for difficulty
	
	// CONSTRUCTORS ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public Grid(int width, int height, int totalBombs) {
		this.gridSquares = new Square[width][height];
		this.totalBombs = totalBombs;
		
		// randomly position the bombs
		for(int i = 1; i <= totalBombs; i++) {
			Random randX = new Random();
		    Random randY = new Random();  
		    int x = randX.nextInt(width) + 0;
		    int y = randY.nextInt(height) + 0;
		      
		    gridSquares[x][y] = new Square("x",x,y);
		      
		    // increment adjacent squares bomb count by one
		    Square currentSquare = null;
		      
		    for(int x1 = -1; x1 <= 1; x1++) {
		    	for(int y1 = -1; y1 <= 1; y1++) {
		    		currentSquare = gridSquares[x+x1][y+y1];
		    		  
		    		// adjacent squares are empty
		    		if(currentSquare == null) {
		    			currentSquare = new Square("1", x+x1, y+y1);
		    		} else if(!currentSquare.getStringRep().equals("x")) {
		    			int bombCount = 
		    					Integer.parseInt(currentSquare.getStringRep());
		    			bombCount++;
		    			currentSquare.setStringRep("" + bombCount);
		    		}
		    	}
		    }		
		      
		      
		}

		// fills the empty grid with the remaining squares
		for(int i = 0; i < width; i++) {
			for(int j =0; j < height; j++) {
				Square currentSquare = null;
				if(currentSquare == null) { currentSquare = new Square(" ", i, j); }
			}
		}
	}

	// ACCESSORS ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	@Override
	public String toString() {
		return "Something";
	}
	// TODO: override the toString() method to represent the grid in string form
}
