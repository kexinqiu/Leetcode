import java.util.PriorityQueue;

//tc: for every addNum :o(logn)
//tc: for every findMedian: o(1)
class MedianFinder {

	PriorityQueue<Integer> small;
	PriorityQueue<Integer> large;

	public MedianFinder() {
		small = new PriorityQueue<>((a,b)->b-a);
		large = new PriorityQueue<>((a,b)->a-b);
	}
	//make sure the size of small is >= the size of large
	public void addNum(int num) {
		int size1 = small.size();
		int size2 = large.size();
		if(size1==size2){
			if(large.size()==0 || num<large.peek()) {
				small.offer(num);
			}else{
				large.offer(num);
				small.offer(large.poll());
			}
		}else{
			if(num>small.peek()){
				large.offer(num);
			}else{
				small.offer(num);
				large.offer(small.poll());
			}
		}
	}

	public double findMedian() {
		double median;
		int size1 = small.size();
		int size2 = large.size();
		if(size1==size2){
			median = (small.peek()+large.peek())/2.0;
		}else{
			median = small.peek();
		}
		return median;
	}

}


//tc: for every addNum :o(logn)
//tc: for every findMedian: o(1)
class MedianFinder {

	PriorityQueue<Integer> small;
	PriorityQueue<Integer> large;

	public MedianFinder() {
		small = new PriorityQueue<>((a, b)->{
			return b-a;
		});
		large = new PriorityQueue<>((a,b)->a-b);
	}

	public void addNum(int num) {
		//make sure the size of small queue is >= the size of large queue
		small.offer(num);
		large.offer(small.poll());
		if(small.size()<large.size()){
			small.offer(large.poll());
		}
	}

	public double findMedian() {

		if(small.size()==large.size()){
			return (small.peek()+large.peek())/2.0;
		}else{
			return small.peek();
		}
	}
}

//follow up:
//1. If all integer numbers from the stream are between 0 and 100, how would you optimize it?

//We can maintain an integer array of length 100 to store the count of each number along with a total count.
// Then, we can iterate over the array to find the middle value to get our median.
//Time and space complexity would be O(100) = O(1).

//2. If 99% of all integer numbers from the stream are between 0 and 100, how would you optimize it?

//In this case, we need an integer array of length 100 and a hashmap for these numbers that are not in [0,100].
//As 99% is between 0-100. As we know solution will be definitely in 0-100 we don't need to know those number which are >100 or <0, only count of them will be enough.

//1.
class MedianFinder {
	int A[] = new int[101], n = 0;

	// O(1)
	public void addNum(int num) {
		A[num]++;
		n++;
	}

	// O(100) = O(1)
	public double findMedian() {

		// find 1st median number
		int count = 0, i = 0;
		while (count < n/2) count += A[i++];

		// find 2nd median number
		int j = i;
		while (count < n/2+1) count += A[j++];

		return (n%2 == 1) ? i : (i-1+j-1) / 2.0;
	}
}

//2.
class MedianFinder {
	int A[] = new int[101], n = 0;
	int countLessZero = 0;
	// int countGreater100 = 0; // not needed

	// O(1)
	public void addNum(int num) {
		if (num < 0) countLessZero++;
			// else if (num > 100) countGreater100++;
		else A[num]++;
		n++;
	}

	// O(100) = O(1)
	public double findMedian() {

		// find 1st median number
		int count = countLessZero, i = 0;
		while (count < /2) count += A[i++];

		// find 2nd median number
		int j = i;
		while (count < n/2+1) count += A[j++];

		return (n%2 == 1) ? i : (i-1+j-1) / 2.0;
	}
}
