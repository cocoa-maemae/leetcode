import java.io.*;
import java.util.*;

class Solution {
    /**
     * Time Complexity: O(A.length + B.length)
     * Space Complexity: O(B.length), the space used by setB. (We can improve this to min(A.length,B.length) by using an if statement.) 
     **/
    public int[] fairCandySwap(int[] A, int[] B) {
        // sum of A, B respectively
        int sa = 0, sb = 0;  
        for (int a : A) {
            sa += a;
        }
        for (int b : B) {
            sb += b;
        }
        // If Alice gives x, she expects to receive x + delta
        int delta = (sb - sa) / 2;
        Set<Integer> setB = new HashSet<Integer>();
        for (int b : B) {
            setB.add(b);
        }
        for (int a : A) {
            if (setB.contains(a + delta)) {
                return new int[]{a, a + delta};
            }
        }
        throw null;
    }
}

class FairCandySwap {

    /**
     * Alice and Bob have candy bars of different sizes: A[i] is the size of the i-th bar of candy that Alice has, and B[j] is the size of the j-th bar of candy that Bob has.
     *
     * Since they are friends, they would like to exchange one candy bar each so that after the exchange, they both have the same total amount of candy.  (The total amount of candy a person has is the sum of the sizes of candy bars they have.)
     * Return an integer array ans where ans[0] is the size of the candy bar that Alice must exchange, and ans[1] is the size of the candy bar that Bob must exchange.
     * If there are multiple answers, you may return any one of them.  It is guaranteed an answer e
     *
     * Input: A = [2], B = [1,3]
     * Output: [2,3]
     *
     * Input: A = [1,2,5], B = [2,4]
     * Output: [5,4]
     *
     **/
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        int r = 0;
        while ((line = in.readLine()) != null) {
            int[] A = stringToIntegerArray(line);
            line = in.readLine();
            int[] B = stringToIntegerArray(line);
            int[] ret = new Solution().fairCandySwap(A, B);
            String out = integerArrayToString(ret);
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
        for (int i = 0; i < parts.length; i++) {
            String part = parts[i].trim();
            output[i] = Integer.parseInt(part);
        }
        return output;
    }

    private static String integerArrayToString(int[] nums) {
        return integerArrayToString(nums, nums.length);
    }

    private static String integerArrayToString(int[] nums, int length) {
        if (length == 0) { return "[]";
        }

        String result = "";
        for (int i = 0; i < length; i++) {
            int number = nums[i];
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }
}
