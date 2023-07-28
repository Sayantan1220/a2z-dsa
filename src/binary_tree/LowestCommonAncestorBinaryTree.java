package binary_tree;

public class LowestCommonAncestorBinaryTree {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
   }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode forLeft = lowestCommonAncestor(root.left,p,p);
        TreeNode forRight = lowestCommonAncestor(root.right,p,q);
        if(forLeft!= null && forRight!=null) return root;
        else if(forLeft!=null) return forLeft;
        else if(forRight!=null) return forRight;
        else return null;
    }
}
