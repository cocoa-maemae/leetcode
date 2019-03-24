import java.io.*;
import java.util.*;

class Solution {
    /**
     * Find the index i of the next maximum number x.
     * Reverse i + 1 numbers, so that the x will be at A[0]
     * Reverse x numbers, so that x will be at A[x - 1].
     * Repeat this process N times.
     * Update:
     * Actually, I didn't use the condition permutation of [1,2,..., A.length].
     * I searched in the descending order of A.
     * Time Complexity:
     * O(N^2)
     **/
    public List<Integer> pancakeSort(int[] A) {
        List<Integer> ans = new ArrayList<>();
        // x = A.length, A.length-1 ... 1
        for (int x = A.length, i; x > 0; --x) {
            // i = x-2, x-3 ... 0
            for (i = 0; A[i] != x; ++i);
            reverse(A, i + 1);
            ans.add(i + 1);
            reverse(A, x);
            ans.add(x);
        }
        return ans;
    }

    private void reverse(int[] A, int k) {
        for (int i = 0, j = k - 1; i < j; i++, j--) {
            int tmp = A[i];
            A[i] = A[j];
            A[j] = tmp;
        }
    }
}

public class PancakeSorting {
    /**
     * Given an array A, we can perform a pancake flip: We choose some positive integer k <= A.length, then reverse the order of the first k elements of A.  We want to perform zero or more pancake flips (doing them one after another in succession) to sort the array A.
     *
     * Return the k-values corresponding to a sequence of pancake flips that sort A.  Any valid answer that sorts the array within 10 * A.length flips will be judged as correct.
     *
     * Example 1:
     *
     * Input: [3,2,4,1]
     * Output: [4,2,4,3]
     * Explanation: 
     * We perform 4 pancake flips, with k values 4, 2, 4, and 3.
     * Starting state: A = [3, 2, 4, 1]
     * After 1st flip (k=4): A = [1, 4, 2, 3]
     * After 2nd flip (k=2): A = [4, 1, 2, 3]
     * After 3rd flip (k=4): A = [3, 2, 1, 4]
     * After 4th flip (k=3): A = [1, 2, 3, 4], which is sorted. 
     *
     **/
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] A = stringToIntegerArray(line);
            List<Integer> ret = new Solution().pancakeSort(A);
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
