class Solution {

	public boolean isPalindrome(String s) {

		if(s==null){
			return true;
		}

		String tmp="";

		for(char c : s.toCharArray()){
			if (Character.isLetter(c)||Character.isDigit(c)){
				tmp += c;
			}
		}

		tmp = tmp.toLowerCase();

		int left=0;
		int right=tmp.length()-1;

		while(left<=right) {

			if(!(tmp.charAt(left) == tmp.charAt(right))){
				return false;
			}

			left ++;
			right --;
		}
		return true;
	}

}