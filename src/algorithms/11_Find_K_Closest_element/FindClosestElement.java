import java.util.ArrayList;

class Solution {

	public List<Integer> findClosestElements(int[] arr, int k, int x) {

		int l = 0;
		int r = arr.length-k;

		while(l<r){
			int mid = l + (r-l)/2;
			if(x-arr[mid]>arr[mid+k]-x) l=mid+1;
			else r=mid;
		}

		List<Integer> tmp = new ArrayList<Integer>();
		for(int i=0; i<l+k; i++){
			tmp.add(arr[i]);
		}
 		return tmp;
	}
}