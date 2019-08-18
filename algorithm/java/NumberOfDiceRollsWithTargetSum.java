import java.util.*;
import java.io.*;

class Solution {
    int MOD = 1000000000 + 7;
    Map<String, Integer> memo = new HashMap<>();

    public int numRollsToTarget(int d, int f, int target) {
        if (target < d || target > f * d) return 0;
        int[][] dp = new int[d + 1][target + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= d; i++) {
            for (int j = 1; j <= f; j++) {
                for (int k = i - 1; k <= f * (i - 1) && j + k <= target; k++) {
                    dp[i][j + k] = (dp[i][j + k] + dp[i - 1][k]) % MOD;
                }
            }
        }
        return dp[d][target];
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
