import java.io.*;
import java.util.*;

class Solution {
    /**
     * Time Complexity: O(max(N, logK)) where N is the length of A. Space Complexity: O(max(N,
     * logK))
     */
    public List<Integer> addToArrayForm(int[] A, int K) {
        int cur = K;
        List<Integer> ans = new ArrayList<Integer>();
        int i = A.length;
        while (--i >= 0 || cur > 0) {
            if (i >= 0) {
                cur += A[i];
            }
            ans.add(cur % 10);
            cur /= 10;
        }
        Collections.reverse(ans);
        return ans;
    }
}

public class AddToArrayFormOfInteger {
    /**
     * For a non-negative integer X, the array-form of X is an array of its digits in left to right
     * order. For example, if X = 1231, then the array form is [1,2,3,1]. Given the array-form A of
     * a non-negative integer X, return the array-form of the integer X+K.
     *
     * <p>Example 1: Input: A = [1,2,0,0], K = 34 Output: [1,2,3,4] Explanation: 1200 + 34 = 1234
     * <p>Example 2: Input: A = [2,7,4], K = 181 Output: [4,5,5] Explanation: 274 + 181 = 455
     * <p>Example 3: Input: A = [2,1,5], K = 806 Output: [1,0,2,1] Explanation: 215 + 806 = 1021
     * <p>Example 4: Input: A = [9,9,9,9,9,9,9,9,9,9], K = 1 Output: [1,0,0,0,0,0,0,0,0,0,0]
     * Explanation: 9999999999 + 1 = 10000000000
     */
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] A = stringToIntegerArray(line);
            line = in.readLine();
            int K = Integer.parseInt(line);
            List<Integer> ret = new Solution().addToArrayForm(A, K);
            String out = integerArrayListToString(ret);
            System.out.println(out);
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
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    private static String integerArrayListToString(List<Integer> nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for (int index = 0; index < length; index++) {
            Integer number = nums.get(index);
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    private static String integerArrayListToString(List<Integer> nums) {
        return integerArrayListToString(nums, nums.size());
    }
}
