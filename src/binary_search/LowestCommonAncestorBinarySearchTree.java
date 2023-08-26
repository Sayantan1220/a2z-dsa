/*
Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.
According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as
the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/

Approach:
We know that in bst the two nodes p and q can lie on either sides of root or at same side of the root.
Therefore, the lowest common ancestor will be the node that splits both the nodes on either side of the bst or
the node which itself is either of p or q.

TC : O(N)
SC : O(1)
 */

package binary_search;

public class LowestCommonAncestorBinarySearchTree {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(root != null){
            if(root.val > p.val && root.val > q.val){
                root = root.left;
            } else if(root.val < p.val && root.val < q.val){
                root = root.right;
            } else{
                return root;
            }
        }
        return null;
    }
}
