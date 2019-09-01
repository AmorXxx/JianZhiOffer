import java.util.ArrayList;
import java.util.List;

public class Answer_7 {
    public int Fibonacci(int n) {
        List<Integer> fib = new ArrayList<Integer>();
        fib.add(0);
        fib.add(1);
        for (int i = 2; i <= n; i++){
            fib.add(fib.get(i - 1) + fib.get(i - 2));
        }
        return fib.get(n);

    }
}
