/*
Given the root of a binary tree, the value of a target node target, and an integer k,
return an array of the values of all nodes that have a distance k from the target node.
You can return the answer in any order.
https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/description/

Approach :
First, create an unordered map parent to store the parent node of each node in the binary tree.
Use the getparentbyDFS or getparentbyBFS function to populate the parent map by performing a depth-first traversal or bredth first search of the binary tree.
Initialize a queue q and an unordered map vis to keep track of visited nodes.
Mark the target node as visited by setting vis[target] to true and push it into the queue.
Perform a BFS traversal while the queue is not empty:
a. Retrieve the front node curr from the queue.
b. If the current node's left child exists and has not been visited, mark it as visited, and push it into the queue.
c. If the current node's right child exists and has not been visited, mark it as visited, and push it into the queue.
d. If the parent of the current node exists and has not been visited, mark it as visited, and push it into the queue.
e. Repeat steps a to d for all nodes at the current level.
f. Increment the level lev by 1.
g. If the current level is equal to k, exit the traversal.
Store the nodes in the queue in a vector ans.
Return the vector ans, which contains all the nodes at a distance of k from the target node.
Complexity

TC:O(n)
SC:O(n)
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
