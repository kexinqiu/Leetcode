1.We start with two pointers, leftleft and rightright initially pointing to 
the first element of the string SS.

2.We use the rightright pointer to expand the window until we get a desirable window 
i.e. a window that contains all of the characters of TT.

3.Once we have a window with all the characters, we can move the left pointer ahead one by one. 
If the window is still a desirable one we keep on updating the minimum window size.

4.If the window is not desirable any more, we repeat step \; 2step2 onwards.

Time: O(S+T)
S is the length of searching string. 
In the worst case we might end up visiting every element of string SS twice, 
once by left pointer and once by right pointer. 

T is the length of target string, which is the required number to build hashmap.

Space:O(s+t)
S:  when the window size is equal to the entire string S. we need to store all characters in array.
T:  we need store all unique characters in hashmap