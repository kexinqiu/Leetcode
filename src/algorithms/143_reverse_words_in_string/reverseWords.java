class Solution {
	public String reverseWords(String s) {

		char[] charArray = s.toCharArray();

		for(int i=0;i<charArray.length;i++){

			if(charArray[i]!=' '){
				int j=i;
				while(j<charArray.length && charArray[j]!=' ') j++;
				reverse(charArray, i, j-1);
				i = j;
			}
		}
		return new String(charArray);
	}

	public void reverse(char[] s, int left, int right){

		while(left<right){
			char c = s[left];
			s[left] = s[right];
			s[right] = c;
			left++;
			right--;
		}
	}
}