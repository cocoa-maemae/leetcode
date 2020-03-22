import java.io.*;
import java.util.*;
import com.eclipsesource.json.JsonArray;


class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int []> pq = new PriorityQueue<>((a, b) -> a[0] != b[0] ? b[0] - a[0] : b[1] - a[1]);
        int[] ans = new int[k];
        for (int i = 0; i < mat.length; i++) {
            pq.offer(new int[] { numOnes(mat[i]), i });
            if (pq.size() > k) {
                pq.poll();
            }
        }
        while (k > 0) ans[--k] = pq.poll()[1];
        return ans;
    }
    
    /**
     * Binary search
     **/
    private int numOnes(int[] row) {
        int lo = 0;
        int hi = row.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (row[mid] == 1) {
                lo = mid + 1;
            } else {
                hi = mid;
            }        
        }
        return lo;
    }
}

public class TheKWeakestRowsInAMatrix {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
          return new int[0];
        }
    
        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }
    
    public static int[][] stringToInt2dArray(String input) {
        JsonArray jsonArray = JsonArray.readFrom(input);
        if (jsonArray.size() == 0) {
          return new int[0][0];
        }
    
        int[][] arr = new int[jsonArray.size()][];
        for (int i = 0; i < arr.length; i++) {
          JsonArray cols = jsonArray.get(i).asArray();
          arr[i] = stringToIntegerArray(cols.toString());
        }
        return arr;
    }
    
    public static String integerArrayToString(int[] nums, int length) {
        if (length == 0) {
            return "[]";
        }
    
        String result = "";
        for(int index = 0; index < length; index++) {
            int number = nums[index];
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }
    
    public static String integerArrayToString(int[] nums) {
        return integerArrayToString(nums, nums.length);
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[][] mat = stringToInt2dArray(line);
            line = in.readLine();
            int k = Integer.parseInt(line);
            int[] ret = new Solution().kWeakestRows(mat, k);
            String out = integerArrayToString(ret);
            System.out.print(out + "\n");
            break;
        }
    }
}
