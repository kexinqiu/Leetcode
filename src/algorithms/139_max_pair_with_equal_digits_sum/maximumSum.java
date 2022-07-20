// 自己方法
//two pointers
class Solution {
	public int maximumSum(int[] nums) {
		Arrays.sort(nums);

		int[] sumOfDigits = new int[nums.length];

		for(int i=0;i<nums.length;i++){
			changeToArray(sumOfDigits, i, nums[i]);
		}

		int sum = Integer.MIN_VALUE;

		for(int left=0;left<nums.length-1;left++){

			int right = nums.length-1;

			while(left<right){

				if(sumOfDigits[left]==sumOfDigits[right]) {
					sum = Math.max(sum, nums[left]+nums[right]);
					left++;
					right = nums.length-1;
				}else{
					right--;
				}
			}
		}
		return sum==Integer.MIN_VALUE?-1:sum;
	}

	public void changeToArray(int[] sumOfDigits, int index, int n){

		int sum = 0;
		while(n>0){
			int reminder = n%10;
			n = n/10;
			sum += reminder;
		}

		sumOfDigits[index] = sum;
	}
}

//hashmap
class Solution {


	public int maximumSum(int[] nums) {

		Map<Integer, Integer> map = new HashMap<>();

		int result = -1;

		for(int i : nums){
			int sumOfDigits = changeToArray(i);

			if(map.containsKey(sumOfDigits)){
				result = Math.max(result, i+map.get(sumOfDigits));
				map.put(sumOfDigits, Math.max(i, map.get(sumOfDigits)));
			}else{
				map.put(sumOfDigits, i);
			}
		}


		return result;
	}

	public int changeToArray(int n){

		int sum = 0;

		while(n>0){
			int reminder = n%10;
			n = n/10;
			sum += reminder;
		}

		return sum;
	}
}