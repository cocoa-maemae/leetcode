import java.io.*;
import java.util.*;
import com.eclipsesource.json.JsonArray;


class Solution {
    public String alphabetBoardPath(String target) {
        int x = 0, y = 0;
        StringBuilder sb = new StringBuilder();
        for (char ch : target.toCharArray()) {
            int x1 = (ch - 'a') % 5, y1 = (ch - 'a') / 5;
            sb.append(
                    String.join("", Collections.nCopies(Math.max(0, y - y1), "U"))
                            + String.join("", Collections.nCopies(Math.max(0, x1 - x), "R"))
                            + String.join("", Collections.nCopies(Math.max(0, x - x1), "L"))
                            + String.join("", Collections.nCopies(Math.max(0, y1 - y), "D"))
                            + "!");
            x = x1;
            y = y1;
        }
        return sb.toString();
    }
}

public class AlphabetBoardPath {
    public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String target = line;
            String ret = new Solution().alphabetBoardPath(target);
            String out = (ret);
            System.out.print(out + "\n");
            break;
        }
    }
}
