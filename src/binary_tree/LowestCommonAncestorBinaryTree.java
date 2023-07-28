/*
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
According to the definition of LCA on Wikipedia:
“The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants
(where we allow a node to be a descendant of itself).”
https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/


 */

package binary_tree;

public class LowestCommonAncestorBinaryTree {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
   }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode forLeft = lowestCommonAncestor(root.left,p,p);
        TreeNode forRight = lowestCommonAncestor(root.right,p,q);
        if(forLeft!= null && forRight!=null) return root;
        else if(forLeft!=null) return forLeft;
        else if(forRight!=null) return forRight;
        else return null;
    }
}
