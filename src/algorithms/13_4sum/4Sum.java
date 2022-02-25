import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
	public List<List<Integer>> fourSum(int[] nums, int target) {

		List<List<Integer>> tmp = new LinkedList<>() ;

		if(nums.length<4)  return tmp;

		Arrays.sort(nums);
        //use fot loop to move the first element right, so the boundary of the first elements is 0-nums.length-3
		for(int i=0; i<nums.length-3; i++){
			//skip duplication
			if(i==0 || i>0 && nums[i] == nums[i-1]) continue;
			//use fot loop to move the second element right, so the boundary of the second elements is 0-nums.length-2
			for(int j=i+1; j<nums.length-2; j++){
				//skip duplication
				if(j==i+1 || j>i+1 && nums[j] == nums[j-1]) continue;
				int l = j+1;
				int r = nums.length-1;
				//find a pair of two-pointers
				while(l<r){
					int sum = target-nums[i]-nums[j];
					if(sum==nums[l]+nums[r]){
						//store into the list
						tmp.add(Arrays.asList(nums[i],nums[j],nums[l],nums[r]));
						//skip duplication
						while(l<r&&nums[l]==nums[l+1]) l++;
						while(l<r&&nums[r]==nums[r-1]) r--;
						l++;
						r--;
					}
					//move left pointer
					else if(sum>nums[l]+nums[r])  l++;
					//move right pointer
					else r--;
				}
			}
		}
		return tmp;
	}
}