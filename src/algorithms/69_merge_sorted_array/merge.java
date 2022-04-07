
// tc: O(M+N)

class Solution {
	public void merge(int[] nums1, int m, int[] nums2, int n) {

		//two pointers for nums1 and nums2
		int point1 = 0;
		int point2 = 0;

		int[] tmp = new int[m+n];

		for(int i=0;i<m+n;i++){
			//point2>=n 写在前面，因为n可能为0， 那么｜｜后面的条件将无法执行
			if(point2>=n || (point1<m && nums1[point1]<nums2[point2])){
				tmp[i]=nums1[point1];
				point1++;
			}
			else {
				tmp[i]=nums2[point2];
				point2++;
			}

		}
		for(int j=0;j<m+n;j++){
			nums1[j]=tmp[j];
		}

	}
}