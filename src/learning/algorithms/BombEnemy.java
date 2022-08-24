package learning.algorithms;

/**
 * Given an m x n matrix grid where each cell is either a wall 'W', an enemy 'E' or empty '0', return the maximum enemies you can kill using one bomb. You can only place the bomb in an empty cell.

The bomb kills all the enemies in the same row and column from the planted point until it hits the wall since it is too strong to be destroyed.

Example 1:
Input: grid = [["0","E","0","0"],["E","0","W","E"],["0","E","0","0"]]
Output: 3


Example 2:
Input: grid = [["W","W","W"],["0","0","0"],["E","E","E"]]
Output: 1
 */

public class BombEnemy {

    //     private static int maxCalc(char[][] grid, int row, int col) {
//         int maxHits = 0;
//         for (int p = col - 1; p >= 0; p--) {
//             if (grid[row][p] == 'W') {
//                 break;
//             } else if (grid[row][p] == 'E') {
//                 maxHits++;
//             }
//         }
        
//         for (int q = col + 1; q < grid[0].length; q++) {
//             if (grid[row][q] == 'W') {
//                 break;
//             } else if (grid[row][q] == 'E') {
//                 maxHits++;
//             }
//         }
        
//         for (int r = row - 1; r >= 0; r--) {
//             if (grid[r][col] == 'W') {
//                 break;
//             } else if (grid[r][col] == 'E') {
//                 maxHits++;
//             }
//         }
        
//         for (int s = row + 1; s < grid.length; s++) {
//             if (grid[s][col] == 'W') {
//                 break;
//             } else if (grid[s][col] == 'E') {
//                 maxHits++;
//             }
//         }
//         return maxHits;
//     }
    
//     public int maxKilledEnemies1(char[][] grid) {
//         int rowLen = grid.length;
//         int colLen = grid[0].length;
//         int maxEnemies = 0;
//         for (int i = 0; i < rowLen; i++) {
//             for (int j = 0; j < colLen; j++) {
//                 if (grid[i][j] == '0') {
//                     int maxHits = maxCalc(grid, i, j);
//                     maxEnemies = Math.max(maxEnemies, maxHits);
//                 }
//             }
//         }
//         return maxEnemies;
//     }
    
public static int maxKilledEnemies(char[][] grid) {
    int rowLen = grid.length;
    int colLen = grid[0].length;
    int maxEnemies = 0;
    int rowHits = 0;
    int[] colHits = new int[colLen];
    for (int i = 0; i < rowLen; i++) {
        for (int j = 0; j < colLen; j++) {
            
            if (j == 0 || grid[i][j-1] == 'W') {
                rowHits = 0;
                for (int c = j; c < colLen; c++) {
                    if (grid[i][c] == 'W') {
                        break;
                    }
                    if (grid[i][c] == 'E') {
                        rowHits++;
                    }
                }
            }
            
            if (i == 0 || grid[i-1][j] == 'W') {
                colHits[j] = 0;
                for (int r = i; r < rowLen; r++) {
                    if (grid[r][j] == 'W') {
                        break;
                    } if (grid[r][j] == 'E') {
                        colHits[j] += 1;
                    }
                }
            }
            if (grid[i][j] == '0') {
                maxEnemies = Math.max(maxEnemies, rowHits + colHits[j]);                    
            }
        }
    }
    return maxEnemies;
}

    public static void main(String[] args) {
        char[][] grid = {{'0','E','0','0'},{'E','0','W','E'},{'0','E','0','0'}};
        System.out.println("Max enemies: " + maxKilledEnemies(grid));
    }
}
