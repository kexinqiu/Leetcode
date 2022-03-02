class MyQueue {

	//Stack 1: to buffer all new elements -> push(x) goes to Stack1
	private Stack<Integer> stack1;
	//Stack2: to pop out the 1st element
	private Stack<Integer> stack2;

	public MyQueue() {
		stack1 = new Stack<>();
		stack2 = new Stack<>();
	}

	//push element x to the back of queue
	public void push(int x) {
		stack1.push(x);
	}

	//remove the top element from queue and return the element
	public int pop() {
		//call peek() to move elements from stack1 to stack2
		//Then pop the top element from stack2
		peek();
		return stack2.pop();
	}

	//return the top element of queue
	public int peek() {
		//if stack 2 is empty, then we move all the element from stack1 to stack2 one by one.
		//And pop these elements from stack 1.
		if(stack2.isEmpty()){
			while(!stack1.isEmpty()){
				stack2.push(stack1.pop());
			}
		}
		return stack2.peek();
	}

	public boolean empty() {
		//when stack1 and stack2 both are empty, means that there is no element in the queue
		return  stack1.isEmpty() && stack2.isEmpty();
	}
}
