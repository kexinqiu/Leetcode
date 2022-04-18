class Solution {
	public ListNode sortList(ListNode head) {
		//base case
		if (head == null || head.next == null)
			return head;

		// step 1. cut the list to two halves
		//prev will be the end of the first half
		//slow will be the head of next half
		//fast will be the end of next half
		ListNode prev = null;
		ListNode slow = head;
		ListNode fast = head;

		//when fast is equal to null, slow will be in the middle of the list
		while (fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}

		prev.next = null;

		// step 2. sort each half
		ListNode left_side = sortList(head);
		ListNode right_side = sortList(slow);

		// step 3. merge l1 and l2
		return merge(left_side, right_side);
	}

	ListNode merge(ListNode left_side, ListNode right_side) {
		ListNode sorted_tmp = new ListNode(0);
		ListNode current = sorted_tmp;

		while (left_side != null && right_side != null) {
			if (left_side.val < right_side.val) {
				current.next = left_side;
				left_side = left_side.next;
			} else {
				current.next = right_side;
				right_side = right_side.next;
			}
			current = current.next;
		}

		if (left_side != null)
			current.next = left_side;

		if (right_side != null)
			current.next = right_side;

		return sorted_tmp.next;
	}
}