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
class MyLinkedList {

	class ListNode{
		int val;
		ListNode next, prev;

		public ListNode(int val){
			this.val = val;
		}
	}

	int size;
	//虚拟头结点 sentinel head
	ListNode head, tail;

	public MyLinkedList() {
		size = 0;
		head = new ListNode(0);
		tail = new ListNode(0);
		head.next = tail;
		tail.prev = head;
	}

	public int get(int index) {
		if(index<0||index>=size) return -1;
		ListNode curr;
		if(index<(size-1)/2){
			curr = head;
			for(int i=0;i<=index;i++){
				curr = curr.next;
			}
		}else{
			curr = tail;
			for(int i=0;i<=size-index-1;i++){
				curr = curr.prev;
			}
		}
		return curr.val;
	}

	public void addAtHead(int val) {
		ListNode toAdd = new ListNode(val);
		ListNode curr = head;
		toAdd.next = curr.next;
		curr.next.prev = toAdd;
		curr.next = toAdd;
		toAdd.prev = curr;
		size++;
	}

	public void addAtTail(int val) {
		ListNode toAdd = new ListNode(val);
		ListNode curr = tail;
		toAdd.next = curr;
		toAdd.prev = curr.prev;
		curr.prev.next = toAdd;
		curr.prev = toAdd;
		size++;
	}

	public void addAtIndex(int index, int val) {
		if(index>size) return;
		if(index<0) index=0;
		ListNode curr = head;
		for(int i=0;i<index;i++){
			curr = curr.next;
		}
		ListNode toAdd = new ListNode(val);

		toAdd.next = curr.next;
		curr.next.prev = toAdd;
		toAdd.prev = curr;
		curr.next = toAdd;
		size++;
	}

	public void deleteAtIndex(int index) {
		if(index<0 || index>=size) return;
		ListNode curr = head;
		for(int i=0;i<index;i++){
			curr = curr.next;
		}
		//注意先后顺序，如果先写curr.next = curr.next.next
		//再写curr.next.next.prev， 此时curr.next已经发生改变
		curr.next.next.prev = curr;
		curr.next = curr.next.next;
		size--;
	}
}
