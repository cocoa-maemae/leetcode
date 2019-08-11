import java.io.*;
import java.util.*;

class Solution {
    public boolean canJump(int[] nums) {
        // the farthest distance that can be reached from the current index
        int farth = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > farth) {
                return false;
            }
            farth = Math.max(nums[i] + i, farth);
        }
        return true;
    }
}

public class JumpGame {
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

    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);
            boolean ret = new Solution().canJump(nums);
            String out = booleanToString(ret);
            System.out.print(out + "\n");
            break;
        }
    }
}
