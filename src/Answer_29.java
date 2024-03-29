import java.util.ArrayList;
        import java.util.Arrays;

public class Answer_29 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (input.length == 0)
            return list;
        if (k > input.length)
            return list;
        Arrays.sort(input);
        for (int i = 0; i < k; i++){
            list.add(input[i]);
        }
        return list;
    }
}
