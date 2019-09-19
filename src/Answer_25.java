import java.util.HashMap;
import java.util.Map;

public class Answer_25 {
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null)
            return null;
        RandomListNode randomListNode = new RandomListNode(pHead.label);
        //node为新链表的指针
        RandomListNode node = randomListNode;
        //node1为旧链表的指针
        RandomListNode node1 = pHead;
        //map储存新链表中RandomListNode的与旧链表中的对应关系
        Map<RandomListNode, RandomListNode> randomListNodeMap = new HashMap<RandomListNode, RandomListNode>();
        while (node1 != null) {
            if (node1.next != null)
                node.next = new RandomListNode(node1.next.label);
            else node.next = null;
            randomListNodeMap.put(node1, node);
            node1 = node1.next;
            node = node.next;
        }
        //重置指针
        node = randomListNode;
        node1 = pHead;
        while (node1 != null){
            node.random = randomListNodeMap.get(node1.random);
            node = node.next;
            node1 = node1.next;
        }
        return randomListNode;
    }

    public static void main(String[] args) {
        RandomListNode r1 = new RandomListNode(1);
        RandomListNode r2 = new RandomListNode(2);
        RandomListNode r3 = new RandomListNode(3);
        RandomListNode r4 = new RandomListNode(4);
        r1.next = r2;
        r2.next = r3;
        r3.next = r4;
        r1.random = r3;
        r2.random = r1;
        r3.random = r2;
        r4.random = r4;
        Answer_25 a = new Answer_25();
        a.Clone(r1);
    }
}
class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}