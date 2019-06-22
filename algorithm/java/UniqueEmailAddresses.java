import com.eclipsesource.json.JsonArray;
import java.io.*;
import java.util.*;


/**
 * I am splitting the string on @ and formatting the local name before adding it to the validEmailList if it is a unique email address. After that, I simply return the size of that list.
 **/
class Solution {
    public int numUniqueEmails(String[] emails) {
        // used to save simplified email address, cost O(n) sapce.
        Set<String> ans = new HashSet<>();
        for (String email : emails) {
            // split into local and domain parts.
            String[] parts = email.split("@");
            // split local by '+'.
            String[] local = parts[0].split("\\+");
            ans.add(
                    local[0].replace(".", "")
                            + "@"
                            + parts[1]); // remove all '.', and concatenate '@' and domain.
        }
        return ans.size();
    }
}

/**
 * Every email consists of a local name and a domain name, separated by the @ sign.
 * For example, in alice@leetcode.com, alice is the local name, and leetcode.com is the domain name.
 * Besides lowercase letters, these emails may contain '.'s or '+'s.
 * If you add periods ('.') between some characters in the local name part of an email address, mail sent there will be forwarded to the same address without dots in the local name.  For example, "alice.z@leetcode.com" and "alicez@leetcode.com" forward to the same email address.  (Note that this rule does not apply for domain names.)
 * If you add a plus ('+') in the local name, everything after the first plus sign will be ignored. This allows certain emails to be filtered, for example m.y+name@email.com will be forwarded to my@email.com.  (Again, this rule does not apply for domain names.)
 * It is possible to use both of these rules at the same time.
 * Given a list of emails, we send one email to each address in the list.  How many different addresses actually receive mails? 
 *
 * Example 1:
 * Input: ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
 * Output: 2
 * Explanation: "testemail@leetcode.com" and "testemail@lee.tcode.com" actually receive mails
 *
 **/
public class UniqueEmailAddresses {
    public static String[] stringToStringArray(String line) {
        JsonArray jsonArray = JsonArray.readFrom(line);
        String[] arr = new String[jsonArray.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = jsonArray.get(i).asString();
        }
        return arr;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String[] emails = stringToStringArray(line);
            int ret = new Solution().numUniqueEmails(emails);
            String out = String.valueOf(ret);
            System.out.print(out + "\n");
            break;
        }
    }
}
