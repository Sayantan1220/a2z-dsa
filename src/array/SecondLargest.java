/*
Second Largest
https://practice.geeksforgeeks.org/problems/second-largest3735/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=second-largest

TC: O(n)
SC: O(1)
 */

package array;

public class SecondLargest {

    static int print2largest(int[] arr, int n) {
        // code here
        int max = 0;
        int secondMax = 0;
        for (int i = 0; i < n; i++){
            if (arr[i] > max){
                max = arr[i];
            }
        }
        for (int i = 0; i < n; i++){
            if (arr[i] < max && arr[i] > secondMax){
                secondMax = arr[i];
            }
        }
        return secondMax;
    }

    public static void main(String[] args) {
        int[] arr = {12, 35, 1, 10, 34, 1};
        int size = arr.length;
        int result = print2largest(arr, size);
        System.out.println(result);
    }
}
