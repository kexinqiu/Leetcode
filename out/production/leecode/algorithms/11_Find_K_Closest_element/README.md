findClosestElements find the closet integers to target in sorted arr[]  and return them in ascending array

find the window that includes k integers by determining the left boundary of this window

the left boundary is from 0 to length of array minus k

use binary search to cut the array

compare the gap between target x and midpoint with the gap between x and midpoint+k

there are 4 cases:

 mid----------x---mid+k     l+mid+1
 mid--------------mid+k--x   l+mid+1
 mid-----x--------mid+k     r=mid
 x---mid----------mid+k     r=mid
 
then you will find the left boundary of this window includes k integers

for loop