class Solution {
	public int findMinArrowShots(int[][] points) {

		if(points.length==0) return 0;

		Arrays.sort(points, (arr1, arr2)->Integer.compare(arr1[0], arr2[0]));

		int preEnd = points[0][1];
		//the minimum number starts from 1, because at least you need one arrow for the first balloon
		int min_num = 1;

		for(int i=1;i<points.length;i++){
			if(preEnd<points[i][0]){
				preEnd = points[i][1];
				min_num++;
			}else{
				preEnd = Math.min(preEnd, points[i][1]);
			}
		}
		return min_num;
	}
}