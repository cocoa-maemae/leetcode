import java.io.*;
import java.util.*;


class Solution {
    // label is node's number
    public List<Integer> pathInZigZagTree(int label) {
        // Binary tree's row(=height)
        int rows = -1;
        int cur = label;
        while (cur > 0) {
            // Binary tree's row length(=width)
            int curRowLen = (int)Math.pow(2, ++rows);
            cur -= curRowLen;
        }
        List<Integer> ans = new ArrayList();
        ans.add(label);
        while (label > 1) {
            int lastStart = (int)Math.pow(2, --rows);
            int lastLabel = (lastStart * 3) - 1 - (label / 2);
            ans.add(lastLabel);
            label = lastLabel;
        }
        Collections.reverse(ans);
        return ans;
    }
}


/**
 * In an infinite binary tree where every node has two children, the nodes are labelled in row order.
 *
 * In the odd numbered rows (ie., the first, third, fifth,...), the labelling is left to right, while in the even numbered rows (second, fourth, sixth,...), the labelling is right to left.
 *
 * Given the label of a node in this tree, return the labels in the path from the root of the tree to the node with that label.
 *
 *  Example 1:
 *  Input: label = 14
 *  Output: [1,3,4,14]
 *
 *  Example 2:
 *  Input: label = 26
 *  Output: [1,2,6,10,26]
 *
 **/
public class PathInZigzagLabelledBinaryTree {
    public static String integerArrayListToString(List<Integer> nums, int length) {
        if (length == 0) {
            return "[]";
        }
    
        String result = "";
        for(int index = 0; index < length; index++) {
            Integer number = nums.get(index);
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }
    
    public static String integerArrayListToString(List<Integer> nums) {
        return integerArrayListToString(nums, nums.size());
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int label = Integer.parseInt(line);
            List<Integer> ret = new Solution().pathInZigZagTree(label);
            String out = integerArrayListToString(ret);
            System.out.print(out + "\n");
            break;
        }
    }
}
