//tc:o(n)

class Solution {
	public ListNode reverseBetween(ListNode head, int left, int right) {
		if(head==null) return head;
		// 定义一个dummyHead, 方便处理
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		// 初始化指针
		ListNode prev = dummy;
		ListNode pointer = dummy.next;
		// 将指针移到相应的位置
		//prev 反转node前一个node
		//pointer 第一个反转node
		for(int i=0;i<left-1;i++){
			prev = prev.next;
			pointer = pointer.next;
		}
		//不断往prev和pointer之间插入
		for(int i=0;i<right-left;i++){
			ListNode next_node=pointer.next;
			pointer.next = pointer.next.next;

			next_node.next = prev.next;
			prev.next = next_node;
		}
		return dummy.next;
	}
}