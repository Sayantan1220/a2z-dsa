/*
Assume you are an awesome parent and want to give your children some cookies.
But, you should give each child at most one cookie.
Each child i has a greed factor g[i], which is the minimum size of a cookie that the child will be content with;
and each cookie j has a size s[j]. If s[j] >= g[i], we can assign the cookie j to the child i, and the child i will be content.
Your goal is to maximize the number of your content children and output the maximum number.
https://leetcode.com/problems/assign-cookies/description/

Approach
Greedy Algorithm:
Sort the greed factors of children and the sizes of cookies in non-decreasing order.
Initialize a variable contentChildren to 0 to keep track of the number of children that can be content with a cookie.
Use two pointers i and j to point to the current child's greed factor and the current cookie size, respectively.
Iterate over the two sorted arrays, and for each cookie size, check if it can satisfy the current child's greed factor. If so, assign the cookie to the child, increment contentChildren and move on to the next child and cookie. If not, move on to the next cookie.
Return contentChildren.

Complexity:
Time Complexity:
Both approaches involve sorting the arrays, which takes O(n log n) time.
Then we iterate over the arrays, which takes O(n) time.
Using a priority_queue adds an additional O(log n) time per insertion and removal,
so the max heap approach has a slightly higher time complexity. Therefore, the time complexity of both approaches is O(n log n).

Space Complexity:
Both approaches use O(1) extra space for the pointers and variables.
The max heap approach uses O(n) extra space for the priority_queue.
Therefore the space complexity of the greedy algorithm is O(1) and the space complexity of the max heap algorithm is O(n).
 */

package array;

import java.util.Arrays;

public class AssignCookies {
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g); // sort the children's greed factors in non-decreasing order
        Arrays.sort(s); // sort the cookie sizes in non-decreasing order
        int contentChildren = 0;
        int i = 0; // pointer to the current child's greed factor
        int j = 0; // pointer to the current cookie size
        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) { // if the current cookie can satisfy the current child's greed factor
                contentChildren++;
                i++;
            }
            j++;
        }
        return contentChildren;
    }

    public static void main(String[] args) {
        int[] g = {1,2};
        int[] s = {1,2,3};
        int result = findContentChildren(g,s);
        System.out.println(result);
    }
}
