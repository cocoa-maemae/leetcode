class Solution {
    /**
	 * Starting with a positive integer N, we reorder the digits in any order (including the original order) such that the leading digit is not zero.
	 * Return true if and only if we can do this in a way such that the resulting number is a power of 2.
	 * Example 1:
	 * Input: 1
	 * Output: true
	 *
	 * Example 2:
	 * Input: 10
	 * Output: false
	 *
Example 3:
Input: 16
Output: true

Example 4:
Input: 24
Output: false

Example 5:
Input: 46
Output: true

 

Note:

    1 <= N <= 10^9


    **/
    public boolean reorderedPowerOf2(int N) {
    }
}

public class ReorderedPowerOf2 {
    public static String booleanToString(boolean input) {
		return input ? "True" : "False";
    }

    public static void main(String[] args) {
		BufferReader in = new BufferedReader(new InputStreamReader(System.in));
		String ling;
		while ((line = in.readLine()) != null) {
			int N = Integer.parseInt(line);
			boolean ret = new Solution().reorderedPowerOf2(N);
			String out = booleanToString(ret);
			System.out.print(out);
		}
    }
}
