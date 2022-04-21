//brute force
//o(nlogn) sort->o(nlogn)
class Solution {
	public ListNode mergeKLists(ListNode[] lists) {
		List<Integer> l = new ArrayList<Integer>();
		//collect all values into one list
		for (ListNode ln : lists) {
			while (ln != null) {
				l.add(ln.val);
				ln = ln.next;
			}
		}
		//sort
		Collections.sort(l);
		//store elements into a ListNode
		ListNode head = new ListNode(0);
		ListNode h = head;
		for (int i : l) {
			ListNode t = new ListNode(i);
			h.next = t;
			h = h.next;
		}
		h.next = null;
		return head.next;
	}
}

//priorityqueue
//o(nlogk) k is the number of linked lists; n is the total number of nodes in list.
class Solution {
	public ListNode mergeKLists(ListNode[] lists) {
		PriorityQueue<ListNode> queue = new PriorityQueue<>(new The_Comparator());
		//PriorityQueue queue = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);

		for(ListNode ln : lists){
			if(ln!=null){
				queue.add(ln);
			}
		}

		ListNode res = new ListNode(0);
		ListNode curr = res;
		while(!queue.isEmpty()){
			curr.next=queue.poll();
			curr = curr.next;
			//check if the ListNode is empty
			ListNode next = curr.next;
			if(next!=null)
				queue.add(next);
		}
		return res.next;
	}
}

class The_Comparator implements Comparator<ListNode>{
	public int compare(ListNode l1, ListNode l2){
		return l1.val-l2.val;
	}
}

//merge one by one
//o(kn)
class Solution {
	public ListNode mergeKLists(ListNode[] lists) {
		if(lists==null||lists.length==0) return null;
		if(lists.length==1) return lists[0];

		ListNode head = merge(lists[0], lists[1]);

		for(int i=2;i<lists.length;i++){
			head = merge(head, lists[i]);
		}
		return head;
	}

	private ListNode merge(ListNode left_side, ListNode right_side){
		ListNode sorted = new ListNode(0);
		ListNode current = sorted;

		while(left_side!=null && right_side!=null){
			if (left_side.val < right_side.val) {
				current.next = left_side;
				left_side = left_side.next;
			} else {
				current.next = right_side;
				right_side = right_side.next;
			}
			current = current.next;
		}
		//add the rest node
		if (left_side != null)
			current.next = left_side;

		if (right_side != null)
			current.next = right_side;

		return sorted.next;
	}
}


//mergesort with divide and conquer
//o(nlogk) k is number of linked list, n is the total number of nodes in two lists.
//We can merge two sorted linked list in O(n)time where n is the total number of nodes in two lists.
class Solution {
	public ListNode mergeKLists(ListNode[] lists) {
		if(lists==null||lists.length==0) return null;
		if(lists.length==1) return lists[0];

		int interval = 1;
		while(interval<lists.length){

			for (int i = 0; i + interval< lists.length; i=i+interval*2) {
				lists[i]=merge(lists[i],lists[i+interval]);
			}
			interval*=2;
		}

		return lists[0];

	}

	private ListNode merge(ListNode left_side, ListNode right_side){
		ListNode sorted = new ListNode(0);
		ListNode curr = sorted;

		while(left_side!=null && right_side!=null){
			if (left_side.val < right_side.val) {
				curr.next = left_side;
				left_side = left_side.next;
			} else {
				curr.next = right_side;
				right_side = right_side.next;
			}
			curr = curr.next;
		}
		//add the rest node
		if (left_side != null)
			curr.next = left_side;

		if (right_side != null)
			curr.next = right_side;

		return sorted.next;
	}
}


