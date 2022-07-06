//统计出每个点上下车人数
//如果没有限制条件1 <= trips.length <= 1000， 则不可以用这个方法
//tc: o(n)
//sc: o(1001)=o(1)
class Solution {
	public boolean carPooling(int[][] trips, int capacity) {
		if(trips[0][0]>capacity) return false;

		Arrays.sort(trips, (trip1, trip2)->Integer.compare(trip1[1], trip2[1]));

		int[] capacityChange = new int[1001];

		for(int i=0;i<trips.length;i++){
			capacityChange[trips[i][1]] -= trips[i][0];
			capacityChange[trips[i][2]] += trips[i][0];
		}

		for(int i=0;i<capacityChange.length;i++){
			capacity += capacityChange[i];

			if(capacity<0) return false;
		}

		return true;
	}
}

//priorityque

//tc: o(nlogn)
//sc: o(n)
class Solution {
	public boolean carPooling(int[][] trips, int capacity) {
		Arrays.sort(trips, (arrays1, arrays2)->Integer.compare(arrays1[1], arrays2[1]));
		// Arrays.sort(trips, new Comparator<int[]>(){
		//     public int compare(int[] i1, int[] i2) {
		//         return i1[1] - i2[1];
		//     }
		// });

		PriorityQueue<int[]> pq = new PriorityQueue<>(new MyCompare());
		//PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2]-b[2]);

		for(int i=0;i<trips.length;i++){
			while(!pq.isEmpty() && pq.peek()[2]<=trips[i][1]){
				capacity += pq.poll()[0];
			}

			pq.offer(trips[i]);
			capacity -= trips[i][0];
			if(capacity<0) return false;
		}


		return true;
	}
}

class MyCompare implements Comparator<int[]>{
	public int compare(int[] int1, int[] int2){
		return int1[2]-int2[2];
	}
}