//1.没重叠，在之前
//2.重叠，确定merge的首尾
//3. 没重叠，在之后

//tc o（n）
//sc o（n）
class Solution {
	public int[][] insert(int[][] intervals, int[] newInterval) {

		int[][] res = new int[intervals.length+1][2];
		int index = 0;

		int i = 0;
		//首先遍历左边不重叠的区间
		while(i<intervals.length && intervals[i][1]<newInterval[0]){
			res[index++] = intervals[i++];
		}
		//当前遍历是有重叠的区间
		while(i<intervals.length && intervals[i][0]<=newInterval[1]){
			//左端取较小者
			newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
			//右端取较大者
			newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
			i++;
		}
		//重叠区遍历结束后，将merge的区间推入res
		res[index++] = newInterval;

		//遍历右边没重叠的区间
		while(i<intervals.length){
			res[index++] = intervals[i++];
		}

		return Arrays.copyOf(res, index);
	}
}