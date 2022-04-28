//left to right pass
//tc: o(1)
//As there is a finite set of roman numerals, the maximum number possible number can be 3999, which in roman numerals is MMMCMXCIX.
// As such the time complexity is O(1)O(1).
class Solution {
	public int romanToInt(String s) {
		Map<String, Integer>map = new HashMap<>();
		map.put("M", 1000);
		map.put("D", 500);
		map.put("C", 100);
		map.put("L", 50);
		map.put("X", 10);
		map.put("V", 5);
		map.put("I", 1);

		int sum = 0;
		int i = 0;
		while(i<s.length()){
			String currChar = s.substring(i, i+1);
			int currValue = map.get(currChar);
			int nextValue = 0;

			if(i+1<s.length()){
				String nextChar = s.substring(i+1, i+2);
				nextValue = map.get(nextChar);
			}
			if(currValue<nextValue){
				sum += (nextValue-currValue);
				i += 2;
			}
			else {
				sum += currValue;
				i += 1;
			}
		}
		return sum;
	}
}

//tc o(1)
//right to left pass
class Solution {
	public int romanToInt(String s) {
		Map<String, Integer>map = new HashMap<>();
		map.put("M", 1000);
		map.put("D", 500);
		map.put("C", 100);
		map.put("L", 50);
		map.put("X", 10);
		map.put("V", 5);
		map.put("I", 1);

		String lastChar = s.substring(s.length()-1);
		int lastValue = map.get(lastChar);
		int sum = 0;
		for(int i=s.length()-2;i>=0;i--){
			String currChar = s.substring(i, i+1);
			int currValue = map.get(currChar);
			if(currValue<lastValue){
				sum -= currValue;
			}else{
				sum += currValue;
			}
			lastValue = currValue;
		}
		return sum;
	}
}
