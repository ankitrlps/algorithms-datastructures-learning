package learning.algorithms;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {

    public static int numIslands(char[][] grid) {
        // return usingBfs(grid);
        return usingDfs(grid);
    }
    
    private static int usingDfs(char[][] grid) {
        int islands = 0;
        int nr = grid.length;
        int nc = grid[0].length;
        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                if (grid[r][c] == '1') {
                    islands++;
                    dfs(grid, r, c);
                }
            }
        }
        return islands;
    }
    
    private static void dfs(char[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == '0') {
            return;
        }
        
        grid[row][col] = '0';
        dfs(grid, row-1, col);
        dfs(grid, row+1, col);
        dfs(grid, row, col+1);
        dfs(grid, row, col-1);
    }
    
    private static int usingBfs(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int nr = grid.length;
        int nc = grid[0].length;
        int islands = 0;
                
        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                if (grid[r][c] == '1') {
                    grid[r][c] = '0'; // marking as visited
                    islands++;
                    Queue<Integer> neighbors = new LinkedList<>();
                    neighbors.add(r * nc + c); // this calc will give a location of the current grid element which is used later to find its neighbors
                    while (!neighbors.isEmpty()) {
                        int gridLocation = neighbors.poll();
                        int row = gridLocation / nc;
                        int col = gridLocation % nc;
                        if (row-1 >= 0 && grid[row-1][col] == '1') {
                            neighbors.add((row-1) * nc + col);
                            grid[row-1][col] = '0';
                        }
                        if (row+1 < nr && grid[row+1][col] == '1') {
                            neighbors.add((row+1) * nc + col);
                            grid[row+1][col] = '0';
                        }
                        if (col-1 >= 0 && grid[row][col-1] == '1') {
                            neighbors.add((row) * nc + (col-1));
                            grid[row][col-1] = '0';
                        }
                        if (col+1 < nc && grid[row][col+1] == '1') {
                            neighbors.add((row) * nc + (col+1));
                            grid[row][col+1] = '0';
                        }
                    }
                }
            }
        }
        return islands;
    }

    public static void main(String[] args) {
        char[][] grid = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        System.out.println("Number of Islands found: " + numIslands(grid));
    }
    
}
