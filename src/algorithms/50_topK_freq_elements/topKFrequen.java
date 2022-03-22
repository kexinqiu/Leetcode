import java.util.ArrayList;
import java.util.HashMap;

//tc: O(n)
//sc: o(n)

class Solution {
	public int[] topKFrequent(int[] nums, int k) {

		Map<Integer, Integer> freqMap = new HashMap<>();

		//add the frequency of numbers in nums[] as value into the hashmap
		for(int n : nums){
			freqMap.put(n, freqMap.getOrDefault(n,0)+1);
		}

		List<Integer>[] bucket = new List[nums.length+1];
		//order the frequency in array of list
		//the index equals to the frequency
		//the value equals to the key
		for(int key : freqMap.keySet()){
			int freq = freqMap.get(key);
			if(bucket[freq]==null) {
				bucket[freq] = new ArrayList<>();
			}

			bucket[freq].add(key);
		}
		//use to store k elements
		List<Integer> res = new ArrayList<>();
		//from the last element to the first element, get k elements
		//res.size()<k
		for(int index=bucket.length-1; index>=0 && res.size()<k; index--){
			if(bucket[index]!=null){
				res.addAll(bucket[index]);
			}
		}
		//list->array
		int[] arr = new int[res.size()];

		for(int i=0;i<res.size();i++){
			arr[i]=res.get(i);
		}

		return arr;
	}
}