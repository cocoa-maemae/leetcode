import java.io.*;
import java.util.*;

/**
 * The question says that a number is good if each individual number is rotated and the original number is different to the rotated number.
 * Here is how rotations work:
 * 0 rotates to 0
 * 1 rotates to 1
 * 8 rotates to 8
 *
 * 2 rotates to 5
 * 5 rotates to 2
 * 6 rotates to 9
 * 9 rotates to 6
 *
 * Every other number 3,4 and 7 do not rotate and are invalid meaning if the number contains one of these it cannot be changed.
 * So this means that 20 would rotate to 50 bc 2 rotates to 5 and 0 stays the same. This number is good since 20 != 50.
 * Another example is 33, since 3 is the first int it becomes invalid. Another example of this is 23, since 3 is the second int in the number it becomes invalid meaning even tho 2 changes to 5 and the number is 53, and 53 != 23, the 3 invalidates the number making it no good.
 * Hope this helps you guys understand what the question is asking for!
 *
 **/

class Solution {
    public int rotatedDigits(int N) {
        /**
         * dp[n]=0, invalid number
         * dp[n]=1, valid and same number
         * dp[n]=2, valid and different number
         **/
        int[] dp = new int[N + 1];
        int ans = 0;
        for (int n = 0; n <= N; n++) {
            if (n < 10) {
                if (n == 0 || n == 1 || n == 8) {
                    dp[n] = 1;
                } else if (n == 2 || n == 5 || n == 6 || n == 9) {
                    dp[n] = 2;
                    ans++;
                }
            } else {
                int a = dp[n / 10], b = dp[n % 10];
                if (a == 1 && b == 1) {
                    dp[n] = 1;
                } else if (a >= 1 && b >= 1) {
                    dp[n] = 2;
                    ans++;
                }
            }
        }
        return ans;
    }
}

public class RotatedDigits {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int N = Integer.parseInt(line);
            int ret = new Solution().rotatedDigits(N);
            String out = String.valueOf(ret);
            System.out.println(out + "\n");
            break;            
        }
    }
}
