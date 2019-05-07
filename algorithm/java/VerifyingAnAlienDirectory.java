import java.io.*;
import java.util.*;
import com.eclipsesource.json.JsonArray;

class Solution {
    private int[] dict = new int[26];
    /**
     * Build a transform dict from order,
     * Find all alien words with letters in normal order.
     * For example, if we have order = "xyz..."
     * We can map the word "xyz" to "abc" or "123"
     * Then we check if all words are in sorted order.
     * Time complexity: O(NS)
     **/
    public boolean isAlienSorted(String[] words, String order) {
        for (int i = 0; i < order.length(); i++) {
            // set 0, 1, 2...
            dict[order.charAt(i) - 'a'] = i;
        }
        for (int i = 1; i < words.length; i++) {
            if (compare(words[i - 1], words[i]) > 0) {
                return false;
            }
        }
        return true;
    }

    private int compare(String s1, String s2) {
        int n = s1.length(), m = s2.length(), cmp = 0;
        for (int i = 0, j = 0; i < n && j < m && cmp == 0; i++, j++) {
            // increment both words by one character.
            cmp = dict[s1.charAt(i) - 'a'] - dict[s2.charAt(j) - 'a'];
            System.out.println("s1");
            System.out.println(dict[s1.charAt(i) - 'a']);
            System.out.println("s2");
            System.out.println(dict[s2.charAt(j) - 'a']);
        }
        return cmp == 0 ? n - m : cmp;
    }
}

public class VerifyingAnAlienDirectory {
    /**
     * In an alien language, surprisingly they also use english lowercase letters, but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.

     *
     * Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if the given words are sorted lexicographically in this alien language.
     *
     * Example 1:
     * Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
     * Output: true
     * Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
     *
     * Example 2:
     * Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
     * Output: false
     * Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.
     *
     * Example 3:
     * Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
     * Output: false
     * Explanation: The first three characters "app" match, and the second string is shorter (in size.) According to lexicographical rules "apple" > "app", because 'l' > '∅', where '∅' is defined as the blank character which is less than any other character (More info).
     *
     **/
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        while ((line = in.readLine()) != null) {
            String[] words = stringToStringArray(line);
            line = in.readLine();
            String order = stringToString(line);
            boolean ret = new Solution().isAlienSorted(words, order);
            System.out.println(ret);
            System.out.println('\n');
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

    private static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }

    private static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }
}
