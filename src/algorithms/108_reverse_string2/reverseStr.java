//tc:o(n)  n/2
//sc:o(1)

//two pointers（window）+swap  找到start和end位置，在window内reverse
class Solution {
	public String reverseStr(String s, int k) {

		char[] c = s.toCharArray();

		for(int i=0;i<c.length;i=i+2*k){
			int start = i;
			int end = Math.min(start+k-1, c.length-1);

			while(start<end){
				char tmp = c[start];
				c[start] = c[end];
				c[end] = tmp;
				start++;
				end--;
			}
		}
		return new String(c);

	}
}