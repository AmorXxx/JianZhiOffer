public class Answer_9 {
    public int JumpFloorII(int target) {
        int[] array = new int[target];
        array[0] = 1;
        for (int i = 0; i < target; i++){
            int sum = 0;
            for (int j = i - 1; j >= 0; j--){
                sum += array[j];
            }
            array[i] = sum + 1;
        }
        return array[target - 1];
    }
}
