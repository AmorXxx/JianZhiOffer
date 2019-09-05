
import java.util.Stack;

public class Answer_15 {
    public ListNode ReverseList(ListNode head) {
        if (head == null){
            return null;
        }
        Stack<ListNode> stack = new Stack<>();
        //把链表里的数据放进栈
        while (head != null){
            stack.push(head);
            head = head.next;
        }
        head = stack.pop();
        //node 和 head指向同一个对象，所以node.next改变时，head也会改变
        ListNode node = head;
        while (!stack.empty()){
            ListNode pipLine = stack.pop();
            pipLine.next = null;
            node.next = pipLine;
            node = node.next;
        }
        return head;
    }
}
