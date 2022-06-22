//考虑几个问题：
//1. 如何保存相加result的list--- 预先指针pre + 移动的指针 curr
//2. 较短的list，用0补齐
//3. 进位问题 --  carry = sum/10
//4. 进位后，实际的数字（也是保存到result list的数字） sum%10

//tc o(max(m,n))
//sc o(max(m,n))

class Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		//伪指针，用来指向头指针，返回结果
		ListNode pre = new ListNode(0);
		//定义一个可移动的指针，用来指向存储两个数之和的位置
		ListNode curr = pre;
		//定义一个进位数
		int carry = 0;
		//定义一个该位上的实际数字
		int real = 0;
		//当l1 不等于null或l2 不等于空时，就进入循环
		while(l1!=null || l2!=null){
			//不等于null时，就取他的值，等于null时，就赋值0，保持两个链表具有相同的位数
			int x= l1!=null ? l1.val : 0;
			int y= l2!=null ? l2.val : 0;
			//将两个链表的值，进行相加，并加上进位数
			int sum = x + y + carry;
			//计算进位数
			carry = sum / 10;
			//计算进位或不进位，实际数字
			real = sum % 10;
			//将求和数赋值给新链表的节点，
			//注意这个时候不能直接将sum赋值给cur.next = sum。这时候会报，类型不匹配。
			//所以这个时候要创一个新的节点，将值赋予节点
			curr.next = new ListNode(real);
			//将新链表的节点后移
			curr = curr.next;
			//当链表l1不等于null的时候，将l1 的节点后移
			if(l1!=null) l1 = l1.next;
			//当链表l2 不等于null的时候，将l2的节点后移
			if(l2!=null) l2 = l2.next;
		}
		//如果最后两个数，相加的时候有进位数的时候，就将进位数，赋予链表的新节点。
		//两数相加最多小于20，所以的的值最大只能时1
		if(carry != 0){
			curr.next = new ListNode(carry);
		}

		return pre.next;
	}
}