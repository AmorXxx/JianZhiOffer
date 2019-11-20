import java.util.Stack;

public class LeetCode_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultHead = new ListNode(0);
        ListNode p1 = l1, p2 = l2, curr = resultHead;
        int temp = 0;
        while (p1 != null || p2 != null){
            int a = (p1 != null) ? p1.val : 0;
            int b = (p2 != null) ? p2.val : 0;
            int sum = a + b + temp;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            temp = sum / 10;
            if (p1 != null)
                p1 = p1.next;
            if (p2 != null)
                p2 = p2.next;
        }
        if (temp > 0){
            curr.next = new ListNode(temp);
        }
        return resultHead.next;
    }
}
