/**
 * Problem: Job Sequencing Problem
 * Platform: GFG
 * Difficulty: Medium
 * Pattern: Greedy approach
 * Solve Type: Fully Viewed — needs re-attempt
 *
 * Key Insight:create class Jobs to store deadline and profit. sort according to deadline to take max profit and
                if pq.size() > curr deadline remove the least profit job

 * Time: O(NlogN)
 * Space: O(N)
 */
class Solution {
	public class Jobs {
		// d and p were parameters
		// deadline and profit are instance variables
		int deadline;
		int profit;
		public Jobs(int deadline, int profit) {
			this.deadline = deadline;
			this.profit = profit;
		}
	}
	public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
		// code here
		// try to place the jobs as close as their deadline so that
		// jobs have tighter deadline have place
		
		int n = deadline.length;
		Jobs[] jobs = new Jobs[n];
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for (int i = 0; i<n; i++) {
			jobs[i] = new Jobs(deadline[i], profit[i]);
		}
		
		Arrays.sort(jobs, (a, b) -> Integer.compare(a.deadline, b.deadline));
		
		// The size of the Min-Heap represents the number of time slots we have
		// used so far.
		for (int i = 0; i<n; i++) {
			pq.add(jobs[i].profit);
			
			// If the number of jobs in the heap exceeds the current deadline,
			// we must drop the least profitable job to stay within time constraints.
			if (pq.size() > jobs[i].deadline) pq.poll(); // throws no error when empty
		}
		
		int jobsDone = pq.size();
		int maxProfit = 0;
		
		while (!pq.isEmpty()) {
			maxProfit += pq.poll();
		}
		
		ArrayList<Integer> res = new ArrayList<>();
		res.add(jobsDone);
		res.add(maxProfit);
		return res;
	}
}
