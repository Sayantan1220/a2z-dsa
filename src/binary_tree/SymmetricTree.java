/*
Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 https://leetcode.com/problems/symmetric-tree/description/

Intuition
To check if a binary tree is symmetric, we need to compare its left subtree and right subtree.
To do this, we can traverse the tree recursively and compare the left and right subtrees at each level.
If they are symmetric, we continue the traversal. Otherwise, we can immediately return false.

Approach
We can define a recursive helper function that takes two nodes as input, one from the left subtree
and one from the right subtree. The helper function returns true if both nodes are null,
or if their values are equal and their subtrees are symmetric.

TC : O(n)
SC : O(h)
 */


package binary_tree;

public class SymmetricTree {
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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        return node1.val == node2.val && isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left);
    }
}
