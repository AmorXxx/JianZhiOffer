import java.util.EmptyStackException;
import java.util.Stack;

/**
 * 该类是剑指Offer14题第二种解法
 */
public class Answer_14_2 {
    public ListNode FindKthToTail(ListNode head,int k) {
        if (head == null || k == 0) {
            return null;
        }
        Stack<ListNode> stack = new Stack<>();
        while (head != null){
            stack.push(head);
            head = head.next;
        }
        ListNode result = null;
        try {
            for (int i = 0; i < k; i++) {
                result = stack.pop();
            }
        }catch (EmptyStackException e){
            return null;
        }
        return result;
    }
}

