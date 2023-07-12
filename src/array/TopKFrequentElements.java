/*
Given an integer array nums and an integer k, return the k most frequent elements.
You may return the answer in any order.
https://leetcode.com/problems/top-k-frequent-elements/description/


Intuition
The intuition behind the solution is to count the frequency of each element using a HashMap
and then use a min heap (PriorityQueue) to keep track of the k most frequent elements.
The min heap ensures that the elements with the lowest frequency are removed when the size exceeds k,
resulting in the k most frequent elements being retained.

Approach
Counting the frequency of each element using a HashMap:
This step has a time complexity of O(n), where n is the number of elements in the input array.
Maintaining a min heap of size k: This step involves iterating over the frequency map
and adding elements to the min heap. If the size of the min heap exceeds k,
the element with the lowest frequency is removed. This step has a time complexity of O(n log k).

Complexity
Time complexity:
Time complexity of the solution is O(n log k) where n is the number of elements in the input array.
Space complexity:
The solution uses additional space to store the frequency map, which requires O(n) space.
Additionally, the min heap has a maximum size of k, resulting in O(k) space. Thus, the total space complexity is O(n + k).
 */
package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    public static int[] topKFrequent(int[] nums, int k) {
        // Count the frequency of each element
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Create a min heap (PriorityQueue) to store the k most frequent elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> frequencyMap.get(a) - frequencyMap.get(b));
        for (int num : frequencyMap.keySet()) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // Build the result array
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = minHeap.poll();
        }

        return result;
    }

    public static void main(String[] args) {
        int[] bills = {1,1,1,2,2,3};
        int[] result = topKFrequent(bills, 2);
        System.out.println(Arrays.stream(result));
    }
}
