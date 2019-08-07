import java.io.*;
import java.util.*;

class Solution {
    /** 
     * Time complexity: O(N) for one pass 
     * Space complexity: O(2) for two options 
     **/
    public int movesToMakeZigzag(int[] nums) {
        int res[] = new int[2], n = nums.length, left, right;
        for (int i = 0; i < n; ++i) {
            left = (i > 0) ? nums[i - 1] : 1001;
            right = (i + 1 < n) ? nums[i + 1] : 1001;
            res[i % 2] += Math.max(0, nums[i] - Math.min(left, right) + 1);
        }
        return Math.min(res[0], res[1]);
    }
}

public class DecreaseElementsToMakeArrayZigzag {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);
            int ret = new Solution().movesToMakeZigzag(nums);
            String out = String.valueOf(ret);
            System.out.print(out + "\n");
            break;
        }
    }
}
