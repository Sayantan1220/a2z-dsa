/*

Intuition
The goal is to find the shortest clear path from the top-left cell to the bottom-right cell in the binary matrix.
A clear path consists of cells with a value of 0, and adjacent cells are considered 8-directionally connected.
The BFS algorithm is used to explore cells in a breadth-first manner, starting from the top-left cell and moving towards the bottom-right cell.
Approach
The algorithm starts by checking if the top-left and bottom-right cells are obstacles (1). If either of them is an obstacle, there is no clear path, and -1 is returned.
A directions array is defined to represent the 8 possible directions to explore neighboring cells.
A queue is initialized, and the top-left cell is added to the queue as the starting point.
The grid is updated to mark the starting cell as visited.
A pathLength variable is initialized to track the length of the path.
The algorithm enters a while loop until the queue becomes empty:
The size of the current level is obtained from the queue.
For each cell in the current level:
If the cell is the bottom-right cell, the pathLength is returned as the shortest clear path.
For each direction in the directions array:
The neighboring cell coordinates are calculated based on the current cell and the direction.
If the neighboring cell is within the grid boundaries, has a value of 0, and hasn't been visited:
The neighboring cell is added to the queue.
The neighboring cell is marked as visited in the grid.
The pathLength is incremented to move to the next level.
Complexity
Time complexity:
The time complexity of the BFS algorithm is O(V + E), where V is the number of vertices (cells) and E is the number of edges (adjacent connections). In this case, V represents the number of cells in the grid, which is n^2, and E is proportional to V, as each cell has at most 8 neighbors in the 8-directional connectivity. Therefore, the time complexity is O(n^2).

Space complexity:
The space complexity is determined by the queue and the grid. The queue can store at most n^2 cells in the worst case, resulting in O(n^2) space. The grid uses O(n^2) space as well to represent the visited status of each cell. Hence, the overall space complexity is O(n^2).
 */

package graph;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathBinaryMatrix {

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1; // There is no clear path from the start to the end
        }

        int[][] directions = {
                {-1, -1}, {-1, 0}, {-1, 1},
                {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}
        };

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0}); // Start from the top-left cell
        grid[0][0] = 1; // Mark the starting cell as visited

        int pathLength = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                int row = cell[0];
                int col = cell[1];

                if (row == n - 1 && col == n - 1) {
                    return pathLength; // Reached the bottom-right cell, return the path length
                }

                for (int[] direction : directions) {
                    int newRow = row + direction[0];
                    int newCol = col + direction[1];

                    if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && grid[newRow][newCol] == 0) {
                        queue.offer(new int[]{newRow, newCol});
                        grid[newRow][newCol] = 1; // Mark the cell as visited
                    }
                }
            }

            pathLength++;
        }

        return -1; // There is no clear path from the start to the end
    }
}
