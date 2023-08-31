/*
Given the root of a binary tree, calculate the vertical order traversal of the binary tree.
For each node at position (row, col), its left and right children will be at positions (row + 1, col - 1)
and (row + 1, col + 1) respectively. The root of the tree is at (0, 0).
The vertical order traversal of a binary tree is a list of top-to-bottom orderings for each column index starting
from the leftmost column and ending on the rightmost column. There may be multiple nodes in the same row and same column.
In such a case, sort these nodes by their values.
Return the vertical order traversal of the binary tree.
https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/description/
 */

package binary_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class VerticalOrderTraversalBinaryTree {

    public static class TreeNode {
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
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        helper(root,0,0,map);
        List<List<Integer>> list=new ArrayList<>();
        for(TreeMap<Integer,PriorityQueue<Integer>> inMap: map.values()){
            ArrayList<Integer> tempList=new ArrayList<>();
            for(PriorityQueue<Integer> pq:inMap.values()){
                while(!pq.isEmpty()){
                    tempList.add(pq.poll());
                }
            }
            list.add(tempList);
        }
        return list;
    }

    public void helper(TreeNode root,int x,int y,TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map){
        if(root==null){
            return;
        }
        map.putIfAbsent(y,new TreeMap<>());
        map.get(y).putIfAbsent(x,new PriorityQueue<>());
        map.get(y).get(x).add(root.val);
        helper(root.left,x+1,y-1,map);
        helper(root.right,x+1,y+1,map);
    }
}
