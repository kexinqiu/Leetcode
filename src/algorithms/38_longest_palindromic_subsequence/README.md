solution: DP bottom-up

A: amount of money
C: length of coins[]

TC: O(A*C);
SC: O(A);

s='bbbab'
dp[i][j], [i]is start index, [j]is end index
for example dp[3,4]->'ab' 
look at [1][4], characters at both ends are equal, then 2+dp[2][3], we need the cache on the bottom and
left, which means we will traverse out string from right->left, from short length to long length

there are two cases to compare characters:
if (s.charAt(i) == s.charAt(j)) {
dp[i][j] = dp[i+1][j-1] + 2;
//if the characters at both ends are not equal, we need shrink our window
} else {
dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
}
dp  | 0 | 1 | 2 | 3 | 4 | 
| 0 | 1 | 2 | 3 | 3 | 4 |
| 1 | 0 | 1 | 2 | 3 | 3 |
| 2 | 0 | 0 | 1 | 3 | 2 |
| 3 | 0 | 0 | 0 | 1 | 1 |
| 4 | 0 | 0 | 0 | 0 | 1 | 