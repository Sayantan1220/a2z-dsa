/*
Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree
and postorder is the postorder traversal of the same tree, construct and return the binary tree.
https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/

Intuition
Basic idea of a binary tree is to have a root, left node and right node.
Inorder traversal represents the array in which all thel elements of the left subtree are towards left side of the root
and right subtree towards the right side of the root
Postfix traversal always has the root element of the subtree towards the end. That means all the elements
towards the right can either be nodes at same level or at parent levels.

Approach
Calculation of the split point
Since we know that root element is always the last in postfix, we can get the position of the root from inorder accordingly.
This will act as the split point of the sub tree

Calculate the left and right sub tree
We have already established the condition that elements on the left side of the inorder are left sub tre
and right side as right sub tree.
How do we determine the sub array from postfix?
2.1. As we know postfix is represented as left-right-root that means number of elements in the left section will be
same as the number of elements in towards the left sub array of the root in inorder.
2.2. Similarly remaining element in the sub array except the last one represents the right sub array
Repeat the process recursively which each sub-tree/sub-array

Optimisations
To increase the speed of index search from inorder traversal, indexes for the elements can be cached in a map.

TC:O(n)
SC:O(n)
 */

package binary_tree;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeInorderPostorderTraversal {

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

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        final var length = postorder.length;
        final var map = new HashMap<Integer, Integer>();
        for(int i=0; i<length; i++) {
            map.put(inorder[i], i);
        }

        return tree(map, postorder, 0, length-1, 0, length-1);
    }

    /**
     * @param il inorder low
     * @param im inorder max
     * @param pl postfix low
     * @param pm postfix max
     */
    private TreeNode tree(Map<Integer, Integer> inorder, int[] postorder, int il, int im, int pl, int pm) {
        if(pm < pl) {
            return null;
        }

        final var root = new TreeNode(postorder[pm]);

        if(pl < pm) {
            final var index = inorder.getOrDefault(root.val, -1);
            final var left = index-1-il;
            root.left = tree(inorder, postorder, il, index-1, pl, pl+left);
            root.right = tree(inorder, postorder, index+1, im, pl+left+1, pm-1);
        }
        return root;
    }
}
