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
