public class Answer_6 {
    public int minNumberInRotateArray(int [] array) {
        int n = array.length;
        if(n == 0){
            return 0;
        }
        for (int i = 0; i < n - 1; i++){
            if (array[i] > array[i + 1]){
                return array[i + 1];
            }
        }
        return array[0];
    }
}
