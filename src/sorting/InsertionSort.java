/*
The task is to complete the insert() function which is used to implement Insertion Sort.
https://practice.geeksforgeeks.org/problems/insertion-sort/0?category[]=Algorithms&page=1&query=category[]Algorithmspage1&utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=insertion-sort

1. Select an element in each iteration from the unsorted array(using a loop).
2. Place it in its corresponding position in the sorted part and shift the remaining elements accordingly (using an inner loop and swapping).
3. The “inner while loop” shifts the elements using swapping.

TC: O(n2)
SC: O(1)
 */

package sorting;

public class InsertionSort {

    public static void insertionSort(int[] a, int n)
    {
        //code here
        for (int i = 1; i < n; i++){
            int temp = a[i];
            int j = i-1;
            while (j >= 0 && a[j] > temp){
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = temp;
        }
    }

    static void printArray(int[] arr, int size){
        for (int i = 0; i < size; i++){
            System.out.println(arr[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {4, 1, 3, 9, 7};
        int size = arr.length;
        printArray(arr, size);
        insertionSort(arr, size);
        printArray(arr, size);
    }
}
