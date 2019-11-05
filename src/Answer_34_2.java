import java.util.HashMap;
import java.util.Map;

public class Answer_34_2 {
    public int FirstNotRepeatingChar(String str) {
        int min = Integer.MAX_VALUE;
        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if (map.containsKey(c)){
                map.put(c, map.get(c).replace('t', 'f'));
            } else {
                map.put(c, "t " + i);
                }
            }
        for (Map.Entry<Character, String> entry : map.entrySet()) {
            String value = entry.getValue();
            if (value.charAt(0) == 't' && Integer.valueOf(value.split(" ")[1]) < min){
                    min = Integer.valueOf(value.split(" ")[1]);
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
        }

    }
