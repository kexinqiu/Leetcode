Time complexity:

Push() -> O(1)
Pop() ->O(n)
Amortized time complexity = O(1)

Five element(1 2 3 4 5) => n
1st time call pop() n(pop from stack1)+n(push to stack2)+1(pop from stack1)=2n+1
2nd time call pop() time=1
3rd time call pop() time =1
Nth call pop()  time=1
Amortized time complexity = (2n+1 + (n-1)*1)/n = 3n/n -> O(1)