/*
There is an undirected graph with n nodes, where each node is numbered between 0 and n - 1.
You are given a 2D array graph, where graph[u] is an array of nodes that node u is adjacent to. More formally,
for each v in graph[u], there is an undirected edge between node u and node v. The graph has the following properties:
There are no self-edges (graph[u] does not contain u).
There are no parallel edges (graph[u] does not contain duplicate values).
If v is in graph[u], then u is in graph[v] (the graph is undirected).
The graph may not be connected, meaning there may be two nodes u and v such that there is no path between them.
A graph is bipartite if the nodes can be partitioned into two independent sets A and B such that every edge in
the graph connects a node in set A and a node in set B.
Return true if and only if it is bipartite.

https://leetcode.com/problems/is-graph-bipartite/description/
 */
package graph;

import java.util.ArrayList;
import java.util.HashMap;

public class GraphBipartite {
    int[] colors;
    public boolean isBipartite(int[][] graph) {
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
        colors = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            adj.putIfAbsent(i, new ArrayList<>());
            for(int j=0;j<graph[i].length;j++){
                adj.get(i).add(graph[i][j]);
            }
        }

        for (int i = 0; i < colors.length; i++) {
            if(colors[i]==0 && adj.get(i)==null) {
                colors[i]=1;
            }
            else if(colors[i]==0 && adj.get(i)!=null) {
                if(!bfs(adj, i)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean bfs(HashMap<Integer, ArrayList<Integer>> adj, int node) {
        ArrayList<Integer> que = new ArrayList<>();
        que.add(node);
        colors[node] = 1;
        int c =0;
        while(!que.isEmpty()) {
            for(int i=0;i<adj.get(que.get(0)).size();i++) {
                if(colors[adj.get(que.get(0)).get(i)]==0) {
                    if(colors[que.get(0)]==1) {
                        colors[adj.get(que.get(0)).get(i)] = 2;
                        que.add(adj.get(que.get(0)).get(i));
                    }
                    else if(colors[que.get(0)]==2) {
                        colors[adj.get(que.get(0)).get(i)] = 1;
                        que.add(adj.get(que.get(0)).get(i));
                    }
                }
                else {
                    if(colors[que.get(0)]==colors[adj.get(que.get(0)).get(i)]) {
                        return false;
                    }

                }
            }
            que.remove(0);
        }
        return true	;
    }
}
