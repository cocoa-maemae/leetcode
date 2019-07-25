import java.io.*;
import java.util.*;
import com.eclipsesource.json.JsonArray;


class Solution {
	/**
     * Time Complexity: O(m * (end - start))
     * Space Comlexity: 
	 **/
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res = new int[n];
        int m = bookings.length;
        for (int i = 0; i < m; i++) {
            int seats = bookings[i][2];
            int start = bookings[i][0];
            int end = bookings[i][1];
            for (int j = start; j <= end; j++) {
                res[j - 1] += seats;
            }
        }
        return res;
    }
}

public class CorporateFlightBookings {
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

    public static String integerArrayToString(int[] nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for (int index = 0; index < length; index++) {
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
            int[][] bookings = stringToInt2dArray(line);
            line = in.readLine();
            int n = Integer.parseInt(line);
            int[] ret = new Solution().corpFlightBookings(bookings, n);
            String out = integerArrayToString(ret);
            System.out.print(out + "\n");
			break;
        }
    }
}
