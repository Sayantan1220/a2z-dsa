/*
Implement the BSTIterator class that represents an iterator over the in-order traversal of a binary search tree (BST):
BSTIterator(TreeNode root) Initializes an object of the BSTIterator class.
The root of the BST is given as part of the constructor. The pointer should be initialized
to a non-existent number smaller than any element in the BST.
boolean hasNext() Returns true if there exists a number in the traversal to the right of the pointer,
otherwise returns false.
int next() Moves the pointer to the right, then returns the number at the pointer.
Notice that by initializing the pointer to a non-existent smallest number,
the first call to next() will return the smallest element in the BST.
You may assume that next() calls will always be valid. That is, there will be at least a next number
in the in-order traversal when next() is called.
https://leetcode.com/problems/binary-search-tree-iterator/description/
 */

package binary_search;

import java.util.Stack;

public class BinarySearchTreeIterator {

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

    Stack<TreeNode> stack;
    public void BSTIterator(TreeNode root) {
        stack = new Stack<>();
        updateStack(root);                                      // update stack
    }

    public int next() {
        TreeNode toRemove = stack.pop();
        updateStack(toRemove.right);                             // before return node, first update stack further
        return toRemove.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    // -------------------
    public void updateStack(TreeNode node){
        while(node != null){
            stack.add(node);
            node = node.left;
        }
    }
}
