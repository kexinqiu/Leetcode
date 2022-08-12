//stack
//tc: o(maxK * n)  maxK is the maximum value of k and nn is the length of a given string s
//sc: o(m+n) m is the number of letters(a-z) and n is the number of digits

class Solution {
	public String decodeString(String s) {

		StringBuilder str = new StringBuilder();
		int multi = 0;

		Stack<String> string = new Stack<>();
		Stack<Integer> multiple = new Stack<>();

		for(char c : s.toCharArray()){
			if(c>='0'&&c<='9') multi = multi*10+c-'0';

			else if(c=='['){
				multiple.push(multi);
				string.push(str.toString());
				multi = 0;
				str = new StringBuilder();

			}

			else if(c==']'){
				int curr_multi = multiple.pop();
				StringBuilder tmp = new StringBuilder();
				for(int i=0;i<curr_multi;i++) tmp.append(str);

				String last_str = string.pop();
				str = new StringBuilder(last_str + tmp);
			}
			else str.append(c);

		}
		return str.toString();

	}
}

//dfs
class Solution {
	public String decodeString(String s) {
		Queue<Character> queue = new LinkedList<>();
		for(char c : s.toCharArray()){
			queue.offer(c);
		}

		return dfs(queue);

	}

	private String dfs(Queue<Character> queue){
		StringBuilder sb = new StringBuilder();
		int multi = 0;

		while(!queue.isEmpty()){
			char c = queue.poll();
			if(c>='0'&&c<='9') multi = multi * 10 + c - '0';
			else if(c=='['){
				String tmp = dfs(queue);
				while(multi>0){
					sb.append(tmp);
					multi--;
				}

			}
			else if(c==']'){
				return sb.toString();
			}
			else{
				sb.append(c);
			}
		}
		return sb.toString();
	}
}