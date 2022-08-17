//朴素解法，tc：o(m*n)

class Solution {
	public int strStr(String haystack, String needle) {
		if(needle==null) return 0;
		if(needle.length()>haystack.length()) return -1;

		int count=0;

		for(int i=0;i<=haystack.length()-needle.length();i++){
			int a = i;
			for(int j=0;j<needle.length();j++){
				if(needle.charAt(j)==haystack.charAt(a)) {
					count++;
					if(count==needle.length()) return i;
					a++;
				}else{
					count = 0;
					break;
				}
			}
		}
		return -1;
	}
}


//KMP
//第一步：构建 next[]  o（n）
//第二步：对数组进行匹配 o（m）
//tc：o（n+m）
//sc：o（n）构建next[]
class Solution {
	public int strStr(String haystack, String needle) {

		int h = haystack.length();
		int n = needle.length();

		if(n>h) return -1;
		if(n==0) return 0;

		//构建 next[]
		int[] next = new int[n];
		int j=-1;
		next[0]=j;
		for(int i=1;i<n;i++){
			//// 匹配不成功的话，j = next(j)
			while(j>=0 && needle.charAt(i)!=needle.charAt(j+1)){
				j = next[j];
			}
			// 匹配成功的话，先让 j++，结束本次循环后 i++
			if(needle.charAt(i)==needle.charAt(j+1)) j++;
			// 更新 next[i]
			next[i] = j;
		}

		j = -1;
		for(int i=0;i<h;i++){
			// 匹配不成功 j = next(j) j前移至next[j]
			while(j>=0 && haystack.charAt(i)!=needle.charAt(j+1)){
				j = next[j];
			}
			//j和i后移，先让 j++，结束本次循环后 i++
			if(haystack.charAt(i)==needle.charAt(j+1)){
				j++;
			}
			// 整一段匹配成功，直接返回下标
			if(j==n-1) return i-n+1;
		}
		return -1;

	}
}