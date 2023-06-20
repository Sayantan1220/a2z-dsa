/*
Given a characters array tasks, representing the tasks a CPU needs to do, where each letter represents a different task.
Tasks could be done in any order. Each task is done in one unit of time. For each unit of time, the CPU could complete either one task or just be idle.
However, there is a non-negative integer n that represents the cool down period between two same tasks (the same letter in the array),
that is that there must be at least n units of time between any two same tasks.
Return the least number of units of times that the CPU will take to finish all the given tasks.
https://leetcode.com/problems/task-scheduler/description/

Approach:
Create a frequency array freq to count the number of occurrences of each task.
Sort the freq array in ascending order.
Calculate the maximum frequency maxFreq of any task.
Calculate the number of idle slots idleSlots required by the most frequent task, which is equal to (maxFreq - 1) * n.
Iterate over the remaining tasks in descending order of frequency and subtract the minimum of maxFreq and the frequency of the task from idleSlots.
If idleSlots is still positive, add it to the length of the input task list tasks. Otherwise, return tasks.size().

Time complexity: The time complexity of the algorithm is O(26 log 26 + n), where 26 log 26 is the time complexity of sorting the frequency array,
and n is the length of the input task list.
Space complexity: The space complexity of the algorithm is O(26), which is the size of the frequency array.
 */

package array;

import java.util.Arrays;

public class TaskScheduler {
    public static int leastInterval(char[] tasks, int n) {
        // Create a frequency array to keep track of the count of each task
        int[] freq = new int[26];
        for (char task : tasks) {
            freq[task - 'A']++;
        }
        // Sort the frequency array in non-decreasing order
        Arrays.sort(freq);
        // Calculate the maximum frequency of any task
        int maxFreq = freq[25] - 1;
        // Calculate the number of idle slots that will be required
        int idleSlots = maxFreq * n;
        // Iterate over the frequency array from the second highest frequency to the lowest frequency
        for (int i = 24; i >= 0 && freq[i] > 0; i--) {
            // Subtract the minimum of the maximum frequency and the current frequency from the idle slots
            idleSlots -= Math.min(maxFreq, freq[i]);
        }
        // If there are any idle slots left, add them to the total number of tasks
        return idleSlots > 0 ? idleSlots + tasks.length : tasks.length;
    }

    public static void main(String[] args) {
        char[] arr = {'A','A','A','B','B','B'};
        int result = leastInterval(arr, 2);
        System.out.println(result);
    }
}
