//由于快照功能 snap() 的调用次数可能很多，所以我们如果采用每次快照都整体保存一次数组的方法，
// 无论在时间复杂度还是空间复杂度上，都是行不通的。那么更优化的方法是，只保存每次快照变化的部分。


//Instead of record the history of the whole array,
//we will record the history of each cell.
//And this is the minimum space that we need to record all information.

//For each A[i], we will record its history.
//With a snap_id and a its value.

//When we want to get the value in history, just binary search the time point.

class SnapshotArray {
	TreeMap<Integer, Integer>[] arr;
	int snap_id=0;

	public SnapshotArray(int length) {
		arr = new TreeMap[length];
		for(int i=0;i<length;i++){
			arr[i] = new TreeMap<Integer, Integer>();
			arr[i].put(0,0);
		}
	}

	public void set(int index, int val) {
		arr[index].put(snap_id, val);
	}

	public int snap() {
		return snap_id++;
	}

	//同一个index的history，可能存在很多次snap操作，不同的snap_id
	public int get(int index, int snap_id) {
		int n = arr[index].floorEntry(snap_id).getValue();
		return n;
	}
}
