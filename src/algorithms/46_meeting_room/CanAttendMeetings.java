import java.util.Arrays;
import java.util.Comparator;

// because of Subscription, have not been run on leetcode
class Solution {
	public boolean canAttendMeetings(int[][] intervals) {
		if(intervals == null || intervals.length==0) return true;

		Arrays.sort(intervals, (arr1, arr2)->Integer.compare(arr1[0], arr2[0]));

//		Arrays.sort(intervals, new Comparator<int[]>() {
//			@Override
//			public int compare(int[] o1, int[] o2) {
//				return o1[0]-o2[0];
//			}
//		});

		int preEnd = intervals[0][1];

		for(int i=1;i<intervals.length;i++){
			if(intervals[i][0]<preEnd) return false;
			else{
				preEnd = Math.max(preEnd, intervals[i][1]);
			}
		}
		return true;
	}
}