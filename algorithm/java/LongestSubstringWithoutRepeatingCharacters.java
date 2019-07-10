import java.io.*;
import java.util.*;

class Solution {
    /**
     * Time complexity : O(n). Index j will iterate nnn times.
     * Space complexity (HashMap) : O(min(m,n)). Same as the previous approach.
     * Space complexity (Table): O(m). mmm is the size of the charset.
     **/
    public int getLenOfLongestSubstr(String s) {
        int ans = 0;

        // sliding window
        // try to extend the range [i, j]
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        for (int j = 0, i = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
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
