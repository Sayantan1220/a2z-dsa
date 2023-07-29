/*
Given the root of a binary tree, return the maximum width of the given tree.
The maximum width of a tree is the maximum width among all levels.
The width of one level is defined as the length between the end-nodes (the leftmost and rightmost non-null nodes),
where the null nodes between the end-nodes that would be present in a complete binary tree extending down to that
level are also counted into the length calculation.
It is guaranteed that the answer will in the range of a 32-bit signed integer.
https://leetcode.com/problems/maximum-width-of-binary-tree/description/

Approach:
Use DFS to iterate all nodes and use hash map to save the most left index.
Then we can get the level width using current index - the most left index + 1.

TC:O(N)
SC:O(N)
 */

package binary_tree;

import java.util.HashMap;
import java.util.Map;

public class MaximumWidthBinaryTree {

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

    Map<Integer, Integer> levelMin = new HashMap<>();
    public int widthOfBinaryTree(TreeNode root) {
        return dfs(root, 1, 1);
    }

    private int dfs(TreeNode node, int depth, int index) {
        if (node == null) {
            return 0;
        }
        levelMin.putIfAbsent(depth, index);
        return Math.max(index - levelMin.get(depth) + 1, Math.max(dfs(node.left, depth + 1, index * 2), dfs(node.right, depth + 1, index * 2 + 1)));
    }
}
