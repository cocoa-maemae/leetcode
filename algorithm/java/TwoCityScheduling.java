import java.util.*;
import java.io.*;
import com.eclipsesource.json.JsonArray;

class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int N = costs.length / 2;
        // dp[i][j] represents the cost when considering first (i + j) people in which i people assigned to city A and j people assigned to city B.
        int[][] dp = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            dp[i][0] = dp[i - 1][0] + costs[i - 1][0];
        }
        for (int j = 1; j <= N; j++) {
            dp[0][j] = dp[0][j - 1] + costs[j - 1][1];
        }
        
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] = Math.min(dp[i - 1][j] + costs[i + j - 1][0], dp[i][j - 1] + costs[i + j - 1][1]);
            }
        }
        return dp[N][N];
    }
}

public class TwoCityScheduling {
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
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[][] costs = stringToInt2dArray(line);
            int ret = new Solution().twoCitySchedCost(costs);
            String out = String.valueOf(ret);
            System.out.print(out + "\n");
            break;
        }
    }
}
