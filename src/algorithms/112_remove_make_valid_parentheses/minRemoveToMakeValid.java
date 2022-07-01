//1. Identify all indexes that should be removed.
//2. Build a new string with removed indexes.

//若为'('，先进栈（栈中存的是下标），并且标记为无效的(单个(无效)
//若为')', 若为空，无效；若不为空，则可组成合法括号，并将栈修正为合法

//tc:o(n)
//sc:o(n)
class Solution {
	public String minRemoveToMakeValid(String s) {
		Stack<Integer> stack = new Stack<>();

		boolean[] invalidIndex = new boolean[s.length()];

		for(int i=0;i<s.length();i++){
			if(s.charAt(i) == '(') {
				stack.push(i);
				invalidIndex[i] = true;
			}

			if(s.charAt(i) == ')') {
				if(!stack.empty()){
					invalidIndex[stack.pop()] = false;
				}
				else invalidIndex[i] = true;
			}
		}

		StringBuilder sb = new StringBuilder();

		for(int j=0;j<s.length();j++){
			if(!invalidIndex[j])
				sb.append(s.charAt(j));
		}

		return sb.toString();
	}
}