import java.io.*;

class Solution {

    private static final int MAX_INT_BIT = 32;

    /**
     * Time Complexity: O(logN). Note that logN is the number of digits in the binary representation of N.
     * Space Complexity: O(1). 
     *
     **/
    public int binaryGap(int n) {
        int lastOffset = -1, maxGap = 0;
        for (int curOffset = 0; curOffset < MAX_INT_BIT; ++curOffset) {
            // n >> curOffset means a remainder when n is divided by 2
            // Using (n >> curOffset) & 1, specify the offset of 1 from right.
            if (((n >> curOffset) & 1) != 0) {
                if (lastOffset >= 0) {
                    int binGap = curOffset - lastOffset;
                    maxGap = Math.max(maxGap, binGap);
                }
                lastOffset = curOffset;
            }
        }
        return maxGap;
    }
}

public class BinaryGap {
    /**
     * e.g 1
     * Input: 22
     * Output: 2
     * Explanation: 
     * 22 in binary is 0b10110.
     * In the binary representation of 22, there are three ones, and two consecutive pairs of 1's.
     * The first consecutive pair of 1's have distance 2.
     * The second consecutive pair of 1's have distance 1.
     * The answer is the largest of these two distances, which is 2.
     *
     * e.g 2
     * Input: 5
     * Output: 2
     * Explanation: 
     * 5 in binary is 0b101.
     *
     * e.g 3
     * input: 6
     * Output: 1
     * Explanation: 
     * 6 in binary is 0b110.
     **/
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int N = Integer.parseInt(line);
            int ret = new Solution().binaryGap(N);
            String out = String.valueOf(ret);
            System.out.printf(out + "\n");
            break;
        }
    }
}
