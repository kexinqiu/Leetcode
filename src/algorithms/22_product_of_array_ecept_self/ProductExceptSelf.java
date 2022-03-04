
//1.
class Solution {
	public int[] productExceptSelf(int[] nums) {
		int N = nums.length;

		int[] left_product = new int[N];
		int[] right_product = new int[N];
		int[] result = new int[N];

		left_product[0]=1;
		right_product[N-1]=1;
		//multiply all the elements on the left of the target
		//from left to right
		for(int i=1;i<N;i++){
			left_product[i]=left_product[i-1]*nums[i-1];
		}
		//multiply all the elements on the right of the target
		//from right to left
		for(int i=N-2;i>=0;i--){
			right_product[i]=right_product[i+1]*nums[i+1];
		}
		//multiply the left product and right product
		for(int i=0;i<N;i++){
			result[i]= left_product[i]*right_product[i];
		}

		return result;
	}
}

//2. ST: O(1);
class Solution {
	public int[] productExceptSelf(int[] nums) {

	}
}