/*
Given the root of a binary tree, imagine yourself standing on the right side of it,
return the values of the nodes you can see ordered from top to bottom.
https://leetcode.com/problems/binary-tree-right-side-view/description/

TC:O(N)
SC:O(N)
 */

package binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {

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

    public List<Integer> rightSideView(TreeNode root) {
        //Approach: Using BFS algorithm(Lavel order traversal)
        List<Integer> res = new ArrayList<Integer>();
        Queue<TreeNode> q = new LinkedList<>();

        //initialize the queue
        q.add(root);

        //traverse while q is not empty
        while(!q.isEmpty()){
            //initialize the right most element
            TreeNode rightSide = null;
            int size = q.size();

            //go through each element in the level
            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                //handle null condition here
                if(node!=null){
                    rightSide = node;
                    //important: add left node in the queue before adding the right node
                    q.add(node.left);
                    q.add(node.right);
                }
            }
            //handle null condition here
            if(rightSide!=null){
                res.add(rightSide.val);
            }
        }
        return res;
    }
}
