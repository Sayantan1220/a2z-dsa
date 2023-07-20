/*
Given the root of a binary tree, return the zigzag level order traversal of its nodes' values.
(i.e., from left to right, then right to left for the next level and alternate between).
https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/

Time complexity: O(n)
Space complexity:O(n)
 */

package binary_tree;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {

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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> zlist = new ArrayList<>();
        List<Integer> list ;
        Queue<TreeNode> q = new LinkedList<>();
        int size = 0;
        boolean flag = false;

        if(root == null)
            return zlist;

        q.offer(root);

        while(!q.isEmpty())
        {
            size = q.size();
            list = new ArrayList<>();
            while(size-- >0)
            {
                root = q.poll();

                if(root.left!=null)
                    q.add(root.left);
                if(root.right!=null)
                    q.add(root.right);

                list.add(root.val);
            }

            //reverse list
            if(flag)
                Collections.reverse(list);

            flag = !flag;
            zlist.add(list);
        }
        return zlist;
    }
}
