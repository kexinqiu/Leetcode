Time: O(n)
Building the hashmap takes O(N) time, 
as there are N nodes to add, and adding items to a hashmap has a cost of O(1),
so we get N * O(1) = O(N).

Building the tree also takes O(N) time. 
The recursive helper method has a cost of O(1) for each call (it has no loops), 
and it is called once for each of the N nodes, giving a total of O(N).

Space: O(n)
Building the hashmap and storing the entire tree each requires O(N)O memory. 
The size of the implicit system stack used by recursion calls depends on the height of the tree, 
which is O(N) in the worst case and O(log N) on average. 
Taking both into consideration, the space complexity is O(N).