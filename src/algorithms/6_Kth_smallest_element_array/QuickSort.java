//quickSelection 参考quicksort
//只考虑半边
//o(n)
class Solution {
	public int findKthLargest(int[] nums, int k) {
		int l = 0;
		int r = nums.length-1;

		while(true){
			int finalPivot = partition(nums, l, r);

			if(finalPivot==nums.length-k) return nums[finalPivot];
			else if(finalPivot<nums.length-k) l = finalPivot+1;
			else r = finalPivot -1;
		}

	}

	private int partition(int[] nums, int l, int r){
		//本题必须随机初始化 pivot 元素，否则通过时间会很慢，因为测试用例中有极端测试用例。
         Random ran = new Random(0);
		//随机取起点l后任意index
        int pivotIndex = ran.nextInt(r-l+1)+l;
		//与r进行交换，换置最后
		swap(nums, r, pivotIndex);

		int pivotValue = nums[r];
		int i=l-1;

		for(int j=l;j<r;j++){
			if(nums[j]<pivotValue){
				i++;
				swap(nums, i, j);

			}
		}
		swap(nums, r, i+1);
		return i+1;
	}

	private void swap(int[] nums, int i, int j){
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}


//heap
//quickSelection 参考quicksort
//只考虑半边
//o(nlogk)
class Solution {
	public int findKthLargest(int[] nums, int k) {

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for(int i : nums){
			pq.add(i);

			if(pq.size()>k) pq.poll();
		}
		return pq.poll();
	}
}