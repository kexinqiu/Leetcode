//reverse first
//tc o(n)
//sc o(n)
class Solution {
	public boolean isPalindrome(ListNode head) {
		ListNode node = head;
		ListNode newList = null;
		ListNode tail = null;

		while(node!=null){

			if(newList==null){
				newList = new ListNode(node.val);
				tail = newList;
			}else{
				tail.next = new ListNode(0);
				tail = tail.next;
				tail.val = node.val;
				tail.next = null;
			}

			node = node.next;
		}

		ListNode reversed = reverse(newList);

		node = head;
		while(node!=null){
			if(node.val!=reversed.val) return false;
			node = node.next;
			reversed = reversed.next;
		}
		return true;
	}

	public ListNode reverse(ListNode node){
		if(node==null) return null;

		ListNode pre = null;
		ListNode curr = node;

		while(curr!=null){
			ListNode next = curr.next;
			curr.next = pre;
			pre = curr;
			curr = next;
		}
		return pre;
	}
}

//change to list , and then check if Palindrome
//tc : o(n)
//sc : o(n)
class Solution {
	public boolean isPalindrome(ListNode head) {
		List<Integer> vals = new ArrayList<Integer>();

		// 将链表的值复制到数组中
		ListNode currentNode = head;
		while (currentNode != null) {
			vals.add(currentNode.val);
			currentNode = currentNode.next;
		}

		// 使用双指针判断是否回文
		int front = 0;
		int back = vals.size() - 1;
		while (front < back) {
			if (!vals.get(front).equals(vals.get(back))) {
				return false;
			}
			front++;
			back--;
		}
		return true;
	}
}

//The only way we can avoid using O(n) extra space is by modifying the input in-place.
//将链表的后半部分反转（修改链表结构），然后将前半部分和后半部分进行比较。比较完成后我们应该将链表恢复原样。
//tc : o(n)
//sc : o(1)

class Solution {
	public boolean isPalindrome(ListNode head) {
		if (head == null) {
			return true;
		}

		// 找到前半部分链表的尾节点并反转后半部分链表
		ListNode firstHalfEnd = endOfFirstHalf(head);
		ListNode secondHalfStart = reverseList(firstHalfEnd.next);

		// 判断是否回文
		ListNode p1 = head;
		ListNode p2 = secondHalfStart;

		//p1是完整的list，因此当list基数node时，p2必须是不包含中间node的那部分
		while ( p2 != null) {
			if (p1.val != p2.val) {
				return false;
			}
			p1 = p1.next;
			p2 = p2.next;
		}

		// 还原链表并返回结果
		firstHalfEnd.next = reverseList(secondHalfStart);
		return true;
	}

	private ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode curr = head;
		while (curr != null) {
			ListNode nextTemp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nextTemp;
		}
		return prev;
	}

	private ListNode endOfFirstHalf(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}
}

