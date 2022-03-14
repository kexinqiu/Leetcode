solution: DP bottom-up

A: amount of money
C: length of coins[] 

TC: O(A*C);
SC: O(A);

						coins=[1,2,5]
amount  / index         | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | ... | amount |
fewest number of coins  | 0 | 1 | 1 | 2 | 2 | 1 | 2 | 2 | 3 | ... | amount |
