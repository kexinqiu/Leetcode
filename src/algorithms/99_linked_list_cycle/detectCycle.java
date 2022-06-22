
//1 two pointers
//tc: o(n)
//sc : o(1)

// f是fast所走，s是slow所走， a是入口前长度，b是环状长度
// 第一次相遇所走的路程： f=2s，f=s+nb， 两式相加相减，获得f与b，s与b关系式
//            s=nb ， f=2nb
//已知，f，s每次循环到达入口的路程为 nb+a
//因此相遇后，只需再走a，即可到达入口
//如何确定a的值呢？ 只需两个指针分别从head，以及第一次相遇点同时出发，即可在入口相遇

public class Solution {
	public ListNode detectCycle(ListNode head) {
		if(head==null) return null;

		ListNode slow = head;
		ListNode fast = head;

		while(true){
			if(fast==null || fast.next==null) return null;

			slow = slow.next;
			fast = fast.next.next;

			if(fast==slow) break;
		}

		fast = head;

		while(slow != fast){
			slow = slow.next;
			fast = fast.next;
		}

		return slow;
	}
}

//2.hashset
//tc: o(n)
//sc : o(n)
public class Solution {
	public ListNode detectCycle(ListNode head) {
		Set<ListNode> visited = new HashSet<>();

		ListNode node = head;

		while(node!=null){
			if(visited.contains(node)) return node;

			visited.add(node);
			node = node.next;
		}
		return null;
	}
}