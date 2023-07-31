package binary_tree;

public class CountCompleteTreeNodes {

    public int countNodes(TreeNode root) {
        if(root == null) return 0;

        int ans = countAllNodes(root);
        return ans;
    }
    int countAllNodes(TreeNode root)
    {
        if(root == null) return 0;
        int lh =  countAllNodes(root.left);
        int rh =  countAllNodes(root.right);

        return lh + rh + 1;
    }
}
