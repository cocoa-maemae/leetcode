import java.io.*;
import java.util.*;

class Solution {
    /**
     * Time Complexity: O(M+N), where M,N are the lengths of A and B respectively.
     * Space Complexity: O(M+N), the space used by count
     **/
    public String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> count = new HashMap<String, Integer>();
        for (String word: A.split("\\s")) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        for (String word: B.split("\\s")) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        List<String> ans = new LinkedList<String>();
        for (String word: count.keySet()) {
            if (count.get(word) == 1) {
                ans.add(word);
            }
        }
        return ans.toArray(new String[ans.size()]);
    }
}

class UncommonWordsFromTwoSentences {
    /**
     * We are given two sentences A and B.  (A sentence is a string of space separated words.  Each word consists only of lowercase letters.)
     * A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.
     * Return a list of all uncommon words. 
     * You may return the list in any order.
     *
     * Example 1:
     * Input: A = "this apple is sweet", B = "this apple is sour"
     * Output: ["sweet","sour"]
     *
     * Input: A = "apple apple", B = "banana"
     * Output: ["banana"]
     *
     **/
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line = null, A = null, B = null;
        while ((line = in.readLine()) != null) {
            A = line;
            B = in.readLine();
            break;
        }
        String[] ans = new Solution().uncommonFromSentences(A, B);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }
}
