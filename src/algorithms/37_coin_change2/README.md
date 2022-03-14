solution: DP bottom-up

A: amount of money
C: length of coins[]

TC: O(A*C);
SC: O(A);

| coin  | 0 | 1 | 2 | 3 | 4 | 5 | 
|  []   | 1 | 0 | 0 | 0 | 0 | 0 | 
|  [1]  | 1 | 1 | 1 | 1 | 1 | 1 | 
| [1,2] | 1 | 1 | 2 | 2 | 3 | 3 | 
|[1,2,5]| 1 | 1 | 2 | 2 | 3 | 4 |

table[row][col] = table[row-1][col]+table[row][col-coins[row-1]]

for example, for the final amount, firstly, you need to think about the new coin 5, 5-5=0, for amount
0, there is one way; then, you need to think about with the new coin, there is 3 ways with coin 1 and
2