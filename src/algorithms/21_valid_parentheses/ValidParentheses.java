class Solution {
	public boolean isValid(String s) {

		Stack<Character> tmp = new Stack<>();

		//tarverse characters in string
		for(int i=0; i<s.length();i++){

			char a = s.charAt(i);
			//there are two types, one is the open bracket
			//another one is the right part of the open bracket

			if(a == '(' || a=='[' || a=='{' ) tmp.push(a);
				// if the stack is empty but there are characters left in string, means there is right part
				//of bracket left
			else if(tmp.isEmpty()) return false;
				//if the charater is close bracket, then the top element in stack must be its open brackets
			else if(a==')' && tmp.pop()!='(') return false;
			else if(a==']' && tmp.pop()!='[') return false;
			else (a=='}' && tmp.pop()!='{') return false;
		}
		//if bracks has been closed by the same
		return tmp.isEmpty();
	}
}