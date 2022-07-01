//tc:o(n)
//sc:o(n)
//1.
class Solution {
	public int minAddToMakeValid(String s) {
		//需要 ')' 的个数
		int need = 0;
		//需要 '(' 的个数
		int res = 0;

		for(int i=0;i<s.length();i++){
			if(s.charAt(i)=='('){
				need++;
			}
			else{
				if(s.charAt(i)==')'){
					need--;
				}
				//说明')'并没有'('与之对应, 因此res+1；同时need要变成0
				if(need<0){
					res++;
					need = 0;
				}
			}
		}

		return res+need;
	}
}

//2.stack
//tc:o(n)
//sc:o(n)
 class Solution {
     public int minAddToMakeValid(String s) {
         Stack<Character> stack = new Stack<>();

         for(int i=0;i<s.length();i++){
             if(s.charAt(i)=='('){
                 stack.push(s.charAt(i));
             }else{
                 if(!stack.empty() && stack.peek()=='('){
                     stack.pop();
                 }else{
                     stack.push(s.charAt(i));
                 }
             }
         }
         return stack.size();
     }
 }