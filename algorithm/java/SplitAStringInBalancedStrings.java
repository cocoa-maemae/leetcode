import com.eclipsesource.json.JsonArray;
import java.io.*;
import java.util.*;

class Solution {
    public int balancedStringSplit(String s) {
        int cnt = 0;
        int ans = 0;
        for (char c : s.toCharArray()) {
            cnt += (c == 'L') ? 1 : -1;
            if (cnt == 0) ans++;
        }
        return ans;
    }
}

public class SplitAStringInBalancedStrings {
    public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);
            int ret = new Solution().balancedStringSplit(s);
            String out = String.valueOf(ret);
            System.out.print(out + "\n");
            break;
        }
    }
}
