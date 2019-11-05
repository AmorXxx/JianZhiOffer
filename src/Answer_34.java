import java.util.*;

public class Answer_34 {
    public int FirstNotRepeatingChar(String str) {
        int min = Integer.MAX_VALUE;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
        }
        if (map.isEmpty())
            return -1;
        for (Map.Entry<Character, Integer> entry: map.entrySet()
             ) {
            if(entry.getValue() == 1){
                int i = str.lastIndexOf(entry.getKey());
                if (i < min)
                    min = i;
            }
        }
        return min;
    }
}
