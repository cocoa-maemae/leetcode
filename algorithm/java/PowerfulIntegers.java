import java.io.*;
import java.util.*;

class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> set = new HashSet<Integer>();
        for (int m = 1; m <= bound; m *= x) {
            for (int n = 1; m + n <= bound; n *= y) {
                set.add(m + n);
                if (y == 1) break;
            }
            if (x == 1) break;
        }
        return new ArrayList<Integer>(set);
    }
}

public class PowerfulIntegers {
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
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int x = Integer.parseInt(line);
            line = in.readLine();
            int y = Integer.parseInt(line);
            line = in.readLine();
            int bound = Integer.parseInt(line);
            List<Integer> ret = new Solution().powerfulIntegers(x, y, bound);
            String out = integerArrayListToString(ret);
            System.out.print(out + '\n');
            break;
        }
    }
}
