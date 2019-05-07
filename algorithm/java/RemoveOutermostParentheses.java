import java.io.*;
import java.util.*;
import com.eclipsesource.json.JsonArray;

class Solution {
    /**
     * opened count the number of opened parenthesis.
     * Add every char to the result,
     * unless the first left parenthesis,
     * and the last right parenthesis.
     *
     * Time Complexity:
     * O(N) Time, O(N) space
     **/
    public String removeOuterParentheses(String S) {
        StringBuilder ans = new StringBuilder();
        int opend = 0;
        for (char c : S.toCharArray()) {
            if (c == '(' && opened++ > 0) ans.append(c);
            if (c == ')' && opened-- > 1) ans.append(c);
        }
        return ans.toString();
    }
}

public class RemoveOutermostParentheses {
    /**
     * A valid parentheses string is either empty (""), "(" + A + ")", or A + B, where A and B are valid parentheses strings, and + represents string concatenation.  For example, "", "()", "(())()", and "(()(()))" are all valid parentheses strings.
     * A valid parentheses string S is primitive if it is nonempty, and there does not exist a way to split it into S = A+B, with A and B nonempty valid parentheses strings.
     * Given a valid parentheses string S, consider its primitive decomposition: S = P_1 + P_2 + ... + P_k, where P_i are primitive valid parentheses strings.
     * Return S after removing the outermost parentheses of every primitive string in the primitive decomposition of S.
     *
     * Example 1:
     * Input: "(()())(())"
     * Output: "()()()"
     * Explanation: 
     * The input string is "(()())(())", with primitive decomposition "(()())" + "(())".
     * After removing outer parentheses of each part, this is "()()" + "()" = "()()()".
     *
     * Example 2:
     * Input: "(()())(())(()(()))"
     * Output: "()()()()(())"
     * Explanation: 
     * The input string is "(()())(())(()(()))", with primitive decomposition "(()())" + "(())" + "(()(()))".
     * After removing outer parentheses of each part, this is "()()" + "()" + "()(())" = "()()()()(())".
     *
     * Example 3:
     * Input: "()()"
     * Output: ""
     * Explanation: 
     * The input string is "()()", with primitive decomposition "()" + "()".
     * After removing outer parentheses of each part, this is "" + "" = "".
     *
     **/
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String S = stringToString(line);
            String ret = new Solution().removeOuterParentheses(S);
            String out = (ret);
            System.out.print(out + '\n');
            break;
        }
    }

    private static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }
}
