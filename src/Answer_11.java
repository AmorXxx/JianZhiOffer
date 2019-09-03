public class Answer_11 {
    public int NumberOf1(int n) {
        int count = 0;
        while(n != 0){
            count = count + (n & 1); //每次判断最低位是否为1
            n = n >>> 1;
        }
        return count;
    }
}

