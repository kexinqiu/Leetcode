//无法使用数组，因为无法得知大小
//
//
class Solution {
	public int[] intersection(int[] nums1, int[] nums2) {
		if(nums1.length<1 || nums2.length<1) return new int[0];

		Set<Integer> set1 = new HashSet<>();
		Set<Integer> setRes = new HashSet<>();

		for(int i : nums1){
			set1.add(i);
		}

		for(int i:nums2){
			if(set1.contains(i)){
				setRes.add(i);
			}
		}

		int[] res = new int[setRes.size()];
		int index = 0;
		for(int n:setRes){
			res[index++] = n;
		}
		return res;
	}
}