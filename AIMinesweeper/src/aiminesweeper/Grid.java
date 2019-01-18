package aiminesweeper;

import java.util.Random;

public class Grid {
	
	// FIELD VARIABLES
	private Square[][] gridSquares;
	private int width, height;
	private int totalBombs;
	// TODO: include a field variable for difficulty
	
	// CONSTRUCTORS
	public Grid(int width, int height, int totalBombs) {
		this.gridSquares = new Square[width][height];
		this.width = width;
		this.height = height;
		this.totalBombs = totalBombs;
		
		this.populateGrid();
	}

	// ACCESSORS
	public String getSquareString(int x, int y) { 
		return gridSquares[x][y].getStringRep(); 
	}
	
	// UTILITIES
	
	public void populateGrid() {
		
		Square adjSquare = null;
		
		// randomly position the bombs
		for(int i = 1; i <= totalBombs; i++) {
			Random randX = new Random();
		    Random randY = new Random();  
		    int x = randX.nextInt(width-1);
		    int y = randY.nextInt(height-1);
		    
//		    System.out.print("x: (" + x + ", " + y + "). ");
		    
		    // a bomb already exists at this location
		    if (gridSquares[x][y] != null && 
		    		gridSquares[x][y].getStringRep().equals("x")) {
		    	i--;
		    } else {
			    gridSquares[x][y] = new Square("x",x,y);
			    
			    // increment adjacent squares bomb count by one
			    for(int x1 = -1; x1 <= 1; x1++) {
			    	for(int y1 = -1; y1 <= 1; y1++) {
			    		
			    		int adjX = x+x1;
			    		int adjY = y+y1;
			    		
			    		if (adjX >= 0 && adjX < width && adjY >=0 && adjY < height) {
			    			adjSquare = gridSquares[adjX][adjY];
			    		  
				    		// adjacent squares are empty
				    		if(adjSquare == null) {
				    			gridSquares[adjX][adjY] = new Square(adjX, adjY);
				    			gridSquares[adjX][adjY].addAdjBomb();
				    			
			    			// adjacent squares are not empty and are not bombs
				    		} else if(!adjSquare.getStringRep().equals("x")) {				    			
				    			gridSquares[adjX][adjY].addAdjBomb();
				    		}
			    		}
			    	}
			    }
		    }		
		      
		      
		}

		// fills the empty grid with the remaining squares
		for(int i = 0; i < width; i++) {
			for(int j =0; j < height; j++) {
				adjSquare = gridSquares[i][j];
				if(adjSquare == null) { gridSquares[i][j] = new Square(i, j); }
			}
		}
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		for(int j = 0; j < height; j++) {
			for(int i = 0; i < width; i++) {
				builder.append("|");
				builder.append(gridSquares[i][j].getStringRep() + " ");
			} builder.append("|\n");
		}
		
		return builder.toString();
	}
}
