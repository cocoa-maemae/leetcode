import java.io.*;
import java.util.*;

class Solution {
    /**
     * Make sure start comes before end
     * Caculate the sum of target interval as well as the total sum
     * The result will be the min of target interval sum and the remaining interval sum.
     **/
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if (start > destination) {
            int tmp = start;
            start = destination;
            destination = tmp;
        }
        int res = 0, total = 0;
        for (int i = 0; i < distance.length; i++) {
            if (i >= start && i < destination) {
                res += distance[i];
            }
            total += distance[i];
        }
        return Math.min(res, total - res);
    }
}

public class DistanceBetweenBusStops {
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

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] distance = stringToIntegerArray(line);
            line = in.readLine();
            int start = Integer.parseInt(line);
            line = in.readLine();
            int destination = Integer.parseInt(line);
            int ret = new Solution().distanceBetweenBusStops(distance, start, destination);
            String out = String.valueOf(ret);
            System.out.print(out + "\n");
            break;
        }
    }
}
