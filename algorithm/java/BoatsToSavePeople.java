import java.util.*;
import java.io.*;

class Solution {

    /**
     * Time Complexity: O(NlogN), where N is the length of people.
     * Space Complexity: O(N) 
     */
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        //head
        int i = 0;
        //end
        int j = people.length - 1;
        int boatCount = 0;
        while (i <= j) {
            boatCount++;
            if (people[i] + people[j] <= limit) {
                i++;
            }
            j--;
        }
        return boatCount;
    }
}

class BoatsToSavePeople {
    /**
     * Input: people = [1,2], limit = 3
     * Output: 1
     * Explanation: 1 boat (1, 2)
     *
     * Input: people = [3,2,2,1], limit = 3
     * Output: 3
     * Explanation: 3 boats (1, 2), (2) and (3)
     *
     * Input: people = [3,5,3,4], limit = 5
     * Output: 4
     * Explanation: 4 boats (3), (3), (4), (5)
     *
     **/
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] people = strToIntegerArr(line);
            line = in.readLine();
            int limit = Integer.parseInt(line);
            int ret = new Solution().numRescueBoats(people, limit);
            String out = String.valueOf(ret);
            System.out.printf(out + "\n");
            break;
        }
    }

    private static int[] strToIntegerArr(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
          return new int[0];
        }
    
        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }
}
