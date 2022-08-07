

//two pointers
class Solution {
     public int arithmeticTriplets(int[] nums, int diff) {
         int count = 0;

         for(int i=0;i<nums.length-2;i++){
             for(int j=i+1;j<nums.length-1;j++){
                 if(nums[j]-nums[i]==diff){
                     for(int t=j+1;t<nums.length;t++){
                         if(nums[t]-nums[j]==diff){
                             count++;
                             break;
                         }
                     }
                     break;
                 }
             }
         }
         return count;
     }
 }


class Solution {
	public int arithmeticTriplets(int[] nums, int diff) {
		int count = 0;

		Set<Integer> set = new HashSet<>();

		for(int n : nums){
			if(set.contains(n-diff) && set.contains(n-2*diff)){
				count++;
			}
			set.add(n);
		}
		return count;
	}
}