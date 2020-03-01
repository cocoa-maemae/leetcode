import java.io.*;
import java.util.*;
import com.eclipsesource.json.JsonArray;

class Solution {
    public int minSteps(String s, String t) {
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            // count the occurrences of chars in s.
            ++cnt[s.charAt(i) - 'a'];
            // compute the difference between s and t.
            --cnt[t.charAt(i) - 'a'];
        }
        // sum the absolute of difference and divide it by 2.
        // return Arrays.stream(cnt).map(Math::abs).sum() / 2;
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > 0) {
                ans += cnt[i];
            }
        }
        return ans;
    }
}

public class MinimumNumberOfStepsToMakeTwoStringsAnagram {
    public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);
            line = in.readLine();
            String t = stringToString(line);
            int ret = new Solution().minSteps(s, t);
            String out = String.valueOf(ret);
            System.out.print(out + "\n");
            break;
        }
    }
}
