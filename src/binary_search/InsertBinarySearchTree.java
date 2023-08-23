package binary_search;

public class InsertBinarySearchTree {
    public TreeNode insertIntoBST(TreeNode root, int val) {

        // if the root is null, create a new node with the given value
        if (root == null) {
            return new TreeNode(val);
        }

        // initialize a current node to the root
        TreeNode cur = root;

        // traverse the tree until an appropriate location for the new node is found
        while (true) {
            // if the value to be inserted is greater than or equal to the current node value
            if (cur.val <= val) {
                // if the right child is not null, move to the right subtree
                if (cur.right != null) {
                    cur = cur.right;
                }
                // if the right child is null, create a new node with the given value and attach it as the right child of the current node
                else {
                    cur.right = new TreeNode(val);
                    break;
                }
            }
            // if the value to be inserted is less than the current node value
            else {
                // if the left child is not null, move to the left subtree
                if (cur.left != null) {
                    cur = cur.left;
                }
                // if the left child is null, create a new node with the given value and attach it as the left child of the current node
                else {
                    cur.left = new TreeNode(val);
                    break;
                }
            }
        }
        // return the root of the BST
        return root;
    }
}
