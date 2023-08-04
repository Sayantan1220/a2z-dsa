package binary_tree;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeInorderPostorderTraversal {

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

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        final var length = postorder.length;
        final var map = new HashMap<Integer, Integer>();
        for(int i=0; i<length; i++) {
            map.put(inorder[i], i);
        }

        return tree(map, postorder, 0, length-1, 0, length-1);
    }

    /**
     * @param il inorder low
     * @param im inorder max
     * @param pl postfix low
     * @param pm postfix max
     */
    private TreeNode tree(Map<Integer, Integer> inorder, int[] postorder, int il, int im, int pl, int pm) {
        if(pm < pl) {
            return null;
        }

        final var root = new TreeNode(postorder[pm]);

        if(pl < pm) {
            final var index = inorder.getOrDefault(root.val, -1);
            final var left = index-1-il;
            root.left = tree(inorder, postorder, il, index-1, pl, pl+left);
            root.right = tree(inorder, postorder, index+1, im, pl+left+1, pm-1);
        }
        return root;
    }
}
