import java.io.*;
import java.util.*;
import java.util.Arrays;

class Solution {
    /**
     * check whether two numbers have the same digits by comparing the count of their digits.
     * For example, 338 and 833 have the same digits because they both have exactly two 3's and one 8.
	 * Time Complexity:  O(log^2N)
	 * Space Complexity: O(logN) 
     **/
    public boolean reorderedPowerOf2(int N) {
        int[] A = count(N);
        for (int i = 0; i < 31; ++i) {
            // compare with 1 which shifts i bit to left.
			// 1 which shifts i bit to left means power of 2
			System.out.println(Arrays.toString(count(1 << i)));
            if (Arrays.equals(A, count(1 << i))) {
                return true;
            }
        }
        return false;
    }
    
    /** 
     * Returns the count of digits of N
     * Eg. N = 218 or 128, returns a[8]=1, a[1]=1, a[2]=1, int[] ans = {0,1,1,0,0,0,1,0}
     *
     **/
    public int[] count(int N) {
        int[] ans = new int[10];
        while (N > 0) {
            ans[N % 10]++;
            N /= 10;
        }
        return ans;
    }
}

public class ReorderedPowerOf2 {
    public static String booleanToString(boolean input) {
		return input ? "True" : "False";
    }

    /**
	 * Starting with a positive integer N, we reorder the digits in any order (including the original order) such that the leading digit is not zero.
	 * Return true if and only if we can do this in a way such that the resulting number is a power of 2.
	 * Example 1:
	 * Input: 1
	 * Output: true
	 *
	 * Example 2:
	 * Input: 10
	 * Output: false
	 *
     * Example 3:
     * Input: 16
     * Output: true
     *
     * Example 4:
     * Input: 24
     * Output: false
     *
     * Example 5:
     * Input: 46
     * Output: true
     *
     * Note:
     * 1 <= N <= 10^9
    **/
    public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while ((line = in.readLine()) != null) {
			int N = Integer.parseInt(line);
			boolean ret = new Solution().reorderedPowerOf2(N);
			String out = booleanToString(ret);
			System.out.print(out + "\n");
            break;
		}
    }
}
