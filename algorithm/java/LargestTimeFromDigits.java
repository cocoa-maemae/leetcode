import java.util.*;
import java.io.*;
import java.util.Arrays;

class Solution {
    /**
     * 
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     **/
    String ans;
    public String largestTimeFromDigits(int[] A) {
        ans = "";
        check(A[0], A[1], A[2], A[3]);
        check(A[0], A[2], A[1], A[3]);
        check(A[0], A[3], A[1], A[2]);
        check(A[1], A[2], A[0], A[3]);
        check(A[1], A[3], A[0], A[2]);
        check(A[2], A[3], A[0], A[1]);
        return ans;
    }

    // For this choice of hour and minute digits, update the answer
    private void check(int h1, int h2, int m1, int m2) {
        String hour = best(h1, h2, 24);
        String minute = best(m1, m2, 60);
        if (hour.isEmpty() || minute.isEmpty()) {
            return;
        }
        String cand = hour + ":" + minute;
        if (cand.compareTo(ans) > 0) {
            ans = cand;
        }
    }

    // What is the largest string less than limit from these 2 digits?
    private String best(int d1, int d2, int limit) {
        int ans = Math.max(10*d1 + d2 < limit ? 10*d1 + d2 : -1,
                           10*d2 + d1 < limit ? 10*d2 + d1 : -1);
        return ans >= 0 ? String.format("%02d", ans) : "";
    }
}

public class LargestTimeFromDigits {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] A = stringToIntegerArray(line);
            String ret = new Solution().largestTimeFromDigits(A);
            String out = (ret);
            System.out.print(out + "\n");
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
