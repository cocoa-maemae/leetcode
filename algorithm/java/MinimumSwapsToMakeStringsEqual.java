import com.eclipsesource.json.JsonArray;
import java.io.*;
import java.util.*;

class Solution {
    public int minimumSwap(String s1, String s2) {
        int x1 = 0; // number of 'x' in s1 (skip equal chars at same index)
        int y1 = 0; // number of 'y' in s1 (skip equal chars at same index)
        int x2 = 0; // number of 'x' in s2 (skip equal chars at same index)
        int y2 = 0; // number of 'y' in s2 (skip equal chars at same index)
        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if (c1 == c2) { // skip chars that are equal at the same index in s1 and s2
                continue;
            }
            if (c1 == 'x') {
                x1++;
            } else {
                y1++;
            }
            if (c2 == 'x') {
                x2++;
            } else {
                y2++;
            }
        } // end for
        // After skip "c1 == c2", check the number of  'x' and 'y' left in s1 and s2.
        if ((x1 + x2) % 2 != 0 || (y1 + y2) % 2 != 0) {
            return -1; // if number of 'x' or 'y' is odd, we can not make s1 equals to s2
        }
        int swaps = x1 / 2 + y1 / 2 + (x1 % 2) * 2;
        // Cases to do 1 swap:
        // "xx" => x1 / 2 => how many pairs of 'x' we have ?
        // "yy" => y1 / 2 => how many pairs of 'y' we have ?
        //
        // Cases to do 2 swaps:
        // "xy" or "yx" =>  x1 % 2
        return swaps;
    }
}

public class MinimumSwapsToMakeStringsEqual {
    public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s1 = stringToString(line);
            line = in.readLine();
            String s2 = stringToString(line);
            int ret = new Solution().minimumSwap(s1, s2);
            String out = String.valueOf(ret);
            System.out.print(out + "\n");
            break;
        }
    }
}
