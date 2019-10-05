public class Answer_31 {
    public int NumberOf1Between1AndN_Solution(int n) {
        StringBuilder s = new StringBuilder();
        int res = 0;
        for (int i = 1; i <= n; i++){
            s.append(i);
        }
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '1'){
                res++;
            }
        }
        return res;
    }
}
