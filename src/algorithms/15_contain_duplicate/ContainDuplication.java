// O(nlogn)
class Solution {
	public boolean containsDuplicate(int[] nums) {
		if(nums.length<2) return false;

		Arrays.sort(nums);

		for(int i=0; i<nums.length-1; i++){

			if(nums[i]==nums[i+1]) return true;

		}

		return false;
	}
}

//hashset

class Solution {
	public boolean containsDuplicate(int[] nums) {
		if(nums.length<2) return false;
		//duplication values are not allowed in HashSet
		HashSet<Integer> set = new HashSet<>();

		for(int i : nums){
			// if element is present then return false
			if(!set.add(i)) return true;
		}


		return false;

	}
}