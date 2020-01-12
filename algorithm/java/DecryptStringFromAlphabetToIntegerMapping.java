import com.eclipsesource.json.JsonArray;
import java.io.*;
import java.util.*;

class Solution {
    public String freqAlphabets(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i + 2 < s.length() && s.charAt(i + 2) == '#') {
                sb.append((char) ((Integer.parseInt(s.substring(i, i + 2)) - 1) + 'a'));
                i = i + 2;
            } else {
                sb.append((char) ((Integer.parseInt(String.valueOf(s.charAt(i))) - 1) + 'a'));
            }
        }
        return sb.toString();
    }
}

public class DecryptStringFromAlphabetToIntegerMapping {
    public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);
            String ret = new Solution().freqAlphabets(s);
            String out = (ret);
            System.out.print(out + "\n");
            break;
        }
    }
}
