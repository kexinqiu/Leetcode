class Solution {
	//bottom-up
	public int change(int amount, int[] coins) {
		int[] dp = new int[amount+1];
		//whatever coins you have, there is only one way to make up amount 0
		dp[0]=1;

		for(int coin:coins){
			//there is no need to consider the amount less than the coin
			for(int i=coin;i<=amount;i++){
				//the number of ways always adds up
				//the number of ways without the news coin and
				//the number of ways with the new coin
				dp[i] += dp[i-coin];
			}
		}
		return dp[amount];
	}
}