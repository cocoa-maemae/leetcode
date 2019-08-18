import com.eclipsesource.json.JsonArray;
import java.io.*;
import java.util.*;

class Solution {
    public int maxRepOpt1(String text) {
        int[] count = new int[26];
        int[] newCount = new int[26];
        for (char c : text.toCharArray()) {
            newCount[c - 'a']++;
        }
        int start = 0, maxCount = 0, maxLength = 0;
        for (int end = 0; end < text.length(); end++) {
            maxCount = Math.max(maxCount, ++count[text.charAt(end) - 'a']);
            while (end - start + 1 - maxCount > 1
                    || end - start + 1 > newCount[text.charAt(start) - 'a']) {
                count[text.charAt(start) - 'a']--;
                start++;
                maxCount = 0;
                for (int i = 0; i < 26; i++) {
                    if (maxCount < count[i]) {
                        maxCount = count[i];
                    }
                }
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
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
