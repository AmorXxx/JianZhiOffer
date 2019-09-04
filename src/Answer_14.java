import com.sun.deploy.security.SelectableSecurityManager;

import java.util.ArrayList;
import java.util.List;

public class Answer_14 {
    public ListNode FindKthToTail(ListNode head,int k) {
        if (k == 0)return null;
        int status = KthToTail(head, k);
        if (status == 1) {
            return head;
        }else if (status == 3){
            return null;
        }
        return FindKthToTail(head.next, k);
    }
    //探测链表深度
    public int KthToTail(ListNode node, int k){
        if (node == null){
            return 3;
        }
        for (int i = 1; i < k; i++) {
            if (node.next != null){
                node = node.next;
            }else return 3;
            }

        if (node.next == null)
            return 1;
        return 2;
    }
}


class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val) {
        this.val = val;
    }
}
