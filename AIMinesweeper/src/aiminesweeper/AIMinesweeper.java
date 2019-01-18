package aiminesweeper;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

/**
 * This application is dedicated for the game Minesweeper. In extension to
 * recreating the game, An Artificial Intelligence will be developed to learn
 * and complete the game in any difficulty. 
 * 
 * @author Tristan Borja & Vivian Xu
 * @version 0.4
 */

public class AIMinesweeper {
	
	public static void main(String[] args) {
		AIMinesweeper game = new AIMinesweeper();
		System.out.print(game.getGrid().toString());
	}
	
	// FIELD VARIABLES
	public final static int WIDTH = 15;
	public final static int HEIGHT = 15;
	
	private JFrame frame;
	private JLabel emptyLabel;
	private Grid grid;
	private JLabel[][] gameGrid;
	
	// CONSTRUCTOR
	public AIMinesweeper() {
		
		this.frame = new JFrame("AI Minesweeper");
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		initiateGame();
		
		this.frame.pack();
		this.frame.setLocationRelativeTo(null);
		this.frame.setVisible(true);
	}
	
	// ACCESSORS
	public Grid getGrid() { return this.grid; }
	// UTILITIES
	public void initiateGame() {
		
		grid = new Grid(WIDTH, HEIGHT, 22);
		
		// initiate grid panel
		JPanel gamePanel = new JPanel();
		gamePanel.setLayout(new GridLayout(HEIGHT, WIDTH));
		frame.getContentPane().add(gamePanel);
		gameGrid = new JLabel[HEIGHT][WIDTH];
		
		// populate panel with JLabels, including square string representation
		for (int i = 0; i < HEIGHT; i++){
	        for (int j = 0; j < WIDTH; j++){
	            gameGrid[i][j] = new JLabel();
	            gameGrid[i][j].setPreferredSize(new Dimension(25,25));
	            gameGrid[i][j].setText(grid.getSquareString(j, i));
	            gameGrid[i][j].setBorder(new LineBorder(Color.BLACK));
	            gameGrid[i][j].setOpaque(true);
	            gamePanel.add(gameGrid[i][j]);
	        }
	    }
	}
}
