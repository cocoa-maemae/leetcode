import java.io.*;
import java.util.*;

class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        //By subtracting atMost(A, k-1), effectively removing all subarrays with count of odd numbers greater than 0 and less than or equal to k-1
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    // the number of subarrays where count of odd numbers is greater than 0 and less than equal to k. 
    private int atMost(int[] A, int k) {
        int res = 0, i = 0;
        for (int j = 0; j < A.length; j++) {
            // if A[j] is not odd, A[j] % 2 = 0
            // if A[j] is odd, A[j] % 2 = 1
            k -= A[j] % 2;
            while (k < 0) {
                k += A[i++] % 2;
            }
            res += j - i + 1;
        }
        return res;
    }
}

public class CountNumberOfNiceSubarrays {
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

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);
            line = in.readLine();
            int k = Integer.parseInt(line);
            int ret = new Solution().numberOfSubarrays(nums, k);
            String out = String.valueOf(ret);
            System.out.print(out + "\n");
            break;
        }
    }
}
