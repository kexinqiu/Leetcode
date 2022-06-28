//双指针 swap
//tc:o(n)
//sc:o(1)

class Solution {
	public void reverseString(char[] s) {
		if(s==null || s.length<1) return;

		int left = 0;
		int right = s.length-1;

		while(left<right){
			char tmp = s[left];
			s[left] = s[right];
			s[right] = tmp;

			left++;
			right--;
		}
	}
}