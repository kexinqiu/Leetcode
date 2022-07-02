//1.没重叠，在之前
//2.重叠，确定merge的首尾
//3. 没重叠，在之后

//tc o(n)
//sc o(n)
class Solution {
	public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
		List<List<Integer>> res = new ArrayList<>();

		int i = 0;

		while(i<intervals.length && intervals[i][1]<toBeRemoved[0]){
			res.add(Arrays.asList(intervals[i][0], intervals[i][1]));
			i++;
		}

		while(i<intervals.length && intervals[i][0] <= toBeRemoved[1]){
			if(intervals[i][0]<toBeRemoved[0]){
				res.add(Arrays.asList(intervals[i][0], toBeRemoved[0]));
			}

			if(intervals[i][1]>toBeRemoved[1]){
				res.add(Arrays.asList(toBeRemoved[1], intervals[i][1]));
			}
			i++;
		}

		while(i<intervals.length){
			res.add(Arrays.asList(intervals[i][0], intervals[i][1]));
			i++;
		}

		return res;
	}
}