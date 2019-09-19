import java.io.*;
import java.util.*;
import com.eclipsesource.json.JsonArray;

class Solution {
    public int maxNumberOfBalloons(String text) {
        int cnt[] = new int[26];
        for (int i = 0; i < text.length(); i++) {
            cnt[text.charAt(i) - 'a']++;
        }
        int ans = cnt[1]; // for b
        ans = Math.min(ans, cnt[0]); // for a
        ans = Math.min(ans, cnt[11] / 2); // for l /2
        ans = Math.min(ans, cnt[14] / 2); // similarly for o/2
        ans = Math.min(ans, cnt[13]); // for n
        return ans;
    }
}

public class MaximumNumberOfBalloons {
    public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String text = stringToString(line);
            int ret = new Solution().maxNumberOfBalloons(text);
            String out = String.valueOf(ret);
            System.out.print(out + "\n");
            break;
        }
    }
}
