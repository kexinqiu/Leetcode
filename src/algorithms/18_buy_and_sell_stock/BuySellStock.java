class Solution {
	public int maxProfit(int[] prices) {

		int profit = 0;

		if(prices.length<1) return profit;

		//assume the first element as the stock with lowest price
		int bought = prices[0];

		//traverse prices from left to right
		for(int i=1; i<prices.length; i++){
			//if the new element is larger than bought price, we need to compare with the difference, and keep the higher profit
			if(prices[i]>bought){
				if(profit<prices[i]-bought)
					profit = prices[i]-bought;

			}else{
				//if the new element is less or equal to bought, which means there is possible to have a higher profit, we need to store the new bought price and compare the difference.
				bought = prices[i];
			}
		}

		return profit;

	}
}
