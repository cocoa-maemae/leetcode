class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[] min = new int[m], max = new int[n];
        Arrays.fill(min, Integer.MAX_VALUE);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Greedy. Find minimum and maxmium values for each row and each column, respectively
                min[i] = Math.min(matrix[i][j], min[i]);
                max[j] = Math.max(matrix[i][j], max[j]);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                if (min[i] == max[j]) 
                    ans.add(min[i]);
        return ans;     
    }
}

public class LuckyNumbersInAMatrix {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
          return new int[0];
        }
    
        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
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
    
    public static String integerArrayListToString(List<Integer> nums, int length) {
        if (length == 0) {
            return "[]";
        }
    
        String result = "";
        for(int index = 0; index < length; index++) {
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
            int[][] matrix = stringToInt2dArray(line);
            List<Integer> ret = new Solution().luckyNumbers (matrix);
            String out = integerArrayListToString(ret);
            System.out.print(out + "\n");
            break;
        }
    }
}
