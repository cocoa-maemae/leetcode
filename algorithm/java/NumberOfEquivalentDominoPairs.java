import java.io.*;
import java.util.*;
import com.eclipsesource.json.JsonArray;

class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<Integer, Integer> cnt = new HashMap<>();
        int ans = 0;
        for (int[] d : dominoes) {
            /**
             * If dominoes = {{1,2},{2,1},{3,4},{5,6}}
             * d[0]=1,d[1]=2,k=1*10+2
             * d[0]=2,d[1]=1,k=1*10+2
             * d[0]=3,d[1]=4,k=3*10+4
             * d[0]=5,d[1]=6,k=5*10+6
             **/
            int k = Math.min(d[0], d[1]) * 10 + Math.max(d[0], d[1]);
            cnt.put(k, cnt.getOrDefault(k, 0) + 1);
        }
        // calculate nC2
        for (int v : cnt.values()) {
            ans += v * (v - 1) / 2;
        }
        return ans;
    }
}

public class NumberOfEquivalentDominoPairs {
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
            int[][] dominoes = stringToInt2dArray(line);
            int ret = new Solution().numEquivDominoPairs(dominoes);
            String out = String.valueOf(ret);
            System.out.print(out + "\n");
            break;
        }
    }
}
