/*
Given the root of a binary search tree and an integer k,
return true if there exist two elements in the BST such that their sum is equal to k, or false otherwise.
https://leetcode.com/problems/two-sum-iv-input-is-a-bst/description/

TC : O(N)
SC : O(N)
 */

package binary_search;

import java.util.HashSet;
import java.util.Set;

public class TwoSumIVInputBST {

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
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> hs=new HashSet<>();
        TreeNode curr=root;
        while(curr!=null){
            if(curr.left==null){
                if(hs.contains(k-curr.val)) return true;
                hs.add(curr.val);
                curr=curr.right;
            }else{
                TreeNode temp=curr.left;
                while(temp.right!=null && temp.right!=curr){
                    temp=temp.right;
                }
                if(temp.right==curr){
                    temp.right=null;
                    curr=curr.right;
                }else{
                    if(hs.contains(k-curr.val)) return true;
                    hs.add(curr.val);
                    temp.right=curr;
                    curr=curr.left;
                }
            }
        }
        return false;
    }
}
