/*
Given a root node reference of a BST and a key, delete the node with the given key in the BST.
Return the root node reference (possibly updated) of the BST.
Basically, the deletion can be divided into two stages:
Search for a node to remove.
If the node is found, delete the node.
https://leetcode.com/problems/delete-node-in-a-bst/description/
 */

package binary_search;

public class DeleteNodeinBST {

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

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return root;
        if(key < root.val)
            root.left = deleteNode(root.left, key);
        else if(key > root.val)
            root.right = deleteNode(root.right, key);
        else{
            if(root.left==null) return root.right;
            else if(root.right==null) return root.left;
            root.val = minVal(root.right);
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }

    public int minVal(TreeNode root){
        int min=root.val;
        while(root.left!=null){
            min=root.left.val;
            root=root.left;
        }return min;
    }
}
