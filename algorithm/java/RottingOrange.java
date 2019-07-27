import com.eclipsesource.json.JsonArray;
import java.io.*;
import java.util.*;

class Solution {
    public int orangesRotting(int[][] grid) {
        final int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length, n = grid[0].length, fresh = 0, rot = 0, minit = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) fresh++;
                if (grid[i][j] == 2) q.offer(new int[] {i, j});
            }
        }

        while (!q.isEmpty() && fresh > 0) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                for (int[] dir : dirs) {
                    int x = cur[0] + dir[0];
                    int y = cur[1] + dir[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                        fresh--;
                        grid[x][y] = 2;
                        q.offer(new int[] {x, y});
                    }
                }
            }
            minit++;
        }
        return fresh == 0 ? minit : -1;
    }
}

public class RottingOrange {
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
            int ret = new Solution().orangesRotting(grid);
            String out = String.valueOf(ret);
            System.out.print(out + "\n");
            break;
        }
    }
}
