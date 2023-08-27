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
