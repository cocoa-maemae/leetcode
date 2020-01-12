import java.io.*;
import java.util.*;

class Solution {
    public boolean canReach(int[] arr, int start) {
        if (start >= 0 && start < arr.length && arr[start] < arr.length) {
            int jump = arr[start];
            arr[start] += arr.length;
            return jump == 0 || canReach(arr, start + jump) || canReach(arr, start - jump);
        }
        return false;
    }
}

public class JumpGame3 {
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
            int[] arr = stringToIntegerArray(line);
            line = in.readLine();
            int start = Integer.parseInt(line);
            boolean ret = new Solution().canReach(arr, start);
            String out = booleanToString(ret);
            System.out.print(out + "\n");
            break;
        }
    }
}
