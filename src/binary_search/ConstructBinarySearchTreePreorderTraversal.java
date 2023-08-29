/*
Given an array of integers preorder, which represents the preorder traversal of a BST (i.e., binary search tree),
construct the tree and return its root.
It is guaranteed that there is always possible to find a binary search tree with the given requirements
for the given test cases.
A binary search tree is a binary tree where for every node, any descendant of Node.
left has a value strictly less than Node.val, and any descendant of Node.right has a value strictly greater than Node.val.
A preorder traversal of a binary tree displays the value of the node first, then traverses Node.left,
then traverses Node.right.
https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/description/

TC : O(N)
SC : O(N)
 */

package binary_search;

public class ConstructBinarySearchTreePreorderTraversal {
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
    public TreeNode bstFromPreorder(int[] preorder) {
        // call helper function with initial parameters
        return bstFromPreorder(preorder, Integer.MAX_VALUE, new int[]{0});
    }

    public TreeNode bstFromPreorder(int[] preorder, int bound, int[] i){
        // check if there are no more nodes to add or if current node value exceeds bound
        if(i[0] == preorder.length || preorder[i[0]] > bound){
            return null;
        }
        // create new TreeNode with current node value
        TreeNode root = new TreeNode(preorder[i[0]++]);
        // recursively call helper for left and right subtrees
        // left subtree bound: current node value
        root.left = bstFromPreorder(preorder, root.val, i);
        // right subtree bound: parent node bound
        root.right = bstFromPreorder(preorder, bound, i);

        return root;
    }
}
