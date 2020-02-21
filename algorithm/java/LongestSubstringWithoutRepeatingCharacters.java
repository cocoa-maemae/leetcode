import java.io.*;
import java.util.*;

class Solution {
    /**
     * Time complexity : O(n). Index j will iterate nnn times.
     * Space complexity (HashMap) : O(min(m,n)). Same as the previous approach.
     * Space complexity (Table): O(m). mmm is the size of the charset.
     **/
    public int getLenOfLongestSubstr(String s) {
        // p means character position index in s
        Map<Character, Integer> p = new HashMap<>(); // current index of character
        int ans = 0;
        for (int i = 0, di = 0; i < s.length(); i++) {
            // update duplicate char index
            if (p.containsKey(s.charAt(i))) {
                /**
                 * If s=abcabcab
                 * i =0,1,2,3,4,5,6,7
                 * di=0,0,0,1,2,3,4,5
                 **/
                di = Math.max(p.get(s.charAt(i)), di);
            }
            // save character and position
            p.put(s.charAt(i), i + 1);
            /**
             * If s=abcabcab
             * i  =0,1,2,3,4,5,6,7
             * ans=1,2,3,3,3,3,3,3
             **/
            // i - di + 1 means the s length of the current index - right_i
            ans = Math.max(ans, i - di + 1);
        }
        return ans;
    }
}

public class LongestSubstringWithoutRepeatingCharacters {
    /**
     * Given abcabcbb, the answer is abc, which the length is 3.
     * Given bbbbb, the answer is b, with the length of 1.
     * Given pwwkew, the answer is wke, with the length of 3. Note that the answer must be a substring, pwke is a subsequence and not a substring.
     **/
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int ret = new Solution().getLenOfLongestSubstr(line);
            String out = String.valueOf(ret);
            System.out.print(out + "\n");
            break;
        }
    }
}
