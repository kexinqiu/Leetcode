//2^31 是10位数， 最大的10位数 所有位数平方相加得到 810
//因此 不会无限增大，只有两种可能：1.到达1  2.在3位以内循环
//因此，只要出现循环即相同的数字，要么为1，要么永远不为1
//用set判断是否出现循环

//tc：o(logn)  最差情况：o(logn) +o(log（logn)）+ o（logn（log（logn)））... O(logn) 是占主导地位的部分
//sc：o(logn)
class Solution {
	public boolean isHappy(int n) {
		Set<Integer> set = new HashSet<>();

		while(n!=1 && !set.contains(n)){
			set.add(n);
			n = getNext(n);
		}
		return n==1;
	}

	public int getNext(int n){
		int sum = 0;
		while(n!=0){
			int m = n%10;
			n = n/10;
			sum += m*m;
		}
		return sum;
	}
}

//通过反复调用 getNext(n) 得到的链是一个隐式的链表。
//隐式意味着我们没有实际的链表节点和指针，但数据仍然形成链表结构。
//起始数字是链表的头 “节点”，链中的所有其他数字都是节点。next 指针是通过调用 getNext(n) 函数获得。

//那么这个问题就可以转换为检测一个链表是否有环
//如果是快乐数，那么fast会先到1
//如果不是快乐数，会进去循环，fast和slow最终会在同一个node相遇

//tc：o(log n)
//sc：o(1)
class Solution {
	public boolean isHappy(int n) {
		int slow = n;
		int fast = getNext(n);
		while(fast!=1 && slow!=fast){
			slow = getNext(slow);
			fast = getNext(getNext(fast));
		}
		return fast == 1;
	}

	public int getNext(int n){
		int sum = 0;
		while(n>0){
			int i = n % 10;
			n = n/10;
			sum += i * i;
		}
		return sum;
	}
}
