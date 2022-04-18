import java.util.ArrayList;
//binary search to find the left bound
class Solution {
	public List<Integer> findClosestElements(int[] arr, int k, int x) {
		// Initialize binary search bounds
		int left = 0;
		int right = arr.length - k;

		// Binary search against the criteria described
		while (left < right) {
			int mid = (left + right) / 2;
			if (x - arr[mid] > arr[mid + k] - x) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}

		// Create output in correct format
		List<Integer> result = new ArrayList<Integer>();
		for (int i = left; i < left + k; i++) {
			result.add(arr[i]);
		}

		return result;
	}
}

//two pointers
 class Solution {
     public List<Integer> findClosestElements(int[] arr, int k, int x) {
      int lo = 0;
 		int hi = arr.length - 1;
 		while (hi - lo >= k) {
 			if (Math.abs(arr[lo] - x) > Math.abs(arr[hi] - x)) {
 				lo++;
 			} else {
 				hi--;
 			}
 		}
 		List<Integer> result = new ArrayList<>(k);
 		for (int i = lo; i <= hi; i++) {
 			result.add(arr[i]);
 		}
 		return result;
     }
 }