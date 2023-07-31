package binary_tree;

public class CountCompleteTreeNodes {

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

    public int countNodes(TreeNode root) {
        if(root == null) return 0;

        return countAllNodes(root);
    }
    int countAllNodes(TreeNode root)
    {
        if(root == null) return 0;
        int lh =  countAllNodes(root.left);
        int rh =  countAllNodes(root.right);

        return lh + rh + 1;
    }
}
