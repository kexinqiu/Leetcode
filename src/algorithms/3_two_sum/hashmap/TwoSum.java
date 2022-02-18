import java.util.HashMap;
import java.util.Map;

class TwoSum {
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> num_map = new HashMap<>();

		for(int i=0; i<nums.length; i++){
			int another = target - nums[i];

			if(num_map.containsKey(another)){
				return new int[] {num_map.get(another), i};
			}
			num_map.put(nums[i], i);
		}
		return new int[] {};
	}

}