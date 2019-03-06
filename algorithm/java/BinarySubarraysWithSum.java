import java.io.*;
import java.util.*;

class Solution {
    /**
     * For each j, let's count the number of i with P[j] = P[i] + S. 
	 * This is analogous to counting the number of subarrays ending in j with sum S.
	 * It comes down to counting how many P[i] + S we've seen before. 
	 * We can keep this count on the side to help us find the final answer.
     *
     * Time Complexity: O(N) where N is the length of A.
     * Space Complexity: O(N) 
     **/
    public int numSubarraysWithSum(int[] A, int S) {
        int N = A.length;
        int[] P = new int[N + 1];
        for (int i = 0; i < N; ++i) {
            P[i + 1] = P[i] + A[i];
		}
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        int ans = 0;
        for (int n : P) {
            ans += cnt.getOrDefault(n, 0);
            cnt.put(n + S, cnt.getOrDefault(n + S, 0) + 1);
        }
        return ans;
    }
}

public class BinarySubarraysWithSum {
    /**
     * In an array A of 0s and 1s, how many non-empty subarrays have sum S?
     *
     * Input: A = [1,0,1,0,1], S = 2
     * Output: 4
     * Explanation: 
     * The 4 subarrays are below:
     * [1,0,1,*,*]
     * [1,0,1,0,*]
     * [*,0,1,0,1]
     * [*,*,1,0,1]
     *
     * Note:
     *    A.length <= 30000
     *    0 <= S <= A.length
     *    A[i] is either 0 or 1.
     *
     **/
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] A = stringToIntegerArray(line);
            line = in.readLine();
            int S = Integer.parseInt(line);
            int ret = new Solution().numSubarraysWithSum(A, S);
            String out = String.valueOf(ret);
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
}
