import java.util.*;
import java.io.*;

/**
 * Approach 1: Just return true
 * Alex is first to pick pile.
 * piles.length is even, and this lead to an interesting fact:
 * Alex can always pick odd piles or always pick even piles!
 *
 * For example,
 * If Alex wants to pick even indexed piles piles[0], piles[2], ....., piles[n-2],
 * he picks first piles[0], then Lee can pick either piles[1] or piles[n - 1].
 * Every turn, Alex can always pick even indexed piles and Lee can only pick odd indexed piles.
 *
 * In the description, we know that sum(piles) is odd.
 * If sum(piles[even]) > sum(piles[odd]), Alex just picks all evens and wins.
 * If sum(piles[even]) < sum(piles[odd]), Alex just picks all odds and wins.
 *
 * So, Alex always defeats Lee in this game.
 *
 * Approach 2: 2D DP
 * It's tricky when we have even number of piles of stones. You may not have this condition in an interview.
 * Follow-up:
 *
 * What if piles.length can be odd?
 * What if we want to know exactly the diffenerce of score?
 * Then we need to solve it with DP.
 *
 * dp[i][j] means the biggest number of stones you can get more than opponent picking piles in piles[i] ~ piles[j].
 * You can first pick piles[i] or piles[j].
 *
 * If you pick piles[i], your result will be piles[i] - dp[i + 1][j]
 * If you pick piles[j], your result will be piles[j] - dp[i][j - 1]
 *
 * So we get:
 * dp[i][j] = max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1])
 * We start from smaller subarray and then we use that to calculate bigger subarray.
 *
 * Note that take evens or take odds, it's just an easy strategy to win when the number of stones is even.
 * It's not the best solution!
 * I didn't find a tricky solution when the number of stones is odd (maybe there is).
 **/
class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
			dp[i][i] = piles[i];
        }
        for (int d = 1; d < n; d++) {
            for (int i = 0; i < n - d; i++) {
                dp[i][i + d] = Math.max(piles[i] - dp[i + 1][i + d], piles[i + d] - dp[i][i + d - 1]);
            }
        }
        return dp[0][n - 1] > 0;
    }
}

/**
 * Alex and Lee play a game with piles of stones. There are an even number of piles arranged in a
 * row, and each pile has a positive integer number of stones piles[i].
 *
 * <p>The objective of the game is to end with the most stones. The total number of stones is odd,
 * so there are no ties.
 *
 * <p>Alex and Lee take turns, with Alex starting first. Each turn, a player takes the entire pile
 * of stones from either the beginning or the end of the row. This continues until there are no more
 * piles left, at which point the person with the most stones wins. Assuming Alex and Lee play
 * optimally, return True if and only if Alex wins the game.
 *
 * <p>Example 1: Input: [5,3,4,5] Output: true
 *
 * <p>Explanation: Alex starts first, and can only take the first 5 or the last 5. Say he takes the
 * first 5, so that the row becomes [3, 4, 5]. If Lee takes 3, then the board is [4, 5], and Alex
 * takes 5 to win with 10 points. If Lee takes the last 5, then the board is [3, 4], and Alex takes
 * 4 to win with 9 points. This demonstrated that taking the first 5 was a winning move for Alex, so
 * we return true.
 */
public class StoneGame {
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
            int[] piles = stringToIntegerArray(line);
            boolean ret = new Solution().stoneGame(piles);
            String out = booleanToString(ret);
            System.out.print(out + '\n');
            break;
        }
    }
}
