in merging step, you can count the reverse pair
two time may cause integer overflow, so we need convert integer to long when multiply 2 * integer.

core idea is mergerSort perform recursion to  divide the array into two parts until the array 
has one element. then merge the sorted array. during merging the sorted array, if there is an element
on left side 2 time larger than right side, which means that all elements behind are also  2 time larger 
than right side. these are reverse pairs, and the count is mid-left+1
