import java.io.*;
import java.util.*;


class Solution {
    public int jump(int[] nums) {
        int steps = 0;
        int currentMax = 0;
        int nextMax = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (i > currentMax) {
                steps++;
                currentMax = nextMax;
            }
            nextMax = Math.max(nextMax, i + nums[i]);
        }
        return steps;
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
