import java.io.*;
import java.util.*;
import com.eclipsesource.json.JsonArray;

class Solution {
    public List<String> commonChars(String[] A) {
        // Common characters dictionary
        int[] dict = new int[26];
        for (int j = 0; j < A[0].length(); j++) {
            // A[0].charAt(j) - 'a' means integer diff of alphabet, set 1 as value. If same char exist, increment 2, 3 ...
            dict[A[0].charAt(j) - 'a']++;
        }
        for (int i = 1; i < A.length; i++) {
            // Dictionary of the current word
            int[] cw = new int[26];
            for (int j = 0; j < A[i].length(); j++) {
                // A[0].charAt(j) - 'a' means integer diff of alphabet, set 1 as value
                cw[A[i].charAt(j) - 'a']++;
            }
            // Update the common dictionary
            for (int j = 0; j < 26; j++) {
                // compare value. value is 1 or 0.
                if (cw[j] < dict[j]) {
                    // assume 0 < 1, 1 < 2...
                    // if 0 < 1, the word includes only in dict[j]
                    // if 1 < more than 2, the word includes in both cw[j] and dict[j], but dict[j] is more than cw[j]
                    dict[j] = cw[j];
                }
            }
        }

        List<String> ans = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            // dict[i] is 0 or 1.
            for (int j = 0; j < dict[i]; j++) {
                // when dict[i] is 1, go through here.
                ans.add(Character.toString((char) ('a' + i)));
            }
        }
        return ans;
    }
}

/**
 * Given an array A of strings made only from lowercase letters, return a list of all characters
 * that show up in all strings within the list (including duplicates). For example, if a character
 * occurs 3 times in all strings but not 4 times, you need to include that character three times in
 * the final answer. You may return the answer in any order.
 *
 * <p>Example 1: Input: ["bella","label","roller"] Output: ["e","l","l"]
 *
 * <p>Example 2: Input: ["cool","lock","cook"] Output: ["c","o"]
 */
public class FindCommonCharacters {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String[] A = stringToStringArray(line);
            List<String> ret = new Solution().commonChars(A);
            String out = stringListToString(ret);
            System.out.print(out + '\n');
            break;
        }
    }

    private static String[] stringToStringArray(String line) {
        JsonArray jsonArray = JsonArray.readFrom(line);
        String[] arr = new String[jsonArray.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = jsonArray.get(i).asString();
        }
        return arr;
    }

    private static String stringListToString(List<String> stringList) {
        StringBuilder sb = new StringBuilder("[");
        for (String item : stringList) {
            sb.append(item);
            sb.append(",");
        }

        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }
}
