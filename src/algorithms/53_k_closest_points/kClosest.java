
//priorityqueue
//tc: O(nlogk)
class Solution {
	public int[][] kClosest(int[][] points, int k) {
		//priorityqueue sort the distance^2 in maxHeap
		//smallest k using maxHeap, largest k using minHeap, so that the time complixity could be O(nlogk)
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(
			(a,b)->b[0]*b[0]+b[1]*b[1]-a[0]*a[0]-a[1]*a[1]
		);
		//store smallest k elements
		for(int i=0;i<points.length;i++){
			pq.add(points[i]);

			if(pq.size()>k){
				pq.poll();
			}
		}

		int[][] res = new int[k][2];
		while(k>0){
			res[--k]=pq.poll();
		}
		return res;
	}
}

