prefix sum can get sum of any continuous subarrays

 [1, 2, 4, 1]

sum[1:2] = sum[0:2]-sum[0:0]  


dynamic programing
usa an array called preSum to sava all the sum of index 0 to i

int[] nums length=n
int[] sum  length=n+1

preSum[0]=0;
preSum[1]=preSum[0]+nums[0];
preSum[2]=preSum[1]+nums[1];

get the sum from 0 to 1
preSum[2]-preSum[0]

we can always get the subarray sum by substraction