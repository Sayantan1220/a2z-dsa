/*
Given the root of a complete binary tree, return the number of the nodes in the tree.
According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree,
and all nodes in the last level are as far left as possible.
It can have between 1 and 2h nodes inclusive at the last level h.
Design an algorithm that runs in less than O(n) time complexity.
https://leetcode.com/problems/count-complete-tree-nodes/description/
 */

package binary_tree;

public class CountCompleteTreeNodes {

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

    public int countNodes(TreeNode root) {
        if(root == null) return 0;

        return countAllNodes(root);
    }
    int countAllNodes(TreeNode root)
    {
        if(root == null) return 0;
        int lh =  countAllNodes(root.left);
        int rh =  countAllNodes(root.right);

        return lh + rh + 1;
    }
}
