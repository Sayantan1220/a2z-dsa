/*
There is a directed graph of n nodes with each node labeled from 0 to n - 1. The graph is represented by a 0-indexed 2D integer array graph where graph[i]
is an integer array of nodes adjacent to node i, meaning there is an edge from node i to each node in graph[i].
A node is a terminal node if there are no outgoing edges. A node is a safe node
if every possible path starting from that node leads to a terminal node (or another safe node).
Return an array containing all the safe nodes of the graph. The answer should be sorted in ascending order.
https://leetcode.com/problems/find-eventual-safe-states/description/

Approach:

Start the eventualSafeNodes function.
Get the number of nodes in the graph by calculating n = len(graph).
Create a visited list of size n and initialize all elements to 0. This list will track the visitation status of each node,
where 0 represents unvisited, 1 represents visiting, and 2 represents a terminal node.
Create an empty result list to store the eventual safe nodes.
Define the isSafe function that takes a node as an argument and checks if it is safe.
If the visited[node] value is greater than 0, it means the node has been visited before.
Return visited[node] == 2 to check if it is a terminal node.
Set visited[node] to 1 to mark the node as visiting.
Iterate over the neighbors of the current node using the graph[node] list.
Recursively call isSafe on each neighbor node.
If isSafe(neighbor) returns False, it means the neighbor node is not safe. Return False to propagate the unsafe status.
Set visited[node] to 2 to mark the node as a terminal node since all its neighbors are safe.
Return True to indicate that the node is safe.
Iterate over all nodes from 0 to n-1.
If isSafe(i) returns True for the current node i, it means the node is safe.
Append the safe node i to the result list.
Return the result list containing all the eventual safe nodes.
This algorithm performs a depth-first search (DFS) starting from each node and checks
if all the paths lead to a terminal node or another safe node. It marks the nodes as visiting during the search
and marks them as terminal nodes once it is determined that they are safe. The nodes that are marked
as terminal are considered eventual safe nodes, and they are added to the result list, which is returned as the final output.

TC: O(n)
SC: O(n)
 */

package graph;

import java.util.ArrayList;
import java.util.List;

public class FindEventualSafeStates {

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] visited = new int[n]; // 0: unvisited, 1: visiting, 2: terminal
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (isSafe(graph, visited, i)) {
                result.add(i);
            }
        }
        return result;
    }

    private boolean isSafe(int[][] graph, int[] visited, int node) {
        if (visited[node] > 0) {
            return visited[node] == 2;
        }
        visited[node] = 1;
        for (int neighbor : graph[node]) {
            if (!isSafe(graph, visited, neighbor)) {
                return false;
            }
        }
        visited[node] = 2;
        return true;
    }
}
