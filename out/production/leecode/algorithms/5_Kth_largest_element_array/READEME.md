quickSort is better, because you can firstly divide integers into two parts, put smaller elements on left,
put larger elements on right. and then verify which part the Kth largest element is in. and then 
perform recursion on that side.


1.quick_sort:

O(n)
first partition, choose a dividing point, and the move all the data less than the point into left side and
the data larger than the point into right side. and then perform recursion on both sides.

2. merge_sort:
O(nlogn)
first, choose the middle point and divide array into left side and right side.
and then perform recursion to sort both sides. in the end, combine two part into one.

