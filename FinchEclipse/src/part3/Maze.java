package part3;

import finchRobot.Finch;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;


public class Maze {
	private static final int ROAD = 0;
    private static final int WALL = 1;
    private static final int START = 2;
    private static final int EXIT = 3;
    private static final int PATH = 4;
    private Finch finch;
    private int[][] maze;
    private Coordinate start;
    private Coordinate end;

    public Maze(File maze, Finch finch)  {
        // TO DO
    }

    private void initializeMaze(String text) {
        // TO  DO
    }

    public int getHeight() {
    	// TO DO
        return 0;
    }

    public int getWidth() {
    	// TO DO
        return 0;
    }

    public Coordinate getEntry() {
    	// TO DO
        return null;
    }

    public Coordinate getExit() {
    	// TO DO
        return null;
    }

    public boolean isExit(int x, int y) {
    	// TO DO
        return true;
    }

    public boolean isStart(int x, int y) {
    	// TO DO
        return true;
    }

    public boolean isWall(int row, int col) {
    	// TO DO
        return true;
    }

    public void insertPath(List<Coordinate> path) {
        // TO DO
    }

    public String toString() {
       // TO DO
        return null;
    	
    }
    
    private List<FinchMove> finchPath() {
    	// TO DO
    	return null;
    }
    
    public void executeFinchPath() {
    	// TO DO
    }

}
