import java.io.*;
import java.util.*;

class Solution {
    /**
     * In an array A of 0s and 1s, how many non-empty subarrays have sum S?
     *
	 * Input: A = [1,0,1,0,1], S = 2
	 * Output: 4
	 * Explanation: 
	 * The 4 subarrays are bolded below:
	 * [1,0,1,0,1]
	 * [1,0,1,0,1]
	 * [1,0,1,0,1]
	 * [1,0,1,0,1]
	 *
	 * Note:
	 *    A.length <= 30000
     *    0 <= S <= A.length
	 *    A[i] is either 0 or 1.
     *
	 * Time Complexity: O(N) where N is the length of A.
	 * Space Complexity: O(1) 
     **/
    public int numSubarraysWithSum(int[] A, int S) {
        int iLo = 0, iHi = 0;
        int sumLo = 0, sumHi = 0;
        int ans = 0;

        for (int j = 0; j < A.length; ++j) {
            // While sumLo is too big, iLo++
            sumLo += A[j];
            while (iLo < j && sumLo > S) {
                sumLo -= A[iLo++];
			}

            // While sumHi is too big, or equal and we can move, iHi++
            sumHi += A[j];
            while (iHi < j && (sumHi > S || sumHi == S && A[iHi] == 0)) {
                sumHi -= A[iHi++];
			}

            if (sumLo == S) {
                ans += iHi - iLo + 1;
			}
        }

        return ans;
    }
}

public class BinarySubarraysWithSum {
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
