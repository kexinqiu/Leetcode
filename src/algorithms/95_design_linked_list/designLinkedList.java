//sigle linked list


class MyLinkedList {

	class ListNode{
		int val;
		ListNode next;

		public ListNode(int val){
			this.val = val;
		}
	}

	int size;
	//虚拟头结点 sentinel head
	ListNode head;

	public MyLinkedList() {
		size = 0;
		head = new ListNode(0);
	}

	public int get(int index) {
		//if index is invalid, return -1
		if(index<0||index>=size) return -1;

		ListNode curr = head;
		//include a sentinel head, so iterate untill index+1
		for(int i=0;i<=index;i++){
			curr = curr.next;
		}
		return curr.val;
	}

	public void addAtHead(int val) {
		addAtIndex(0, val);
	}

	public void addAtTail(int val) {
		addAtIndex(size, val);
	}

	public void addAtIndex(int index, int val) {
		if(index>size) return;
		if(index<0) index=0;
		size++;

		ListNode prev = head;
		//找到要插入节点的前驱节点
		for(int i=0;i<index;i++){
			prev = prev.next;
		}

		ListNode toAdd = new ListNode(val);

		toAdd.next = prev.next;
		prev.next = toAdd;

	}

	public void deleteAtIndex(int index) {
		if(index<0||index>=size) return;
		size--;

		ListNode prev = head;
		for(int i=0;i<index;i++){
			prev = prev.next;
		}
		prev.next = prev.next.next;
	}
}

//doublly linked list

