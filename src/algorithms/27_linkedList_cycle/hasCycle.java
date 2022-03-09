public class Solution {
	public boolean hasCycle(ListNode head) {
		//check if the linklist is empty
		if(head==null) return false;
		//two pointers, the slow pointer traverses one node once, the fast pointer traverse two nodes once
		ListNode slow = head;
		ListNode fast = head.next;
		//if both fast and fast.next are not null, means that there are nodes left, then keeping traversing
		while(fast!=null && fast.next!=null){
			//if slow equals fast, means that there is a cycle
			if(slow == fast){
				return true;
			}
			//slow traverses one step once
			slow = slow.next;
			//fast traverses two steps once
			fast = fast.next.next;

		}
		return false;
	}
}