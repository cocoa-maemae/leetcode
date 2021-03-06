import java.io.*:
import java.util.*;

/**
 * Similar with ABC088 B
 **/
class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr):
        List<List<Integer>> ans = new ArrayList<>();
        int d = Integer.MAX_VALUE 
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] < d) {
                d = arr[i] - arr[i - 1];
                ans.clear();
                ans.add(Arrays.asList(arr[i - 1], arr[i]));
            } else if (arr[i] - arr[i - 1] == d) {
                ans.add(Arrays.asList(arr[i - 1], arr[i]));
            }
        }
        return ans;
    }
}

public class MinimumAbsoluteDifference {
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
    public static String integerArrayListToString(List<Integer> nums, int length) {
        if (length == 0) {
            return "[]";
        }
        String result = "";
        for (int index = 0; index < length; index++) {
            Integer number = nums.get(index);
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayListToString(List<Integer> nums) {
        return integerArrayListToString(nums, nums.size());
    }

    public static String int2dListToString(List<List<Integer>> nums) {
        StringBuilder sb = new StringBuilder("[");
        for (List<Integer> list: nums) {
            sb.append(integerArrayListToString(list));
            sb.append(",");
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] arr = stringToIntegerArray(line);
            List<List<Integer>> ret = new Solution().minimumAbsDifference(arr);
            String out = int2dListToString(ret);
			break;
        }
    }
}
