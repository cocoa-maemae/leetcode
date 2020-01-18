import java.io.*;
import java.util.*;

/**
 * Note:
 * You can assume that you can always reach the last index.
 **/
class Solution {
	/**
     * The main idea is based on greedy. Let's say the range of the current jump is [curBegin, curEnd], curFarthest is the farthest point that all points in [curBegin, curEnd] can reach. Once the current point reaches curEnd, then trigger another jump, and set the new curEnd with curFarthest, then keep the above steps
     **/
    public int jump(int[] nums) {
        // answer is the mininum count to reach the last element.
        int ans = 0, curEnd = 0, curFarthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
			// If can't reach the last index,
            // Not need to check i < curFarthest because Note.
            if (i > curFarthest) return -1;

            // if nums=[2,3,1,1,4], curFarthest=0,2,4,4
            curFarthest = Math.max(curFarthest, i + nums[i]);

            // if nums=[2,3,1,1,4], curEnd=0,2,2,4
            if (i == curEnd) {
                // if nums=[2,3,1,1,4], 2 times pass when i=0,2
                ans++;
                curEnd = curFarthest;
            }
        }
        return ans;
    }
}

public class JumpGame2 {
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
            int ret = new Solution().jump(nums);
            String out = String.valueOf(ret);
            System.out.print(out + "\n");
            break;
        }
    }
}
