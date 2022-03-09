class Solution {
	public int maxArea(int[] height) {

		int n = height.length;

		if(n<=1) return 0;

		int product = 0;
		//Start with pointer left=0 and pointer right=length-1
		int l = 0;
		int r = n-1;

		while(l<r){
			//The max water is limited by the pointer with smaller height
			product=Math.max(Math.min(height[l],height[r])*(r-l), product);
			//if the left pointer has smaller height, then move right, we have chance to get higher height
			if(height[l]<height[r]) l++;
				//if the right pointer has smaller height, then move left, we have chance to get highter height
			else r--;
		}
		return product;
	}
}
