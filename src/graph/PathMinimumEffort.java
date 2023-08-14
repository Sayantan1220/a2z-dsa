/*
You are a hiker preparing for an upcoming hike. You are given heights, a 2D array of size rows x columns,
where heights[row][col] represents the height of cell (row, col). You are situated in the top-left cell, (0, 0),
and you hope to travel to the bottom-right cell, (rows-1, columns-1) (i.e., 0-indexed).
You can move up, down, left, or right, and you wish to find a route that requires the minimum effort
A route's effort is the maximum absolute difference in heights between two consecutive cells of the route.
Return the minimum effort required to travel from the top-left cell to the bottom-right cell.
https://leetcode.com/problems/path-with-minimum-effort/description/

Approach:
Dijkstra's algorithm
Model as a graph problem where each cell represents a vertex and absolute difference between heights of neighbour cells
represents the edge cost. Find the shortest path from source vertex (first cell) to destination vertex (last cell)
using any shortest path algorithm like Dijkstra's, Bellman-Ford etc.
Note that definition of distance of a path here is not equal to sum of edge costs but instead equal to maximum edge cost.
Shortest path algorithms should, however, continue to work here because "max of edge costs" is a
monotonically non-decreasing function just like sum of edge costs.

Time complexity: O(m n log (m n))
Space complexity: O(m n)
 */

package graph;

import java.util.Arrays;
import java.util.PriorityQueue;

public class PathMinimumEffort {
    private static final int[][] dir = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        int[][] dist = new int[m][n];
        for(int i = 0; i < m; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);
        dist[0][0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.add(new int[] {0, 0, 0});
        while(!pq.isEmpty()) {
            int[] p = pq.poll();
            int i = p[0];
            int j = p[1];
            if(i == m - 1 && j == n - 1) break;
            for(int[] d: dir) {
                int x = i + d[0], y = j + d[1];
                if(x < 0 || x >= m || y < 0 || y >= n) continue;
                int alt = Math.max(p[2], Math.abs(heights[i][j] - heights[x][y]));
                if(alt < dist[x][y]) {
                    pq.add(new int[] {x, y, dist[x][y] = alt});
                }
            }
        }
        return dist[m - 1][n - 1];
    }
}
