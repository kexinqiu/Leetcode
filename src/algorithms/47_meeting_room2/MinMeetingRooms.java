import java.util.Arrays;
import java.util.PriorityQueue;

// because of Subscription, have not been run on leetcode
//this is my method
class Solution {
	public int minMeetingRooms(int[][] intervals) {
		if(intervals == null || intervals.length==0) return 0;

		Arrays.sort(intervals, (arr1, arr2)->Integer.compare(arr1[0], arr2[0]));

		int min_num = 1;

		int preEnd = intervals[0][1];

		for(int i=1;i< intervals.length;i++){
			if(intervals[i][0]<preEnd){
				min_num++;
				preEnd=Math.min(intervals[i][1], preEnd);
			}else{
				preEnd = intervals[i][1];
			}
		}
		return min_num;
	}
}

//method on internet
class Solution {
	public int minMeetingRooms(int[][] intervals) {
		if(intervals==null || intervals.length==0) return 0;

		Arrays.sort(intervals, (arr1, arr2)->Integer.compare(arr1[0], arr2[0]));
		//minHeap will sort the end time of meetings added
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		//add the end line of interval into minHeap
		minHeap.add(intervals[0][1]);

		for(int i=1;i<intervals.length;i++){
			//if the start time of current meeting is larger than the smallest end time,
			//which means the current meeting can use the same room
			//so poll() the smallest meeting room
			if(intervals[i][0]>=minHeap.peek()){
				minHeap.poll();
			}
			//and them add the end time of current meeting
			minHeap.add(intervals[i][1]);
		}
		return minHeap.size();
	}
}