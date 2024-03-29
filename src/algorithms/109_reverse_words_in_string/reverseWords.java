class Solution {
	public String reverseWords(String s) {
		String newS = removeSpace(s);

		char[] c = newS.toCharArray();

		reverse(c, 0, newS.length()-1);

		//reverse 在string 中的word
		int l = 0;
		int r = newS.length()-1;

		while(l<=r){
			if(c[l]!=' '){
				int j = l;
				while(j<=r && c[j]!=' ') j++;
				reverse(c, l, j-1);
				l = j-1;
			}
			l++;
		}
		return new String(c);
	}

	public String removeSpace(String s){

		int l = 0;
		int r = s.length()-1;

		StringBuilder sb = new StringBuilder();

		while(l<=r && s.charAt(l)==' ') l++;
		while(l<=r && s.charAt(r)==' ') r--;

		while(l<=r){
			if(s.charAt(l)!=' ') sb.append(s.charAt(l));
			else if(sb.charAt(sb.length()-1)!=' ') sb.append(s.charAt(l));

			l++;
		}
		return sb.toString();
	}

	public void reverse(char[] c, int i, int j){

		while(i<j){
			char tmp = c[i];
			c[i] = c[j];
			c[j] = tmp;

			i++;
			j--;
		}
	}
}





//1.先去除首位空格 -> reverse whole string -> reverse each worde
//tc:o(n)
//sc:o(n)

class Solution {
	public String reverseWords(String s) {
		StringBuilder sb = new StringBuilder();
		sb = trimSpace(s);

		reverse(sb, 0, sb.length()-1);
		reverseEachWord(sb);

		return sb.toString();
	}

	//去除首尾及多余空格
	public StringBuilder trimSpace(String s){
		int l = 0;
		int r = s.length()-1;
		// remove leading spaces
		while(l<=r && s.charAt(l)==' ') l++;
		// remove trailing spaces
		while(l<=r && s.charAt(r)==' ') r--;

		StringBuilder sb = new StringBuilder();
		// reduce multiple spaces to single one
		while(l<=r){
			char c = s.charAt(l);

			if(c != ' ') sb.append(c);
			else if(sb.charAt(sb.length()-1) !=' ') sb.append(c);

			l++;
		}
		return sb;
	}

	//reverse the whole string
	public void reverse(StringBuilder sb, int l, int r){

		while(l<r){
			char tmp = sb.charAt(l);
			sb.setCharAt(l, sb.charAt(r));
			sb.setCharAt(r, tmp);
			l++;
			r--;
		}
	}

	public void reverseEachWord(StringBuilder sb){
		int n = sb.length();
		int start = 0, end = 0;

		while(start<n){
			while(end<n && sb.charAt(end)!= ' ') end++;
			reverse(sb, start, end-1);

			start = end+1;
			end++;
		}
	}
}

//2. deque
//deque - 制造单口deque-stack， 先进后出

class Solution {
	public String reverseWords(String s) {
		int l = 0;
		int r = s.length()-1;

		while(l<=r && s.charAt(l)==' ') l++;
		while(l<=r && s.charAt(r)==' ') r--;

		Deque<String> d = new ArrayDeque();
		StringBuilder word = new StringBuilder();

		while(l<=r){
			char c = s.charAt(l);
			if(word.length()!=0 && c==' '){
				d.addFirst(word.toString());
				word.setLength(0);
			}
			else if( c!=' '){
				word.append(c);
			}
			l++;
		}
		d.addFirst(word.toString());

		return String.join(" ", d);
	}
}