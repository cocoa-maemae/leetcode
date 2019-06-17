import com.eclipsesource.json.JsonArray;
import java.io.*;
import java.util.*;

/**
 * front-back projection area on xz = sum(max value for every col)
 * right-left projection area on yz = sum(max value for every row)
 * top-down projection area on xy = sum(1 for every v > 0)
 **/
class Solution {
    public int projectionArea(int[][] grid) {
        int ans = 0, n = grid.length;
        for (int i = 0; i < n; ++i) {
            int x = 0, y = 0;
            for (int j = 0; j < n; ++j) {
                x = Math.max(x, grid[i][j]);
                y = Math.max(y, grid[j][i]);
                if (grid[i][j] > 0) ++ans;
            }
            ans += x + y;
        }
        return ans;
    }
}

/**
 * On a N * N grid, we place some 1 * 1 * 1 cubes that are axis-aligned with the x, y, and z axes.
 * Each value v = grid[i][j] represents a tower of v cubes placed on top of grid cell (i, j).
 * Now we view the projection of these cubes onto the xy, yz, and zx planes.
 * A projection is like a shadow, that maps our 3 dimensional figure to a 2 dimensional plane. 
 * Here, we are viewing the "shadow" when looking at the cubes from the top, the front, and the side.
 * Return the total area of all three projections.
 *
 * Example 1:
 * Input: [[2]]
 * Output: 5
 *
 * Example 2:
 * Input: [[1,2],[3,4]]
 * Output: 17
 * Explanation: 
 * Here are the three projections ("shadows") of the shape made with each axis-aligned
 *
 * Example 3:
 * Input: [[1,0],[0,2]]
 * Output: 8
 *
 * Example 4:
 * Input: [[1,1,1],[1,0,1],[1,1,1]]
 * Output: 14
 *
 * Example 5:
 * Input: [[2,2,2],[2,1,2],[2,2,2]]
 * Output: 21
 *
 **/
public class ProjectionAreaOf3DShapes {
    public static int[] stringToIntegerArray(String input) {
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
            int ret = new Solution().projectionArea(grid);
            String out = String.valueOf(ret);
            System.out.print(out + '\n');
            break;
        }
    }
}
