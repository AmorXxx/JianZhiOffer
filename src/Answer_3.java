
import java.util.ArrayList;
import java.util.Stack;

public class Answer_3 {

	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {


		Stack<Integer> stack = new Stack<Integer>();
		while(listNode != null) {

			stack.push(listNode.val);
			listNode = listNode.next;
		}
		ArrayList<Integer> res = new ArrayList<Integer>();
		while(!stack.empty()) {
			res.add(stack.pop());
		}
		return res;

	}

	public class ListNode {
		int val;
		ListNode next = null;
		ListNode(int val) {
			this.val = val;
		}
	}

}
