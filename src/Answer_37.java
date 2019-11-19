import java.util.Arrays;

public class Answer_37 {
    public int GetNumberOfK(int[] array, int k) {
        int index = Arrays.binarySearch(array, k);
        if (index < 0)
            return 0;
        int sum = 1;
        for (int i = index + 1; i < array.length && array[i] == k; i++)
            sum++;
        for (int i = index - 1; i >= 0 && array[i] == k; i--)
            sum++;
        return sum;
    }
}
