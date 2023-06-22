/*
The median is the middle value in an ordered integer list.
If the size of the list is even, there is no middle value, and the median is the mean of the two middle values.
For example, for arr = [2,3,4], the median is 3.
For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
Implement the MedianFinder class:
MedianFinder() initializes the MedianFinder object.
void addNum(int num) adds the integer num from the data stream to the data structure.
double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.
https://leetcode.com/problems/find-median-from-data-stream/description/

Approach:
In addNum method,
keep adding the incoming elements and at the time of adding itself insert them in their correct place such that they are in ascending order. (See the code)

In the findMedian method,
Return the middle element if the size of the list is odd,
Else return the average of middle two elements.

TC:O(n^2)
SC:O(n)
 */


package array;

import java.util.ArrayList;
import java.util.List;

public class FindMedianDataStream {

    List<Integer> list;
    public FindMedianDataStream() {
        this.list = new ArrayList<>();
    }

    public void addNum(int num) {
        if(list.isEmpty()) list.add(0, num);
        else{
            int i=0;
            while(list.get(i) <= num && i<list.size()-1) i++;
            //*****The reason why I didn't traverse till the last index was to escape from IndexOutOfBounds Error*****
            if(list.get(i) <= num) list.add(i+1, num);
            else list.add(i, num);
        }
    }

    public double findMedian() {
        int n = list.size();
        if(n == 0) return 0;
        if(n%2 == 1) return list.get(n/2);
        return (double)(list.get(n/2) + list.get(n/2 - 1))/2;
    }

    public static void main(String[] args) {
        FindMedianDataStream obj = new FindMedianDataStream();
        obj.addNum(1);
        obj.addNum(2);
        System.out.println(obj.findMedian());
        obj.addNum(3);
        System.out.println(obj.findMedian());
    }
}
