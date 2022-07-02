//greedy
//o(n)logn, Sorting Interval.end in ascending order is O(nlogn), then traverse intervals array is O(n).
class Solution {
	public int eraseOverlapIntervals(int[][] intervals) {
		if(intervals.length==0) return 0;

		Arrays.sort(intervals, new Comparator<int[]>(){
			@Override
			public int compare(int[] o1, int[] o2){
				return o1[1]-o2[1];
			}
		});

		int count = 0;

		int preEnd = intervals[0][1];

		for(int i=1; i<intervals.length;i++){
			if(preEnd>intervals[i][0]){
				count++;
			}else{
				preEnd = intervals[i][1];
			}
		}
		return count;
	}
}

class Solution {
	public int eraseOverlapIntervals(int[][] intervals) {

		if(intervals == null || intervals.length==0) return 0;
		//sort the array
		Arrays.sort(intervals, (arr1,arr2)->Integer.compare(arr1[0], arr2[0]));

		int count = 0;
		//get the end line of the interval
		int preEnd = intervals[0][1];
		//traverse every element from the second element
		for(int i=1; i<intervals.length;i++){
			//compare the end line of current item with the start line of next item
			// if  the current item in list does not overlap with the next item, just append
			//then update
			if(intervals[i][0]<preEnd) {
				preEnd =Math.min(intervals[i][1], preEnd);
				count++;
			}
			else{
				//if overlap, merge the current and next
				//get the larger end line
				preEnd = intervals[i][1];
			}
		}
		return count;
	}
}