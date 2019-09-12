import java.util.*;
import java.io.*;

class Solution {
    int MOD = 1000000007;

    public int numRollsToTarget(int d, int f, int target) {
        if (target < d || target > f * d) return 0;
        /**
		 * the 1st index means number of dice
		 * the 2nd index means sum
	     **/	
        int[][] cnt = new int[d + 1][target + 1];

        for (int j = 1; j <= f && j <= target; j++) cnt[1][j] = 1;

        for (int i = 1; i <= d; i++) {
            for (int j = 1; j <= target; j++) {
                for (int k = 1; k <= f && k < j; k++) {
                    /**
					 * Recursice approach
					 * E.g.
					 * Sum(f=2, d=2, s=3) = Sum(2, 1, 2) + Sum(2, 1, 1)
					 **/
                    cnt[i][j] = (cnt[i][j] + cnt[i - 1][j - k]) % MOD;
                }
            }
        }
        return cnt[d][target];
    }
}

public class NumberOfDiceRollsWithTargetSum {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int d = Integer.parseInt(line);
            line = in.readLine();
            int f = Integer.parseInt(line);
            line = in.readLine();
            int target = Integer.parseInt(line);
            int ret = new Solution().numRollsToTarget(d, f, target);
            String out = String.valueOf(ret);
            System.out.print(out + "\n");
            break;
        }
    }
}
