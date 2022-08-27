//首先想到two sum
//其次找到 item1 和 item2=target-item1

// (s1 + s2) % 60 == 0;
// => s1 % 60 = 60 - s2 % 60;
//but if s1 % 60 = 0 && s2 % 60 = 0, s1 % 60 != 60 - s2 % 60; => s1 % 60 = (60 - s2 % 60) % 60


class Solution {
	public int numPairsDivisibleBy60(int[] time) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int count = 0;

		for(int t : time){
			int firstDividedTime = t % 60;
			int secondDividedTime = (60 - t % 60) % 60;
			if(map.containsKey(secondDividedTime)){
				count += map.get(secondDividedTime);
			}
			map.put(t % 60, map.getOrDefault(t % 60, 0)+1);

		}
		return count;
	}
}