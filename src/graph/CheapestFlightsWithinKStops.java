/*
There are n cities connected by some number of flights. You are given an array flights where flights[i] =
[fromi, toi, pricei] indicates that there is a flight from city fromi to city toi with cost pricei.
You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops.
If there is no such route, return -1.
https://leetcode.com/problems/cheapest-flights-within-k-stops/description/

TC : O(V+E∗K)
SC : O(V+E∗K)
 */

package graph;

import java.util.*;

public class CheapestFlightsWithinKStops {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        if(src == dst) {
            return 0; // already at the destination
        }

        List<List<int[]>> graph = makeGraph(n, flights);

        // item: destination, price, stops
        Deque<int[]> queue = new ArrayDeque<>();
        // costs 0 to get to src and 0 stops
        queue.add(new int[]{src, 0, 0});
        int minPrice = Integer.MAX_VALUE;
        boolean found = false;
        int[] minPriceToReachNode = new int[n];
        Arrays.fill(minPriceToReachNode, Integer.MAX_VALUE);

        while(!queue.isEmpty()) {
            int[] item = queue.poll();
            int currentLocation = item[0];
            int currentCost = item[1];
            int currentStops = item[2];
            for(int[] node : graph.get(currentLocation)) {
                int destination = node[0];
                int price = node[1];

                // if this edge would not result in a lower price in getting
                // to destination, then there must already be a better path
                // which travels through destination. Therefore we can skip it
                // otherwise, update the min cost to reach destination.
                if(currentCost + price > minPriceToReachNode[destination]) {
                    continue;
                } else {
                    minPriceToReachNode[destination] = currentCost + price;
                }

                // if we found a way to dst, then we can check if we found a
                /// lower cost way of getting there. If we did,
                // than update the minPrice
                if(destination == dst && (currentCost + price < minPrice)) {
                        found = true;
                        minPrice = currentCost + price;
                }

                if(currentStops == k) {
                    // we cannot explore beyond this destination b/c
                    // we would exceed our max number of stops
                    continue;
                }

                // add this destination to the list to explore from
                // we need to increase the cost since we'll be traveling through this location
                // and we increment the stops since it introduces another stop
                queue.add(new int[]{destination, currentCost + price, currentStops + 1});
            }
        }
        return found ? minPrice : -1;
    }

    private List<List<int[]>> makeGraph(int n, int[][] flights) {
        List<List<int[]>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] flight : flights) {
            // from => {to, cost}
            graph.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }
        return graph;
    }
}
