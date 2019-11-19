public class Answer_36 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode node1 = pHead1;
        ListNode node2 = pHead2;
        while (node1 != null){
            node2 = pHead2;
            while (node2 != null){
                if (node2 == node1)
                    return node2;
                node2 = node2.next;
            }
            node1 = node1.next;
        }
        return null;
    }
}
