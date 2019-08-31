import java.io.*;
import java.util.*;

class TreeNode {
    public int val = 0;
    public TreeNode left = null;
    public TreeNode right = null;
    public TreeNode(int x) { 
        val = x; 
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    // key is node.val, value is tree depth
    Map<Integer, Integer> depth;
    Map<Integer, TreeNode> parent;

    /**
     * Time Complexity: O(N), where NNN is the number of nodes in the tree.
     **/
    public boolean isCousins(TreeNode root, int x, int y) {
        depth = new HashMap<Integer, Integer>();
        parent = new HashMap<Integer, TreeNode>();
        dfs(root, null);
        return (depth.get(x) == depth.get(y) && parent.get(x) != parent.get(y));
    }

    private void dfs(TreeNode node, TreeNode par) {
        if (node != null) {
            depth.put(node.val, (par != null) ? (1 + depth.get(par.val)) : 0);
            parent.put(node.val, par);
            // continue till node is empty
            dfs(node.left, node);
            dfs(node.right, node);
        }
    }
}

public class CousinsInBinaryTree {
   /**
    * In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
    * Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
    * We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.
    * Return true if and only if the nodes corresponding to the values x and y are cousins.
    *
    *  Example 1:
    *  Input: root = [1,2,3,4], x = 4, y = 3
    *  Output: false
    *
    *  Example 2:
    *  Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
    *  Output: true
    *
    *  Example 3:
    *  Input: root = [1,2,3,null,4], x = 2, y = 3
    *  Output: false
    *
    **/
    public static void main(String[] args) throws IOException { 
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line; 
        while ((line = in.readLine()) != null) { 
            TreeNode root = stringToTreeNode(line); 
            line = in.readLine(); 
            int x = Integer.parseInt(line); 
            line = in.readLine(); 
            int y = Integer.parseInt(line); 
            boolean ret = new Solution().isCousins(root, x, y); 
            String out = booleanToString(ret); 
            System.out.print(out + "\n"); 
            break;
        } 
    } 

    private static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }
        String[] parts = input.split(",");
        // root node value
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        int index = 1;
        while (!nodeQueue.isEmpty()) { 
            TreeNode node = nodeQueue.remove();
            if (index == parts.length) {
                break;
            }
            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) { 
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber); 
                nodeQueue.add(node.left);
            } 
            if (index == parts.length) {
                break;
            } 
            item = parts[index++]; 
            item = item.trim(); 
            if (!item.equals("null")) { 
                int rightNumber = Integer.parseInt(item); 
                node.right = new TreeNode(rightNumber); 
                nodeQueue.add(node.right); 
            } 
        } 
        return root; 
    } 

    private static String booleanToString(boolean input) { 
        return input ? "True" : "False"; 
    } 
}
