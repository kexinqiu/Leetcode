//Reverse all numbers between "I".
//tc:o(n)
//sc:o(n)

class Solution {

	public String smallestNumber(String pattern) {
		StringBuilder sb = new StringBuilder();
		StringBuilder res = new StringBuilder();

		for(int i=1;i<=pattern.length()+1;i++){
			sb.append(i);
			if(i==pattern.length()+1 || pattern.charAt(i-1)=='I'){
				res.append(sb.reverse());
				sb = new StringBuilder();
			}
		}
		return res.toString();
	}
}