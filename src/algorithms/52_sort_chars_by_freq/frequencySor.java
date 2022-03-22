
//bucket sort o(n)
class Solution {
	public String frequencySort(String s) {
		//hashmap stores frequency
		Map<Character, Integer> freqMap = new HashMap<>();
		//toCharArray converts string to char array
		for(char c: s.toCharArray()){
			freqMap.put(c, freqMap.getOrDefault(c,0)+1);
		}
		//sort frequency
		List<Character>[] bucket = new List[s.length()+1];

		for(char key : freqMap.keySet()){
			int freq = freqMap.get(key);
			if(bucket[freq]==null) {
				bucket[freq]=new ArrayList<>();
			}
			bucket[freq].add(key);
		}

		StringBuilder res = new StringBuilder();

		for(int index=bucket.length-1;index>=0;index--){
			if(bucket[index]!=null){
				//get all chars in one bucket
				for(char c : bucket[index]){
					//index is the number of chars
					for(int i=0;i<index;i++){
						res.append(c);
					}
				}
			}
		}
		return res.toString();
	}
}

//pq
public class Solution {
	public String frequencySort(String s) {

		Map<Character, Integer> freqMap = new HashMap<>();

		for(char c : s.toCharArray()){
			freqMap.put(c, freqMap.getOrDefault(c,0)+1);
		}
		//priorityqueue stores the entry and sort the frequency
		PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
			(a,b)->b.getValue()-a.getValue()
		);

		pq.addAll(freqMap.entrySet());

		StringBuilder res = new StringBuilder();

		while(!pq.isEmpty()){
			Map.Entry e = pq.poll();

			for(int i=0;i<(int)e.getValue();i++){
				res.append(e.getKey());
			}
		}
		return res.toString();
	}
}