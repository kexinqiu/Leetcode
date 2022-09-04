int[] nums = {2, 1, 2, 4, 3};
int[] res = {4, 2,4, -1, -1};

//三步走：
//1 维持递增栈
//2 放入最后结果array
//3 当前元素入栈

public int[] nextGreaterElement(int[] nums){

	int[] res = new int[nums.length];
	Stack<Integer> stack = new Stack<>();
	for(int i=nums.length-1;i>=0;i--){
		while(!stack.isEmpth() && nums[i]>=stack.peek() ) stack.pop();
		res[i] = stack.isEmpty()? -1 : stack.peek();
		stack.push(nums[i]);
	}

	return res;
}
