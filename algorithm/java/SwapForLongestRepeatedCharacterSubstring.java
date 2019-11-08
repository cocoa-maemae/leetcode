import com.eclipsesource.json.JsonArray;
import java.io.*;
import java.util.*;

class Solution {
    /**
     * At each char, we will see how far right can we go. Obvioulsy, if it is the same char, we can
     * move forward otherwise we record we saw one diff char by diff++ and proceed. 
     * cnt < dir[cur-'a'] will ensure we have enough cur occurances to proceed when we saw the different char.
     **/
    public int maxRepOpt1(String text) {
        int[] dir = new int[26];
        char[] c = text.toCharArray();
        for (int i = 0; i < c.length; i++) dir[c[i] - 'a']++;
        int max = 0;
        for (int i = 0; i < c.length; i++) {
            char cur = c[i];
            int j = i, cnt = 0, diff = 0;
            while (j < c.length && (cur == c[j] || diff == 0) && cnt < dir[cur - 'a']) {
                System.out.println(cur);
                if (cur != c[j]) ++diff;
                ++cnt;
                ++j;
            }
            max = Math.max(max, cnt);
            System.out.println(max);
        }
        return max;
    }
}

public class SwapForLongestRepeatedCharacterSubstring {
    public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String text = stringToString(line);
            int ret = new Solution().maxRepOpt1(text);
            String out = String.valueOf(ret);
            System.out.print(out + "\n");
            break;
        }
    }
}
