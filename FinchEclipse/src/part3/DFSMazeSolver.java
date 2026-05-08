package part3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DFSMazeSolver {                   
	private static final int[][] DIRECTIONS = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	private boolean[][] visited;
	private Maze maze;
   
	public DFSMazeSolver(Maze maze) {
		this.maze = maze;
		visited = new boolean[maze.getHeight()][maze.getWidth()];
	}
    public List<Coordinate> solve() {
        List<Coordinate> path = new ArrayList<>();
        if (explore(maze, maze.getEntry().getX(),maze.getEntry().getY(),path)) {
            return path;
        }
        return Collections.emptyList();
    }

    private boolean explore(Maze maze, int row, int col, List<Coordinate> path) {
        if (!isValidLocation(row, col) || maze.isWall(row, col) || isExplored(row, col)) {
            return false;
        }

        path.add(new Coordinate(row, col));
        setVisited(row, col, true);

        if (maze.isExit(row, col)) {
            return true;
        }

        for (int[] direction : DIRECTIONS) {
            Coordinate coordinate = getNextCoordinate(row, col, direction[0], direction[1]);
            if (explore(maze, coordinate.getX(), coordinate.getY(), path)) {
                return true;
            }
        }

        path.remove(path.size() - 1);
        return false;
    }

    private Coordinate getNextCoordinate(int row, int col, int i, int j) {
        return new Coordinate(row + i, col + j);
    }
    
    private void setVisited(int row, int col, boolean value) {
        visited[row][col] = value;
    }

    private boolean isValidLocation(int row, int col) {
       if (row < 0 || row >= maze.getHeight() || col < 0 || col >= maze.getWidth()) {
            return false;
        }
        return true;
    }
    
    public boolean isExplored(int row, int col) {
        return visited[row][col];
    }
	
}
