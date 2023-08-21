/*
On a 2D plane, we place n stones at some integer coordinate points. Each coordinate point may have at most one stone.
A stone can be removed if it shares either the same row or the same column as another stone that has not been removed.
Given an array stones of length n where stones[i] = [xi, yi] represents the location of the ith stone,
return the largest possible number of stones that can be removed.
https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/description/
 */

package graph;

import java.util.HashMap;
import java.util.Map;

public class MostStonesRemovedSameRowColumn {
    public int removeStones(int[][] stones) {
        if (stones == null || stones.length <= 1) {
            return 0;
        }

        int n = stones.length;
        UnionFind uf = new UnionFind();
        for (int[] edge : stones) {
            uf.union(edge[0] + 10001, edge[1]);
        }

        return n - uf.getCount();
    }

    class UnionFind {
        Map<Integer, Integer> parents;
        int count;

        public UnionFind() {
            parents = new HashMap<>();
            count = 0;
        }

        public int getCount() {
            return count;
        }

        public int find(int x) {
            if (!parents.containsKey(x)) {
                parents.put(x, x);
                count++;
            }

            if (x != parents.get(x)) {
                parents.put(x, find(parents.get(x)));
            }

            return parents.get(x);
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }
            parents.put(rootX, rootY);
            count--;
        }
    }
}
