class Solution {
    public String generateTheString(int n) {
        /**
         * If n is odd, we return "bbbb....b".
         * If n is even, we return "baaa...a".
         * repeat only within 'ab'
         **/
        return "b" + "ab".substring(n % 2, n % 2 + 1).repeat(n - 1);
    }
}

public class GenerateAStringWithCharactersThatHaveOddCounts {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int n = Integer.parseInt(line);
            String ret = new Solution().generateTheString(n);
            String out = (ret);
            System.out.print(out + "\n");
            break;
        }
    }
}
