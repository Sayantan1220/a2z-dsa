/*
Given the root of a binary tree, return its maximum depth.
A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
https://leetcode.com/problems/maximum-depth-of-binary-tree/description/

Approach:
To calculate it's height, we draw line and found out that it's height is 3
Now, by using recursion how can we find it. So, we know the root & it's child will be find by Hypothesis.
So we go deep inside to it's left, then to it's right & from there we will get the deepest root to child value of it's left
& right. We will compare both of them and that will be our Induction and which one has the greatest value will be added to 1,
as root will count as well.
Now in this the smallest valid Input could be if root is null & that;s our Base condition. Let's understand visually

TC:O(N)
SC:O(N)
 */

package binary_tree;

public class MaximumDepthBinaryTree {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }

    public int maxDepth(TreeNode root) {
        // Base Condition
        if(root == null) return 0;
        // Hypothesis
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        // Induction
        return Math.max(left, right) + 1;
    }
}
