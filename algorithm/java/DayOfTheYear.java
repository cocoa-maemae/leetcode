import com.eclipsesource.json.JsonArray;
import java.io.*;
import java.util.*;

class Solution {
    int[][] mdays = {
        {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}, // normal year
        {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}, // leap year
    };

    public int dayOfYear(String date) {
        String[] ymd = date.split("-");
        int y = Integer.valueOf(ymd[0]);
        int m = Integer.valueOf(ymd[1]);
        int d = Integer.valueOf(ymd[2]);
        int ans = d; // 日数
        for (int i = 1; i < m; i++) { // 1月〜（m-1)月の日数を加える
            ans += mdays[isLeapYear(y)][i - 1]; // isLeap()は閏年であれば1,平年であれば0
        }
        return ans;
    }

    private int isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? 1 : 0;
    }
}

public class DayOfTheYear {
    public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String date = stringToString(line);
            int ret = new Solution().dayOfYear(date);
            String out = String.valueOf(ret);
            System.out.print(out + "\n");
            break;
        }
    }
}
