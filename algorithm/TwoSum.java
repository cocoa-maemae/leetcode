import java.util.*;

class TwoSum {
    /**
     * Given nums = [2, 7, 11, 15], target = 9,
     * Because nums[0] + nums[1] = 2 + 7 = 9,
     * return [0, 1].
     **/
     public static void main(String[] args) {
        int nums[] = {2, 7, 11, 15};
        int target = 9;
        int result[] = twoSum(nums, target);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
     }

     private static int[] twoSum(int[] nums, int target) {
         Map<Integer, Integer> map = new HashMap<>();
         for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
