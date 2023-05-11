/*
Given an array arr[] sorted in ascending order of size N and an integer K. Check if K is present in the array or not.
https://practice.geeksforgeeks.org/problems/who-will-win-1587115621/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=who-will-win

TC: O(logn)
SC: O(1)
 */


package Array;

public class BinarySearch {

    static int searchInSorted(int[] arr, int N, int K)
    {
        // Your code here
        int low = 0;
        int high = N - 1;
        while (low <= high){
            int mid = low + (high - low)/2;
            if (arr[mid] == K){
                return 1;
            }

            if (arr[mid] < K){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,6};
        int size = arr.length;
        int result = searchInSorted(arr, size, 6);
        System.out.println(result);
    }
}
