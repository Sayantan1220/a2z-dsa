/*
Union of two arrays can be defined as the common and distinct elements in the two arrays.
Given two sorted arrays of size n and m respectively, find their union.
https://practice.geeksforgeeks.org/problems/union-of-two-sorted-arrays-1587115621/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=union-of-two-sorted-arrays

TC: O(n+m)
SC: O(n+m)
 */

package Array;

import java.util.*;

public class UnionArrays {

    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m)
    {
        // add your code here
        HashSet<Integer> resultHash = new HashSet<>();

        for (int i = 0; i < n; i++){
            resultHash.add(arr1[i]);
        }
        for (int i = 0; i < m; i++){
            resultHash.add(arr2[i]);
        }

        ArrayList<Integer> result = new ArrayList<>(resultHash);
        Collections.sort(result);
        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 2, 3, 4, 5};
        int[] arr2 = {1, 1, 2, 3, 4};
        ArrayList<Integer> result = findUnion(arr1, arr2, arr1.length, arr2.length);
        System.out.println(result);
    }
}
