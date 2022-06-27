//get, put need run in o(1) ---- hashtable
//快速插入和删除  ---- linked list

// LinkedListHashMap
//tc : o(1)
//sc : o(capacity)

import java.util.HashMap;

class LRUCache {

	//init Node
	class Node{
		int key,val;
		Node next, pre;

		public Node(int key, int val){
			this.key = key;
			this.val = val;
		}
	}

	class DoubleLinkedList{
		private Node head, tail;
		private int size;

		public DoubleLinkedList(){
			// 使用伪头部和伪尾部节点
			head = new Node(0,0);
			tail = new Node(0,0);
			head.next = tail;
			tail.pre = head;
			size = 0;
		}

		public void addToHead(Node node){
			node.pre = head;
			node.next = head.next;
			head.next.pre = node;
			head.next = node;
			size++;
		}

		public void removeNode(Node node){
			node.pre.next = node.next;
			node.next.pre = node.pre;
			size--;
		}

		public void moveToHead(Node node){
			removeNode(node);
			addToHead(node);
		}

		public Node removeTail(){
			Node node = tail.pre;
			removeNode(node);

			return node;
		}

		public int getSize(){
			return size;
		}
	}

	private HashMap<Integer, Node> map;

	private DoubleLinkedList cache;

	private int capacity;


	public LRUCache(int capacity) {
		map = new HashMap<>();
		cache = new DoubleLinkedList();
		this.capacity = capacity;

	}

	public void makeRecently(int key){
		Node node = map.get(key);
		cache.removeNode(node);
		cache.addToHead(node);
	}

	public void addRecently(int key, int value){
		Node node = new Node(key, value);
		cache.addToHead(node);
		map.put(key, node);
	}

	public void deleteKey(int key){
		Node node = map.get(key);
		cache.removeNode(node);
		map.remove(key);
	}

	public void removeLeastRecently(){
		Node node = cache.removeTail();
		int deleteKey = node.key;
		map.remove(deleteKey);
	}

	public int get(int key) {
		if(!map.containsKey(key)) return -1;

		Node node = map.get(key);
		int val = node.val;
		// 将该数据提升为最近使用的
		makeRecently(key);
		return val;
	}

	public void put(int key, int value) {
		//如果已经有该数据，直接更新
		if(map.containsKey(key)){
			// 删除旧的数据
			deleteKey(key);
			// 新插入的数据为最近使用的数据
			addRecently(key, value);
		}else{
			//如果没有这个数据
			//首先判断是否已满，如果已满，删除最久未使用的数据
			if(capacity==cache.getSize()){
				removeLeastRecently();
			}
			//添加最新的数据
			addRecently(key, value);
		}
	}
}

