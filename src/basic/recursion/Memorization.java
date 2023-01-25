package basic.recursion;

// 如果递归问题产生重复的子问题，那么可以使用cache记住子问题的答案，避免重复计算
//lc

public class Memorization {
	// 1. initialize cache()

	public foo() {
		//2. check answer if already exists

		//3. base case

		//4.recursion relation

		//5.save the answer in cache
	}

}

//recursion
class Solution {
	public int fib(int n) {
		int[] cache = new int[n + 1];
		return helper(cache, n);
	}

	private int helper(int[] cache, int n) {
		if (n <= 1) return n;
		if (cache[n] != 0) return cache[n];

		cache[n] = helper(cache, n - 1) + helper(cache, n - 2);
		return cache[n];
	}
}
