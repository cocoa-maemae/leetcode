class Solution {
    public List<String> printVertically(String s) {
        /**
         * If s="TO BE OR NOT TO BE"
         * words={"TO","BE","OR","NOT","TO","BE"}
         **/
        String[] words = s.split(" ");
        int maxLen = 0;
        for (int i = 0; i < words.length; ++i) {
            maxLen = Math.max(maxLen, words[i].length());
        }
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < maxLen; ++i) {
            StringBuilder sb = new StringBuilder();
            /**
             * If words={"TO","BE","OR","NOT","TO","BE"}
             * w=TO,BE,OR,NOT,TO,BE, so sb.append=>T,B,O,N,T,B,O,E,R,O,O,O,E(w.charAt(i))," "," "," ",T," "," "
             **/
            for (String w : words) {
                sb.append(i < w.length() ? w.charAt(i) : " ");
            }
            // Must remove the end spaces
            while (sb.charAt(sb.length() - 1) == ' ') {
                // remove trailing space
                sb.deleteCharAt(sb.length() - 1);
            }
            ans.add(sb.toString());
        }
        return ans;
    }
}

public class MainClass {
    public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }

    public static String stringListToString(List<String> stringList) {
        StringBuilder sb = new StringBuilder("[");
        for (String item : stringList) {
            sb.append(item);
            sb.append(",");
        }
        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);
            List<String> ret = new Solution().printVertically(s);
            String out = stringListToString(ret);
            System.out.print(out + "\n");
            break;
        }
    }
}
