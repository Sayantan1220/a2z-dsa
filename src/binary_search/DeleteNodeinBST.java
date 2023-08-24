/*
Given a root node reference of a BST and a key, delete the node with the given key in the BST.
Return the root node reference (possibly updated) of the BST.
Basically, the deletion can be divided into two stages:
Search for a node to remove.
If the node is found, delete the node.
https://leetcode.com/problems/delete-node-in-a-bst/description/

Approach
If the root is null, it means the tree is empty, so we return null as there is nothing to delete.
If the key we want to delete is less than the root's value, we recursively call the deleteNode function on the left subtree.
This ensures that we traverse the left side of the tree to find the node with the key to be deleted.
If the key is greater than the root's value, we recursively call the deleteNode function on the right subtree.
This ensures that we traverse the right side of the tree to find the node with the key to be deleted.
If the key is equal to the root's value, we have found the node to be deleted. We handle three cases:
If the node has no left child, we return its right child, effectively replacing the node with its right child.
If the node has no right child, we return its left child, effectively replacing the node with its left child.
If the node has both left and right children, we find the minimum value in its right subtree
(the leftmost node in the right subtree) and replace the value of the current node with that minimum value.
Then, we recursively delete that minimum node from the right subtree.
Finally, we return the root of the modified tree.

TC : O(logN)
SC : O(logN)
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
