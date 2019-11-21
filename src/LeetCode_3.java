import java.util.HashMap;
import java.util.HashSet;

public class LeetCode_3 {
    public int lengthOfLongestSubstring(String s) {
        int max = Integer.MIN_VALUE;
        int pre = 0;
        int cur = 0;
        HashSet set = new HashSet();
        while (pre < s.length() && cur < s.length()){
            if (!set.contains(s.charAt(cur))){
                set.add(s.charAt(cur++));
                max = Math.max(max, cur - pre);
            }
            else {
                set.remove(s.charAt(pre++));
            }
        }
        return max;

    }
}
