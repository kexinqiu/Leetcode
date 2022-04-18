//sort function
class Solution {
	public int[][] kClosest(int[][] points, int K) {
		Arrays.sort(points, (p1, p2) -> p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1]);
		return Arrays.copyOfRange(points, 0, K);
	}
}

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

//quickselect
class Solution {
	public int[][] kClosest(int[][] points, int K) {
		int len =  points.length, l = 0, r = len - 1;
		while (l <= r) {
			int mid = helper(points, l, r);
			if (mid == K) break;
			if (mid < K) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		return Arrays.copyOfRange(points, 0, K);
	}

	private int helper(int[][] A, int l, int r) {
		int[] pivot = A[l];
		while (l < r) {
			while (l < r && compare(A[r], pivot) >= 0) r--;
			A[l] = A[r];
			while (l < r && compare(A[l], pivot) <= 0) l++;
			A[r] = A[l];
		}
		A[l] = pivot;
		return l;
	}

	private int compare(int[] p1, int[] p2) {
		return p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1];
	}
}
