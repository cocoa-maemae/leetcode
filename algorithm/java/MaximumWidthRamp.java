import java.util.*;
import java.io.*;

class Solution {
	/**
	 * For all elements like A[i] = v, let's write the indices i in sorted order of their values v. For example with A[0] = 7, A[1] = 2, A[2] = 5, A[3] = 4, we can write the order of indices i=1, i=3, i=2, i=0.
	 *
	 * Then, whenever we write an index i, we know there was a ramp of width i - min(indexes_previously_written) (if this quantity is positive). We can keep track of the minimum of all indexes previously written as m.
	 *
	 **/
    public int maxWidthRamp(int[] A) {
        int N = A.length;
		// indexes of A
        Integer[] B = new Integer[N];
        for (int i = 0; i < N; ++i) {
            B[i] = i;
System.out.println(B[i]);
		}
System.out.println("\n");

		/**
		 * order B[] by asc
         **/
		// Arrays.sort(B, new Comparator<Integer>() {
        //     @Override
		//     public int compare(int i, int j) {
		//         return ((Integer) A[i]).compareTo(A[j]));
		//     }
		//);
        Arrays.sort(B, (i, j) -> ((Integer) A[i]).compareTo(A[j]));
        int ans = 0;
        int m = N;
        for (int i : B) {
            ans = Math.max(ans, i - m);
			// fix the minimum value here
            m = Math.min(m, i);
        }
        return ans;
    }
}

public class MaximumWidthRamp {
    /**
     * Given an array A of integers, a ramp is a tuple (i, j) for which i < j and A[i] <= A[j].  The width of such a ramp is j - i.
	 * Find the maximum width of a ramp in A.  If one doesn't exist, return 0.
	 *
	 *  Example 1:
	 *  Input: [6,0,8,2,1,5]
	 *  Output: 4
	 *  Explanation: 
	 *  The maximum width ramp is achieved at (i, j) = (1, 5): A[1] = 0 and A[5] = 5.
	 *
	 *  Example 2:
	 *  Input: [9,8,1,0,1,9,4,0,4,1]
	 *  Output: 7
	 *  Explanation: 
	 *  The maximum width ramp is achieved at (i, j) = (2, 9): A[2] = 1 and A[9] = 1.
	 *
	 *   Note:
	 *   2 <= A.length <= 50000
	 *   0 <= A[i] <= 50000
     **/
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] A = stringToIntegerArray(line);
            int ret = new Solution().maxWidthRamp(A);
            String out = String.valueOf(ret);
            System.out.print(out + '\n');
			break;
        }
    }

    private static int[] stringToIntegerArray(String input) {
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
}
