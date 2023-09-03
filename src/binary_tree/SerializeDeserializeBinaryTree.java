/*
Serialization is the process of converting a data structure or object into a sequence of bits so that
it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later
in the same or another computer environment.
Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your
serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized
to a string and this string can be deserialized to the original tree structure.
Clarification: The input/output format is the same as how LeetCode serializes a binary tree.
You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/
 */

package binary_tree;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class SerializeDeserializeBinaryTree {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        // If the root node is null, return an empty string
        if(root == null){
            return "";
        }

        // Create a queue to traverse the tree in a breadth-first manner and a StringBuilder to build the serialized string
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder res = new StringBuilder();

        // Add the root node to the queue
        q.add(root);

        // Traverse the tree in a breadth-first manner
        while(!q.isEmpty()){

            TreeNode node = q.poll();

            // If the current node is null, append "n" to the serialized string
            if(node == null){
                res.append("n ");
                continue;
            }

            // Append the value of the current node to the serialized string
            res.append(node.val).append(" ");

            // Add the left and right children of the current node to the queue
            q.add(node.left);
            q.add(node.right);
        }

        // Convert the StringBuilder to a String and return it
        return res.toString();
    }

    // Decodes the encoded data to a binary tree
    public TreeNode deserialize(String data) {

        // If the data string is empty, return null
        if(Objects.equals(data, "")){
            return null;
        }

        // Create a queue to build the tree in a breadth-first manner
        Queue<TreeNode> q = new LinkedList<>();

        // Split the data string into an array of values
        String[] values = data.split(" ");

        // Create the root node of the tree using the first value in the array
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));

        // Add the root node to the queue
        q.add(root);

        // Traverse the values array to build the tree in a breadth-first manner
        for(int i = 1; i < values.length; i++){

            // Get the parent node from the queue
            TreeNode parent = q.poll();

            // If the current value is not "n", create a new node and set it as the left child of the parent node
            if(!values[i].equals("n")){
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                // Add the new node to the queue
                q.add(left);
            }

            // If the next value is not "n", create a new node and set it as the right child of the parent node
            if(!values[++i].equals("n")){
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                // Add the new node to the queue
                q.add(right);
            }
        }
        // Return the root node of the reconstructed tree
        return root;
    }
}
