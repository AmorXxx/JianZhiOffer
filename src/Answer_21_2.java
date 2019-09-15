import java.util.Stack;

public class Answer_21_2 {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack = new Stack<>();
        if (pushA.length == 0 || popA.length == 0)
            return false;
        int popIndex = 0;
        for (int i = 0; i < popA.length; i++){
            stack.push(pushA[i]);
            while (!stack.empty() && stack.peek() == popA[popIndex]){
                stack.pop();
                popIndex++;
            }
        }
        return stack.empty();
    }
}
