import java.util.HashMap;
import java.util.Map;

public class Answer_28 {
    public int MoreThanHalfNum_Solution(int [] array) {
        int len = array.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++){
            map.put(array[i], map.containsKey(array[i]) ? map.get(array[i]) + 1 : 1);
        }
        for (Integer val: map.keySet()
             ) {
            if (map.get(val) > len / 2)
                return val;
        }
        return 0;
    }
}
