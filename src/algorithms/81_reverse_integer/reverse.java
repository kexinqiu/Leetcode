//tc: log10(n)->log(n)

class Solution {
	public int reverse(int x) {
		int res = 0;

		while(x!=0){
			int digit = x%10;
			if(x>0){
				if(res>Integer.MAX_VALUE/10 || res==Integer.MAX_VALUE/10 && digit>Integer.MAX_VALUE%10) return 0;
			}
			else if(x<0){
				if(res<Integer.MIN_VALUE/10 || res==Integer.MIN_VALUE/10 && digit<Integer.MIN_VALUE%10) return 0;
			}
			res = res*10+digit;
			x = x/10;
		}
		return res;
	}
}

class Solution {
	public int reverse(int x) {
		int res = 0;

		while(x!=0){
			//get the last digit
			int digit = x % 10;
			//put the last to the first
			int newRes = res*10+digit;
			//if no overflow exists, then newRes/10 return res back
			if((newRes-digit)/10!=res) return 0;
			res = newRes;
			//remove the last digit
			x = x/10;
		}
		return res;
	}
}

