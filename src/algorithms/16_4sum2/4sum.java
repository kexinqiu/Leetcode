

class Solution {
	public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
		Map<Integer, Integer> map = new HashMap<>();


// iterate through the first 2 arrays and count the frequency of all sums of pairs
		for(int k : nums3)
			for(int l : nums4)
				map.put(k + l, map.getOrDefault(k + l, 0) + 1);
		int count = 0;
		//Iterate through the other 2 arrays and sum up the frequency of -(i + j)
		//because first iteration has added all possible sums of pairs into map,
		// if there is a sum of pairs in nums3 and nums4 equals -(i + j), get method will return the frequency of the sum
		for(int i : nums1)
			for(int j : nums2)
				count += map.getOrDefault(-(i + j), 0);
		return count;
	}
}
