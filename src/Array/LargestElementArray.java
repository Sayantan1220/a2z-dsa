/*
Given an array A[] of size n. The task is to find the largest element in it.
https://practice.geeksforgeeks.org/problems/largest-element-in-array4009/0?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=largest-element-in-array

TC: O(n)
SC: O(1)
 */

package Array;

public class LargestElementArray {

    public static int largestElement(int arr[], int n)
    {
        int max = 0;
        for (int i = 0; i < n; i++){
            if (arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {1, 8, 7, 56, 90};
        int size = arr.length;
        int result = largestElement(arr, size);
        System.out.println(result);
    }
}
