import java.io.*;
import java.util.*;

class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        Map<Integer, Integer> limit = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < values.length; i++) {
            if (!limit.containsKey(labels[i])) limit.put(labels[i], 0);
            pq.offer(new int[] {values[i], labels[i]});
        }
        int max = 0, count = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (limit.get(cur[1]) < use_limit) {
                max += cur[0];
                limit.put(cur[1], limit.get(cur[1]) + 1);
                if (++count == num_wanted) break;
            }
        }
        return max;
    }
}

/**
 * We have a set of items: the i-th item has value values[i] and label labels[i]. Then, we choose a
 * subset S of these items, such that: |S| <= num_wanted For every label L, the number of items in S
 * with label L is <= use_limit. Return the largest possible sum of the subset S.
 *
 * <p>Example 1: Input: values = [5,4,3,2,1], labels = [1,1,2,2,3], num_wanted = 3, use_limit = 1
 * Output: 9 Explanation: The subset chosen is the first, third, and fifth item.
 *
 * <p>Example 2: Input: values = [5,4,3,2,1], labels = [1,3,3,3,2], num_wanted = 3, use_limit = 2
 * Output: 12 Explanation: The subset chosen is the first, second, and third item.
 *
 * <p>Example 3: Input: values = [9,8,8,7,6], labels = [0,0,0,1,1], num_wanted = 3, use_limit = 1
 * Output: 16 Explanation: The subset chosen is the first and fourth item.
 *
 * <p>Example 4: Input: values = [9,8,8,7,6], labels = [0,0,0,1,1], num_wanted = 3, use_limit = 2
 * Output: 24 Explanation: The subset chosen is the first, second, and fourth item.
 */
public class LargestValuesFromLabels {
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
            int[] values = stringToIntegerArray(line);
            line = in.readLine();
            int[] labels = stringToIntegerArray(line);
            line = in.readLine();
            int num_wanted = Integer.parseInt(line);
            line = in.readLine();
            int use_limit = Integer.parseInt(line);
            int ret = new Solution().largestValsFromLabels(values, labels, num_wanted, use_limit);
            String out = String.valueOf(ret);
            System.out.println(out + "\n");
            break;
        }
    }
}
