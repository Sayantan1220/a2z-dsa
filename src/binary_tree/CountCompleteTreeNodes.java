/*
Given the root of a complete binary tree, return the number of the nodes in the tree.
According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree,
and all nodes in the last level are as far left as possible.
It can have between 1 and 2h nodes inclusive at the last level h.
Design an algorithm that runs in less than O(n) time complexity.
https://leetcode.com/problems/count-complete-tree-nodes/description/

Intuition
Using resursion we can reach each of the node and add the nodes.
similar to finding the height of the tree (helped me atleast).

Approach
call the left nodes till it becomes null which will return 0.
now you reach to the node where left child is null.
check for the right child
if it is not null then repeat the recursive process.
else it is also null means we got the leaf node.
we use lh + rh + 1 so that lh and rh helps in returning the result of children to the parent
and adding 1 means adding the parent's count.

TC:O(n)
SC:O(n)
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
