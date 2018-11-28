import java.util.*;
import java.io.*;

class Solution {
    /**
     *
     *
     **/
    public void nextPermutation(int[] nums) {

    }
}

public class NextPermutation {

    /**
     * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
	 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
	 * The replacement must be in-place and use only constant extra memory.
	 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
     *
 	 * e.g.
	 * 1,2,3 → 1,3,2
	 * 3,2,1 → 1,2,3
	 * 1,1,5 → 1,5,1
     **/
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);
            new Solution().nextPermutation(nums);
            String out = integerArrayToString(nums);
            System.out.print(out + "\n");
            break;
        }
    } 

    private static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }
        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }
                                                                         
    private static String integerArrayToString(int[] nums) {
        return integerArrayToString(nums, nums.length);
    }

    private static String integerArrayToString(int[] nums, int length) {
        if (length == 0) {
            return "[]";
        }
        String result = "";
        for (int index = 0; index < length; index++) {
            int number = nums[index];
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }
}
