/*
Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree
and inorder is the inorder traversal of the same tree, construct and return the binary tree.
https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/

Approach:
For this solution, we can take advantage of the order of nodes in the preorder and inorder traversals.
A preorder traversal is [node, left, right] while an inorder traversal is [left, node, right].
We know that the root node for a tree is the first element of the preorder array (P).
We also know that every element to the left of the root element in the inorder array (I) is on the left subtree,
and everything to the right of the root element in I is on the right subtree.
Since we know the length of the left and right subtrees by finding the root in I,
and since we know the order of the left and right subtrees in P, we can use that to determine the location of the root node
in P for each of the two subtrees.
With this information, we can define a recursive helper function (splitTree) that will split the tree into two
and then recursively do the same for each subtree.
In order to make this work, we just need to pass left and right limits (ileft, iright) defining the subarray of
the current subtree in I, as well as the index (pix) of the root node of the subtree in P.
At this point, we could iterate forward through I until we found out the location (imid) of the root node each time,
but that would push this solution to a time complexity of O(N^2).
Instead, we can make a prelimanary index map (M) of the values in I, so that we can look up the value for imid
in O(1) time in each recursion. This will lower the time complexity to O(N) at the cost of a space complexity of O(N).

TC:O(n)
SC:O(n)
*/

package binary_tree;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreePreorderInorderTraversal {

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

    public TreeNode buildTree(int[] P, int[] I) {
        Map<Integer, Integer> M = new HashMap<>();
        for (int i = 0; i < I.length; i++)
            M.put(I[i], i);
        return splitTree(P, M, 0, 0, I.length-1);
    }

    private TreeNode splitTree(int[] P, Map<Integer, Integer> M, int pix, int ileft, int iright) {
        int rval = P[pix], imid = M.get(rval);
        TreeNode root = new TreeNode(rval);
        if (imid > ileft)
            root.left = splitTree(P, M, pix+1, ileft, imid-1);
        if (imid < iright)
            root.right = splitTree(P, M, pix+imid-ileft+1, imid+1, iright);
        return root;
    }
}
