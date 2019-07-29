import java.io.*;
import java.util.*;

class Solution {
    /** Time Complexity: O(2^n) */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(ans, new ArrayList<Integer>(), candidates, target, 0);
        return ans;
    }

    private void backtrack(
            List<List<Integer>> ans, List<Integer> tmp, int[] cand, int remain, int start) {

        if (remain < 0) {
            return;
        } else if (remain == 0) {
            ans.add(new ArrayList<>(tmp));
        } else {
            for (int i = start; i < cand.length; i++) {
                /** skip duplicates */
                if (i > start && cand[i] == cand[i - 1]) continue;
                tmp.add(cand[i]);
                backtrack(ans, tmp, cand, remain - cand[i], i + 1);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}

public class CombinationSum2 {
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
        for (List<Integer> list : nums) {
            sb.append(integerArrayListToString(list));
            sb.append(",");
        }

        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] candidates = stringToIntegerArray(line);
            line = in.readLine();
            int target = Integer.parseInt(line);
            List<List<Integer>> ret = new Solution().combinationSum2(candidates, target);
            String out = int2dListToString(ret);
            System.out.print(out + "\n");
            break;
        }
    }
}
