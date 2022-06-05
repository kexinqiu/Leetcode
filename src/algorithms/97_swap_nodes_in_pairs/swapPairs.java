

//tc: O(N)

//iteration
class Solution {
	public ListNode swapPairs(ListNode head) {
		//add a dummy node
		ListNode dummy = new ListNode(0);
		dummy.next = head;

		ListNode prev = dummy;
		ListNode curr = head;

		while(curr!=null && curr.next!=null){
			//keep the next node as the first node of next pair
			ListNode next = curr.next.next;

			//swapping
			prev.next = curr.next;
			curr.next.next = curr;
			curr.next = next;

			// Reinitializing the head and prevNode for next swap
			prev = curr;
			curr = curr.next;
		}
		return dummy.next;
	}
}

//recursion
//recurse until the tail null node. swap the last first and last second. and then return the last new list and repeat.
class Solution {
	public ListNode swapPairs(ListNode head) {

		//base case
		if(head==null || head.next==null)
			return head;

		//nodes to be swapped
		ListNode firstNode = head;
		ListNode secondNode = head.next;

		//swapping
		firstNode.next = swapPairs(secondNode.next);
		secondNode.next = firstNode;

		//now the head is the second node
		return secondNode;
	}
}