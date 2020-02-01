import com.eclipsesource.json.JsonArray;
import java.io.*;
import java.util.*;

class Solution {
    public String reverseParentheses(String s) {
        Deque<StringBuilder> dq = new ArrayDeque<>();
        dq.push(new StringBuilder()); // In case the first char is NOT '(', need an empty
        // StringBuilder.
        for (char c : s.toCharArray()) {
            // dump
            System.out.println(Arrays.toString(dq.toArray()));
            // need a new StringBuilder to save substring in brackets pair
            if (c == '(') {
                // refer the last and push StringBuilder()
                dq.offer(new StringBuilder());
                // found a matched brackets pair and reverse the substring between them
            } else if (c == ')') {
                // pull the last element
                StringBuilder end = dq.pollLast();
                // refer the end of the first element and append the reversed 
                dq.peekLast().append(end.reverse());
            } else { 
                // append the char to the end of the first element.
                /**
                 * E.g.
                 * input=(abcd)
                 * dq.peekLast().toString() = a, ab, abc, abcd
                 **/
                dq.peekLast().append(c);
            }
        }
        return dq.pollLast().toString();
    }
}

public class ReverseSubstringsBetweenEachPairOfParentheses {
    public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);
            String ret = new Solution().reverseParentheses(s);
            String out = (ret);
            System.out.print(out + "\n");
            break;
        }
    }
}
