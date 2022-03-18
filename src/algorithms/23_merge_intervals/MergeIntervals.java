import java.util.ArrayList;
import java.util.Arrays;

class Solution {
	public int[][] merge(int[][] intervals) {

		if(intervals.length<=1) return intervals;
		//sort the array
		Arrays.sort(intervals, (arr1,arr2)->Integer.compare(arr1[0], arr2[0]));

		//don't know the size, so use arraylist
		List<int[]> result = new ArrayList();
		//add the first element into the list
		result.add(intervals[0]);
		//get the end line of the interval
		int preEnd = intervals[0][1];

		//traverse every element from the second element
		for(int i=1;i<intervals.length;i++){
			//compare the end line of current item with the start line of next item
			// if  the current item in list does not overlap with the next item, just append
			//then update
			if(preEnd<intervals[i][0]){
				result.add(intervals[i]);
				preEnd = intervals[i][1];
			}else{
				//if overlap, merge the current and next
				//get the larger end line
				preEnd = Math.max(intervals[i][1], preEnd);
				int[] current = result.get(result.size()-1);
				current[1] = preEnd;
			}
		}
		return result.toArray(new int[result.size()][2]);
	}
}


class Solution {
	public int[][] merge(int[][] intervals) {

		if(intervals.length<=1) return intervals;

		Arrays.sort(intervals, (arr1,arr2)->Integer.compare(arr1[0], arr2[0]));

		List<int[]> result = new ArrayList();

		int[] current_interval = intervals[0];
		result.add(current_interval);

		for(int[] interval : intervals){
			int current_start = current_interval[0];
			int current_end = current_interval[1];
			int next_start = interval[0];
			int next_end = interval[1];
			//compare the current interval with the next one
			//if the end line of current interval is less than the start line of the next
			//means they don't overlap, add the next interval into array
			if(current_end<next_start){
				current_interval = interval;
				result.add(current_interval);
			}else{
				//if they overlap, then the max one becomes the end line
				current_interval[1]=Math.max(current_end, next_end);
			}
		}

		return result.toArray(new int[result.size()][2]);

	}
}