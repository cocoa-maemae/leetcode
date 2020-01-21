import java.io.*;
import java.util.*;

class Solution {
    public int minFlips(int a, int b, int c) {
		// ^ means XOR
        // If a=2(010),b=6(110),c=5(101), then ab=6(110),equal=3(011)
        int ans = 0, ab = a | b, equal = ab ^ c;
		//System.out.println(Integer.toBinaryString(a));
		//System.out.println(Integer.toBinaryString(b));
		//System.out.println(Integer.toBinaryString(ab));
		//System.out.println(Integer.toBinaryString(equal));
        // int is 32bit
        for (int i = 0; i < 32; ++i) {
            // increments mask by i 1(001), 2(010), 4(100), 8(1000)....
            int mask = 1 << i;
		    // System.out.println(mask);
		    // System.out.println(Integer.toBinaryString(mask));
            // ith bits of a | b and c are not same, need at least 1 flip.
            // If (a|b)^c is 0, a|b and c are equal and equal&mask is always 0, otherwise not equal and we need to check them bit by bit.
			//System.out.println(equal & mask);
            if ((equal & mask) > 0)
                // If a=2,b=6,c=3, then equal=3 and equal & mask is 1,2,0,0.....
                /**
                 * For ith bit of (a|b)^c, use 1 << i as mask to do & operation to check if the bit is 0; if not, ith bits of a|b and c are not same and we need at least 1 flip. There are 3 cases.
				 * i) the ith bit of a|b less than that of c; then ith bit of a|b must be 0, we only need to flip the ith bit of either a or b
				 * ii) the ith bit of a|b bigger than that of c; then ith bit of a|b must be 1, but if only one of a or b's ith bit is 1, we only need to flip one of them
				 * iii) Other case, we need to flip both set bit of a and b, hence need 2 flips.
				 * In short, if ith bits of a|b and c are not same, then only if ith bits of a and b are both 1 and that of c is 0, we need 2 flips; otherwise only 1 flip needed.
                 **/
                // ith bits of a and b are both 1 and that of c is 0?

				// If a=2(10),b=6(110),c=5(101)
                // 10&01=0 == 110&001=0 && 101&001=1 -> +1
                // 10&10=10 == 110&010=10 && 101&010=0 -> +2			
                ans += (a & mask) == (b & mask) && (c & mask) == 0 ? 2 : 1;
        }
        return ans;
    }
}

public class MinimumFlipsToMakeaORbEqualToc {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int a = Integer.parseInt(line);
            line = in.readLine();
            int b = Integer.parseInt(line);
            line = in.readLine();
            int c = Integer.parseInt(line);
            int ret = new Solution().minFlips(a, b, c);
            String out = String.valueOf(ret);
            System.out.print(out + "\n");
			break;
        }
    }
}
