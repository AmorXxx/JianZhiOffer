public class Answer_16 {
    public ListNode Merge(ListNode list1, ListNode list2) {

        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode listNode = new ListNode(-1);
        //创建三个链表的指针
        ListNode p0 = listNode;
        ListNode p1 = list1;
        ListNode p2 = list2;
        while (p1 != null && p2 != null) {
            if (p1.val > p2.val) {
                p0.next = p2;
                p2 = p2.next;
            } else {
                p0.next = p1;
                p1 = p1.next;
            }
            p0 = p0.next;
        }
        while (p1 != null) {
            p0.next = p1;
            p1 = p1.next;
            p0 = p0.next;
        }
        while (p2 != null) {
            p0.next = p2;
            p2 = p2.next;
            p0 = p0.next;
        }
        return listNode.next;
    }
}
