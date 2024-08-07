package basic.template;

public class BinarySearch {
	public int search(int[] nums, int target) {
		int l = 0;
		int r = nums.length - 1;

		while (l <= r) {
			int mid = l + (r - l) / 2; // 防止溢出 等同于(left + right)/2
			if (nums[mid] == target) return mid;
			else if (nums[mid] > target) r = mid - 1;
			else l = mid + 1;
		}

		return -1;
	}
}
