//这道题不需要想的很复杂，只要两个string有common substring
//那么最短的substring一定长度为1

//题目
//有两个string A, B. 找到两个string最短的共同substring的数量

class Solution{
	public int smallestCommonSubstring(String A, String B) {
		char[] a = A.toCharArray();
		char[] b = B.toCharArray();

		int[] freq = new int[26];

		for (char c : a) {
			freq[c - 'a']++;
		}

		int sum = 0;

		for (char c : b) {
			sum += freq[c - 'a'];
		}

		return sum;
	}
}