import java.io.*;
import java.util.*;
import com.eclipsesource.json.JsonArray;

class Solution {
    public int maxLength(List<String> arr) {
        List<Integer> dp = new ArrayList<>();
        dp.add(0);
        int ans = 0;
        for (String s : arr) {
            int a = 0, dup = 0;
            for (char c : s.toCharArray()) {
                dup |= a & (1 << (c - 'a'));
                a |= 1 << (c - 'a');
            }
            if (dup > 0) continue;
            for (int i = dp.size() - 1; i >= 0; --i) {
                if ((dp.get(i) & a) > 0) continue;
                dp.add(dp.get(i) | a);
                ans = Math.max(ans, Integer.bitCount(dp.get(i) | a));
            }
        }
        return ans;
    }
}

public class MaximumLengthOfAConcatenatedStringWithUniqueCharacters {
    public static List<String> stringToStringList(String line) {
        JsonArray jsonArray = JsonArray.readFrom(line);
        String[] arr = new String[jsonArray.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = jsonArray.get(i).asString();
        }
        List<String> list = new ArrayList<>();
        for (String s : arr) {
            list.add(s);
        }
        return list;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            List<String> arr = stringToStringList(line);
            int ret = new Solution().maxLength(arr);
            String out = String.valueOf(ret);
            System.out.print(out + "\n");
            break;
        }
    }
}
