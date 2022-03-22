//tc: O(nlogk)
//sc: O(n)  n for hashmap, k for priorityqueue, k for linkedlist

class Solution {
	//PriorityQueue + minHeap, hashmap, linkedlist
	//can't use maxHeap, whose time complixity is O(nlogn)
	//in this case, minHeap time complixity is O(nlogk), because we only keep k elements in pq
	//the time complixity of pq(abstract data type)
	//comparing elements in minHeap(data structure) or maxHeap(data structure) is O(nlogn). only compare in
	//left branch or right branch
	public List<String> topKFrequent(String[] words, int k) {

		//use hashmap store frequency of words
		Map<String, Integer> freqMap = new HashMap<>();

		for(int i=0;i<words.length;i++){
			freqMap.put(words[i], freqMap.getOrDefault(words[i], 0)+1);
		}
		//overwrite comparator as minHeap
		//if the frequency of words is same, then compare the lexicographical order
		PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
			(a,b)-> a.getValue()==b.getValue()?b.getKey().compareTo(a.getKey()) : a.getValue()-b.getValue()
		);

		for(Map.Entry<String, Integer> entry : freqMap.entrySet()){

			pq.add(entry);
			//only store the top K elements
			if(pq.size()>k){
				pq.poll();
			}
		}
		//use linkedlist to store the result
		List<String> res = new LinkedList<>();

		for(int i=0;i<k;i++){
			res.add(0, pq.poll().getKey());
		}

		return res;
	}
}