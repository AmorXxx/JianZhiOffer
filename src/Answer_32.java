public class Answer_32 {
    public String PrintMinNumber(int [] numbers) {
            for (int i = 0; i < numbers.length; i++) {
                for (int j = i + 1; j < numbers.length; j++){
                    StringBuilder sb = new StringBuilder();
                    sb.append(numbers[i]);
                    sb.append(numbers[j]);
                    String oldNum = new String(sb);
                    StringBuilder sb1 = new StringBuilder();
                    sb1.append(numbers[j]);
                    sb1.append(numbers[i]);
                    String newNum = new String(sb1);
                    if (Long.valueOf(newNum) < Long.valueOf(oldNum)) {
                        int temp = numbers[j];
                        numbers[j] = numbers[i];
                        numbers[i] = temp;
                    }
                }
            }


        StringBuilder sb = new StringBuilder();
        for (int m = 0; m < numbers.length; m++){
            sb.append(numbers[m]);
        }
        return new String(sb);
    }
}
