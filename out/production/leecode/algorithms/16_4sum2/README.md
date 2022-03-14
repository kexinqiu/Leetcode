
//	Time complexity: put and get methods for hashing can be considered constant complexity O(1).
//	Each double loop complexity has quadratic complexity O(N^2), repeated two times.
//	Hence, Total Time complexity will be: O(2 N^2) + O(1) = O(N^2)
//
//	Space complexity: how mush space you add? map.put add a row in the map, here you are adding space in the memory.
//	How much space? the number of times of the double for loop: O(N^2). Second double loop does not add space, has only get method.
//	For loops themselves add only variable j and i in the memory, considered O(1), as well as the other variables in the code.
//	Hence, Total Space Complexity will be: O(N^2) + O(1) = O(N^2)