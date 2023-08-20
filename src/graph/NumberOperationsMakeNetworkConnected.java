/*
There are n computers numbered from 0 to n - 1 connected by ethernet cables connections
forming a network where connections[i] = [ai, bi] represents a connection between computers ai and bi.
Any computer can reach any other computer directly or indirectly through the network.
You are given an initial computer network connections. You can extract certain cables between two directly
connected computers, and place them between any pair of disconnected computers to make them directly connected.
Return the minimum number of times you need to do this in order to make all the computers connected.
If it is not possible, return -1.
https://leetcode.com/problems/number-of-operations-to-make-network-connected/description/
 */

package graph;

public class NumberOperationsMakeNetworkConnected {
    public int makeConnected(int n, int[][] roads) {
        if(roads.length<n-1)
            return -1;
        int[] parent =  new int[n];
        for(int i=0; i<n; i++){
            parent[i]=i;
        }
        for(int[] i: roads){
            union(i[0], i[1], parent);
        }
        int res=0;
        for(int i=0; i<n; i++){
            if(parent[i]==i)
                res++;
        }
        return res-1;
    }

    private void union(int i, int j, int[] parent) {
        if(find(i, parent)!=find(j, parent)){
            parent[parent[j]] = parent[i];
        }
    }

    private int find(int i, int[] parent) {
        if(parent[i]!=i)
            parent[i] = find(parent[i], parent);
        return parent[i];
    }
}
