//O(n^2)
class Solution {
	public int subarraySum(int[] nums, int k) {

		int n = nums.length;
		int res = 0;

		int[] sum = new int[n+1];
		sum[0]=0;
		//from 1 rather than 0
		for(int i=1;i<=n;i++){
			//get the sum of subarrays
			sum[i]=sum[i-1]+nums[i-1];
		}
		//sum[i,j]=sum[0,j+1]-sum[0,i]
		//preSum can get all subarrays
		for(int start=0;start<n+1;start++){
			for(int end=start+1;end<n+1;end++){
				if(sum[end]-sum[start]==k)
					res++;
			}
		}
		return res;
	}
}




//sum[i, j] = sum[0, j+1] - sum[0, i]
//   k            sum         key in hashmap
//key = sum[0, j+1] - k
//now we have sum and k, as long as we get the key sum[0, i], we then get a valid subarray

//O(n)

//preSum+Hashmap
class Solution {
	public int subarraySum(int[] nums, int k) {
		// hashmap + preSum
		if(nums==null || nums.length==0) return 0;
		//store the sum of subarrays and their frequency
		Map<Integer, Integer> preSum = new HashMap<>();
		preSum.put(0,1);

		int count = 0;
		int sum=0;
		for(int i=0;i<nums.length;i++){
			//get the sum of subarrays from index 0
			sum += nums[i];
			// k = sum[current]-sum[previous]
			//sum[previous] = sum[current]-k
			//if hashmap contains sum[previous], means there is a valid subarray whose sum is k
			if(preSum.containsKey(sum-k)){
				count += preSum.get(sum-k);
			}
			//put the sum and its frequency into hashmap
			preSum.put(sum, preSum.getOrDefault(sum, 0)+1);
		}

		return count;
	}
}