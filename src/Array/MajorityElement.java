/*
Given an array nums of size n, return the majority element.
The majority element is the element that appears more than ⌊n / 2⌋ times.
You may assume that the majority element always exists in the array.
https://leetcode.com/problems/majority-element/description/

TC: O(n)
SC: O(1)
 */

package Array;

public class MajorityElement {
    public static int majorityElement(int[] nums) {
        int count=0;
        int me=0;

        //travese the array
        //make the first ele as the majority
        //if next is qual c++ || if not c--
        // after count bcom zero make the element as majority where count got zero
        for (int i=0;i<nums.length;i++){
            if(count==0){
                me=nums[i];
                count=1;
            }else if(nums[i]==me){
                count++;
            }else{
                count--;
            }
        }
        return me;
    }

    public static void main(String[] args) {
        int[] arr = {2,2,1,1,1,2,2};
        int result = majorityElement(arr);
        System.out.println(result);
    }
}
