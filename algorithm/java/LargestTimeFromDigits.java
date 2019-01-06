import java.util.*;
import java.io.*;
import java.util.Arrays;

class Solution {
    public String largestTimeFromDigits(int[] A) {
        LinkedList<String> q = new LinkedList<>();
        q.add("");
        // add permutation of a to q
        for (int n : A) {
            for (int size = q.size(); size > 0; size--) {
                String s = q.poll();
                for (int i = 0; i <= s.length(); i++) {
                    q.add(s.substring(0, i) + n + s.substring(i));
                }
            }
        }
        String largest = "";
        for (String s : q) {
            s = s.substring(0, 2) + ":" + s.substring(2);
            if (s.charAt(3) < '6' && s.compareTo("24:00") < 0 && s.compareTo(largest) > 0) {
                largest = s;
            }
        }
        return largest;
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
