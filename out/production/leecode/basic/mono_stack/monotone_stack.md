int[] nums = {2, 1, 2, 4, 3};
int[] res = {4, 2,4, -1, -1};

//三步走：
//1 维持递增或递减栈
//2 将栈顶元素放入最后结果
//3 当前元素入栈（可以是实际元素，也可以是index）

public int[] nextGreaterElement(int[] nums){

	int[] res = new int[nums.length];
	Stack<Integer> stack = new Stack<>();
	for(int i=nums.length-1;i>=0;i--){
		while(!stack.isEmpth() && nums[i]>=stack.peek() ) stack.pop(); //递减 （>=， =可有可无）
       （//while(!stack.isEmpth() && nums[i]<=stack.peek() ) stack.pop(); //递增（<=， =可有可无））
		res[i] = stack.isEmpty()? -1 : stack.peek();
		stack.push(nums[i]);
	}

	return res;
}
