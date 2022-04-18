import java.util.HashSet;

//hashmap
class Solution {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i=0;i<nums.length;i++){
			if(map.containsKey(nums[i])){
				int index = map.get(nums[i]);
				if(Math.abs(index-i)<=k) return true;
			}
			map.put(nums[i], i);
		}
		return false;
	}
}

//hashset
class Solution {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		Set<Integer> set = new HashSet<>();
		for(int i=0;i<nums.length;i++){
			if(set.contains(nums[i])) return true;
			set.add(nums[i]);
			if(set.size()>k) {
				set.remove(nums[i-k]);
			}
		}
		return false;
	}
}