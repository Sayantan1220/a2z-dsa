/*
There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.
You are giving candies to these children subjected to the following requirements:
Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
Return the minimum number of candies you need to have to distribute the candies to the children.
https://leetcode.com/problems/candy/description/

Approach
Check if the input array ratings is null or empty. If so, return 0, as there are no children to distribute candies to.
Initialize an array candies of the same length as ratings to store the candies assigned to each child.
Assign one candy to the first child.
Traverse the ratings from left to right and assign candies to each child based on the ratings of the previous child.
If the rating of the current child is higher than the previous child, assign one more candy than the previous child.
Otherwise, assign one candy.
Traverse the ratings from right to left and update the candies assigned to each child based on the ratings of the next child.
If the rating of the current child is higher than the next child, assign one more candy than the next child.
Take the maximum of the candies assigned in both passes for each child.
Return the sum of all candies assigned.
Complexity

Time complexity:
O(n), where n is the length of the input array ratings.
The algorithm iterates through the array twice, performing constant-time operations for each element.

Space complexity:
O(n), as the algorithm uses an additional array candies of the same length as ratings
to store the candies assigned to each child.
 */

package array;

public class Candy {
    public static int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0)
        {
            return 0;
        }
        int[] candies = new int[ratings.length];
        candies[0] = 1;
        //from let to right
        for (int i = 1; i < ratings.length; i++)
        {
            if (ratings[i] > ratings[i - 1])
            {
                candies[i] = candies[i - 1] + 1;
            }
            else
            {
                // if not ascending, assign 1
                candies[i] = 1;
            }
        }
        int result = candies[ratings.length - 1];
        //from right to left
        for (int i = ratings.length - 2; i >= 0; i--)
        {
            int cur = 1;
            if (ratings[i] > ratings[i + 1])
            {
                cur = candies[i + 1] + 1;
            }
            result += Math.max(cur, candies[i]);
            candies[i] = cur;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] bills = {1,0,2};
        int result = candy(bills);
        System.out.println(result);
    }
}
