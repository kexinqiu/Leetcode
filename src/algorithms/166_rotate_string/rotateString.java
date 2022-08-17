//tc:o(n*n)
//sc:o(1)
class Solution {
	public boolean rotateString(String s, String goal) {
		if(s.length()!=goal.length()) return false;

		for(int i=0;i<s.length();i++){
			if(rotate(s, goal, i)){
				return true;
			}
		}
		return false;
	}

	private boolean rotate(String s, String goal, int rotation){
		for(int i=0;i<s.length();i++){
			//需要理解一下，先找到第一个相等的，再往后找
			//一定要%goal.length()， 这样才能确保到达end以后，再从头开始
			if(s.charAt(i)!=goal.charAt((i+rotation)%goal.length()))return false;
		}
		return true;
	}
}

//更简单的方法
//由于每次旋转操作都是将最左侧字符移动到最右侧，因此如果 goal 可由 s 经过多步旋转而来，那么 goal 必然会出现在 s + s
//tc:o(n)
//sc:o(n)
class Solution {
	public boolean rotateString(String s, String goal) {
		if(s.length()!=goal.length()) return false;

		s = s + s;

		if(s.contains(goal)) return true;
		return false;
	}
}