//Time complexity: O(NlogN)
//
//Sorting jobs according to their starting time will take O(NlogN) time.
//
//We iterate over all N jobs. For each job, we push the maximum profit job chain into the heap once which takes O(NlogN) time.
//
//The total time complexity is therefore equal to O(NlogN).

//按照start time排序往pq里插入，按照end time在pq内部进行排序，保证局部最优
//每一次叠加profit，都先找到目前profit最大的那条

class Solution {
	class The_Comparator implements Comparator<ArrayList<Integer>> {
		//ascending
		@Override
		public int compare(ArrayList<Integer> list1, ArrayList<Integer> list2) {
			return list1.get(0) - list2.get(0);
		}
	}

	private int findMaxProfit(List<List<Integer>> jobs) {
		int n = jobs.size(), maxProfit = 0;
		// min heap having {endTime, profit}
		//按照start time排序往pq里插入，按照end time在pq内部进行排序，可以保证如果start time满足，那么后面一定满足
		PriorityQueue<ArrayList<Integer>> pq = new PriorityQueue<>(new The_Comparator());

		for (int i = 0; i < n; i++) {
			int start = jobs.get(i).get(0), end = jobs.get(i).get(1), profit = jobs.get(i).get(2);

			// keep popping while the heap is not empty and
			// jobs are not conflicting
			// update the value of maxProfit
			while (!pq.isEmpty() && start >= pq.peek().get(0)) {
				maxProfit = Math.max(maxProfit, pq.peek().get(1));
				pq.poll();
			}

			ArrayList<Integer> combinedJob = new ArrayList<>();
			combinedJob.add(end);
			//加上maxProfit是因为pq按照升序排列，如果前面有start time满足那么后面一定也能够满足，关键是找到profit最大的那个chai
			combinedJob.add(profit + maxProfit);

			// push the job with combined profit
			// if no non-conflicting job is present maxProfit will be 0
			pq.add(combinedJob);
		}

		// update the value of maxProfit by comparing with
		// profit of jobs that exits in the heap
		while (pq.isEmpty() == false) {
			maxProfit = Math.max(maxProfit, pq.peek().get(1));
			pq.poll();
		}
		return maxProfit;
	}

	public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
		List<List<Integer>> jobs = new ArrayList<>();

		// storing job's details into one list
		// this will help in sorting the jobs while maintaining the other parameters
		int length = profit.length;
		for (int i = 0; i < length; i++) {
			List<Integer> currJob = new ArrayList<>();
			currJob.add(startTime[i]);
			currJob.add(endTime[i]);
			currJob.add(profit[i]);

			jobs.add(currJob);
		}

		Collections.sort(jobs, Comparator.comparingInt(a -> a.get(0)));
		return findMaxProfit(jobs);
	}
}