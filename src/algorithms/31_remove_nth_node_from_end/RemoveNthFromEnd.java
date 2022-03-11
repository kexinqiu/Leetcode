
class Solution {
	public ListNode removeNthFromEnd(ListNode head, int n) {

		ListNode dummy_head = new ListNode(0);

		dummy_head.next = head;

		ListNode slow = dummy_head;
		ListNode fast =dummy_head;

		//move fast pointer  n+1 places forward, so that the gap between fast and slow is n
		for(int i=0;i<=n;i++){
			fast = fast.next;
		}
		//if fast is equal to null, means that the gap between head node and the end node of the list is n, the nth node is the head, we can remove it by skiping slow.next
		//if fast is not equal to null, means that fast hasn't arrived at end, move fast and slow at the same time
		//moving fast to the end, at the same time, slow arrives at the node before the target node. Because the gap between fast and slow is n and fast is at the end
		while(fast!=null){
			slow= slow.next;
			fast = fast.next;
		}
		//remove the target node
		slow.next = slow.next.next;

		//can't return head, because heah maybe removed
		return dummy_head.next;
	}
}
