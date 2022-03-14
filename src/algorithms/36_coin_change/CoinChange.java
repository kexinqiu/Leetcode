import java.util.Arrays;

class Solution {
	public int coinChange(int[] coins, int amount) {
		//This table will store the answer to our sub problems
		//the size is amount+1, because dp[0] = 0, we won't store anything
		int[] dp = new int[amount+1];
		//we fill the array with the number amount+1
		Arrays.fill(dp, amount+1);
		//The answer to making change with minimum coins for 0 will always be 0 coins
		dp[0] = 0;
		//Solve every subproblem from 1 to amount
		for(int i=1; i<=amount;i++){
			// For each coin we are given
			for(int coin: coins){
				//if the coin is larger than the amount of money, we can't make up that amount
				if(coin<=i){
					//always get the mininum number of coins
					dp[i] = Math.min(dp[i], dp[i-coin]+1);
				}
			}
		}
		// dp[amount] holds the answer
		//If we do not have an answer then dp[amount] will be amount + 1
		//and hence dp[amount] > amount will be true. We then return -1.
		return dp[amount]>amount ? -1:dp[amount];
	}
}