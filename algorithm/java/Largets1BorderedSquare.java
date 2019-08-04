import java.io.*;
import java.util.*;

public class Solution {
    public int largest1BorderedSquare(int[][] grid) {
        if (grid.length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        int hor[][] = new int[m][n];
        int ver[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    hor[i][j] = j == 0 ? 1 : hor[i][j - 1] + 1;
                    ver[i][j] = i == 0 ? 1 : ver[i - 1][j] + 1;
                }
            }
        }
        int max = 0;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int edge = Math.min(hor[i][j], ver[i][j]);
                while (edge > max) {
                    if (ver[i][j - edge + 1] >= edge && hor[i - edge + 1][j] >= edge) max = edge;
                    edge--;
                }
            }
        }
        return max * max;
    }
}

public class Largest1BorderedSquare {

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
            int[][] grid = stringToInt2dArray(line);
            int ret = new Solution().largest1BorderedSquare(grid);
            String out = String.valueOf(ret);
            System.out.print(out + "\n");
            break;
        }
    }
}
