/*
Given the root of a binary tree, the value of a target node target, and an integer k,
return an array of the values of all nodes that have a distance k from the target node.
You can return the answer in any order.
https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/description/

 */

package binary_tree;

import java.util.*;

public class AllNodesDistanceKBinaryTree {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public void getParentsByBFS(Map<TreeNode, TreeNode> parent, TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            while (n-- > 0) {
                TreeNode curr = queue.poll();
                if (curr.left != null) {
                    parent.put(curr.left, curr);
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    parent.put(curr.right, curr);
                    queue.offer(curr.right);
                }
            }
        }
    }

    public void getParentsByDFS(Map<TreeNode, TreeNode> parent, TreeNode root) {
        if (root == null)
            return;
        if (root.left != null)
            parent.put(root.left, root);
        if (root.right != null)
            parent.put(root.right, root);
        getParentsByDFS(parent, root.left);
        getParentsByDFS(parent, root.right);
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        getParentsByDFS(parent, root);
        Queue<TreeNode> queue = new LinkedList<>();
        Map<TreeNode, Boolean> visited = new HashMap<>();
        visited.put(target, true);
        queue.offer(target);
        int level = 0;
        while (!queue.isEmpty()) {
            int n = queue.size();
            if (level == k)
                break;
            level++;
            while (n-- > 0) {
                TreeNode curr = queue.poll();
                if (curr.left != null && !visited.containsKey(curr.left)) {
                    visited.put(curr.left, true);
                    queue.offer(curr.left);
                }
                if (curr.right != null && !visited.containsKey(curr.right)) {
                    visited.put(curr.right, true);
                    queue.offer(curr.right);
                }
                if (parent.containsKey(curr) && !visited.containsKey(parent.get(curr))) {
                    visited.put(parent.get(curr), true);
                    queue.offer(parent.get(curr));
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            ans.add(queue.poll().val);
        }
        return ans;
    }
}
