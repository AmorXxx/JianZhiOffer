import java.util.Arrays;

public class Answer_30 {
    public int FindGreatestSumOfSubArray(int[] array) {
        int max = Integer.MIN_VALUE;
        for (int right = 0; right < array.length; right++){
            for (int i = 0; i <= right; i++){
                int temp = SumOfSubArray(Arrays.copyOfRange(array, i, right + 1));
                if (temp > max)
                    max = temp;
            }
        }
        return max;
    }
    private int SumOfSubArray(int[] array){
        if (array.length == 0){
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < array.length; i++){
            sum += array[i];
        }
        return sum;
    }
}
