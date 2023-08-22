/*
You are given the root of a binary search tree (BST),
where the values of exactly two nodes of the tree were swapped by mistake.
Recover the tree without changing its structure.
https://leetcode.com/problems/recover-binary-search-tree/description/

Approach:
We will traverse the tree in inorder fashion and check whether previous node had value less than the root.
If yes, than note both of them.
After the traversal we will simply, swap both the nodes.

TC : O(n)
SC : O(n)
 */

package binary_search;

public class RecoverBinarySearchTree {

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

    private TreeNode prev = null , first = null , sec = null;
    public void recoverTree(TreeNode root) {
        helper(root);
        swap(first , sec);
    }

    private void swap (TreeNode a , TreeNode b){
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
    }

    private void helper (TreeNode root){
        if(root == null)
            return;

        helper(root.left);

        if(prev != null && prev.val > root.val){
            if(first == null)
                first = prev;
            sec = root;
        }
        prev = root;
        helper(root.right);
    }
}
