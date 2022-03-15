 Code
========

### LeetCode Problems

| #   | Title                                                                                                                   | Solution                                                                                  | Difficulty                                                           | Algorithms                                    |
|-----|-------------------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------|----------------------------------------------------------------------|-----------------------------------------------|
| 1   | [Valid Palindrome](https://leetcode.com/problems/valid-palindrome/)                                                     | [Java](./algorithms/1_valid_palindrome/ValidPalindrome.java)                              | [easy](./algorithms/1_valid_palindromem/README.md)                   | 双指针  O(n)                                     |
| 2   | [Valid Palindrome](https://leetcode.com/problems/valid-palindrome-ii/)                                                  | [Java](./algorithms/2_valid_palindrome2/ValidPalindrome2.java)                            | [easy](./algorithms/2_valid_palindromem2/README.md)                  | 双指针  O(n)                                     |
| 3   | [Palindromic Substrings](https://leetcode.com/problems/palindromic-substrings/)                                         | [Java](./algorithms/34_palindromic_substring/CountSubstring.java)                         | [medium]()                                                           | expand from midpoint with two pointers O(n^2) |
| 4   | [Longest Palindromic Substring](https://leetcode.com/problems/longest-palindromic-substring/)                           | [Java](./algorithms/35_longest_palindromic_substring/LongestPalindromic.java)             | [medium](./algorithms/35_longest_palindromic_substring/README.md)    | expand from midpoint with two pointers O(n^2) |
| 5   | [Two Sum](https://leetcode.com/problems/two-sum/)                                                                       | [Java](./algorithms/3_two_sum/hashmap/TwoSum.java)                                        | [easy](./algorithms/3_two_sum/hashmap/README.md)                     | hashmap  O(n)                                 |
| 6   | [Two Sum](https://leetcode.com/problems/two-sum/)                                                                       | [Java](./algorithms/3_two_sum/two_pointer/TwoSum2.java)                                   | [easy](./algorithms/3_two_sum/two_pointer/README.md)                 | 双指针  O(nlogn)                                 |
| 7   | [Sort Array](https://leetcode.com/problems/sort-an-array/)                                                              | [Java](./algorithms/4_sort_array/QuickSort.java)                                          | [easy](./algorithms/4_sort_array/README.md)                          | quickSort  O(nlogn)                           |
| 8   | [Sort Array](https://leetcode.com/problems/sort-an-array/)                                                              | [Java](./algorithms/4_sort_array/MergeSort.java)                                          | [easy](./algorithms/4_sort_array/README.md)                          | MergeSort  O(nlogn)                           |
| 9   | [Kth Largest Element in Array](https://leetcode.com/problems/kth-largest-element-in-an-array/)                          | [Java](./algorithms/5_Kth_largest_element_array/MergeSort.java)                           | [medium](./algorithms/5_Kth_largest_element_array/README.md)         | MergeSort  O(nlogn)                           |
| 10  | [Kth Largest Element in Array](https://leetcode.com/problems/kth-largest-element-in-an-array/)                          | [Java](./algorithms/5_Kth_largest_element_array/QuickSort.java)                           | [medium](./algorithms/5_Kth_largest_element_array/README.md)         | QuickSort  O(n) 只需要半边                         |
| 11  | [Kth Smallest Element in Array](https://leetcode.com/problems/kth-largest-element-in-an-array/)                         | [Java](./algorithms/6_Kth_smallest_element_array/QuickSort.java)                          | [medium](./algorithms/6_Kth_smallest_element_array/README.md)        | QuickSort  O(n) 只需要半边                         |
| 12  | [Reverse Pairs](https://leetcode.com/problems/reverse-pairs/)                                                           | [Java](./algorithms/7_reverse_pairs/MergeSort.java)                                       | [hard](./algorithms/7_reverse_pairs/README.md)                       | MergeSort  O(nlogn) 只需要半边                     |
| 13  | [Find Position in Sorted Array](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/) | [Java](./algorithms/8_find_position_in_sorted_array/BinarySearch.java)                    | [medium](./algorithms/8_find_position_in_sorted_array/README.md)     | BinarySearch  O(logn)    用于sorted array       |
| 14  | [Sqrt(x)](https://leetcode.com/problems/sqrtx/)                                                                         | [Java](./algorithms/9_sqrt/Squrt.java)                                                    | [easy](./algorithms/9_sqrt/README.md)                                | BinarySearch  O(logn) 用于sorted array          |
| 15  | [Search a 2D Matrix](https://leetcode.com/problems/search-a-2d-matrix/)                                                 | [Java](./algorithms/10_search_2d_matrix/SearchMatrix.java)                                | [medium](./algorithms/10_search_2d_matrix/README.md)                 | BinarySearch  O(logn) 用于sorted array          |
| 16  | [Find K Closest Elements](https://leetcode.com/problems/find-k-closest-elements/)                                       | [Java](./algorithms/11_find_K_closest_element/FindClosestElement.java)                    | [medium](./algorithms/11_find_K_closest_element/README.md)           | BinarySearch  O(logn) 用于sorted array          |
| 17  | [3sum](https://leetcode.com/problems/3sum/)                                                                             | [Java](./algorithms/12_3sum/3sum.java)                                                    | [medium](./algorithms/12_3sum/README.md)                             | two-pointers  O(n^2)                          |
| 18  | [4sum](https://leetcode.com/problems/4sum/)                                                                             | [Java](./algorithms/13_4sum/3sum.java)                                                    | [medium](./algorithms/13_4sum/README.md)                             | two-pointers  O(n^2)                          |
| 19  | [ksum](https://leetcode.com/problems/4sum/)                                                                             | [Java](./algorithms/14_ksum/4sum.java)                                                    | [medium](./algorithms/14_4sum/README.md)                             | two-pointers  O(n^2)                          |
| 20  | [contain_duplicate](https://leetcode.com/problems/contains-duplicate/)                                                  | [Java](./algorithms/15_contain_duplicate/ContainDuplication.java)                         | [easy]()                                                             | sort+for loop O(nlogn)     hashset O(n)       |
| 21  | [4sum2](https://leetcode.com/problems/4sum-ii/)                                                                         | [Java](./algorithms/16_4sum2/4sum2.java)                                                  | [medium](./algorithms/16_4sum2/README.md)                            | hashmap  O(n^2)                               |
| 22  | [Implement Queue using stacks](https://leetcode.com/problems/implement-queue-using-stacks/)                             | [Java](./algorithms/17_queue_by_stacks/QueueByStack.java)                                 | [medium](./algorithms/17_queue_by_stacks/README.md)                  | stack   Amortized time complexity = O(1)      |
| 23  | [Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)                                    | [Java](./algorithms/18_buy_and_sell_stock/BuySellStock.java)                              | [easy](./algorithms/18_buy_and_sell_stock/README.md)                 | O(n)                                          |
| 24  | [Valid Anagram](https://leetcode.com/problems/valid-anagram/)                                                           | [Java](./algorithms/19_valid_anagram/ValidAnagram.java)                                   | [easy](./algorithms/19_valid_anagram/README.md)                      | O(n)                                          |
| 25  | [Maximum Subarray](https://leetcode.com/problems/maximum-subarray/)                                                     | [Java](./algorithms/20_maximum_subarray/MaxSubarray.java)                                 | [easy](./algorithms/20_maximum_subarray/README.md)                   | Kadane O(n)                                   |
| 26  | [Valid Parentheses](https://leetcode.com/problems/valid-parentheses/)                                                   | [Java](./algorithms/21_valid_parentheses/ValidParenthese.java)                            | [easy]()                                                             | O(n)                                          |
| 27  | [Product of Array Except Self](https://leetcode.com/problems/product-of-array-except-self/)                             | [Java](./algorithms/22_product_of_array_ecept_self/ProductExceptSelf.java)                | [medium]()                                                           | O(n)                                          |
| 28  | [Merge Intervals](https://leetcode.com/problems/merge-intervals/)                                                       | [Java](./algorithms/23_merge_intervals/MergeIntervals.java)                               | [medium](./algorithms/23_merge_intervals/README.md)                  | O(nlogn)                                      |
| 29  | [Group Anagrams](https://leetcode.com/problems/group-anagrams/)                                                         | [Java](./algorithms/24_group_anagrams/GroupAnagrams.java)                                 | [medium](./algorithms/24_group_anagrams/README.md)                   | O(m*logn)                                     |
| 30  | [Container with most water](https://leetcode.com/problems/container-with-most-water/)                                   | [Java](./algorithms/25_container_most_water/MaxArea.java)                                 | [medium](./algorithms/25_container_most_water/README.md)             | two pointer O(n)                              |
| 31  | [Find Minimum in Rotated Sorted Array](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)             | [Java](./algorithms/26_find_min_in_rotated_sorted_array/FindMin.java)                     | [medium](./algorithms/26_find_min_in_rotated_sorted_array/README.md) | binary search O(logn)  sorted array 是信号       |
| 32  | [LinkedList Cycle](https://leetcode.com/problems/linked-list-cycle/)                                                    | [Java](./algorithms/27_linkedList_cycle/hasCycle.java)                                    | [easy]()                                                             | two pointer O(n)                              |
| 33  | [Reverse LinkedList](https://leetcode.com/problems/reverse-linked-list/)                                                | [Java](./algorithms/28_reverse_LinkedList/ReverseLinkedList.java)                         | [easy]()                                                             |                                               |
| 34  | [Longest Substring Without Repeating](https://leetcode.com/problems/longest-substring-without-repeating-characters/)    | [Java](./algorithms/29_longest_substring_without_repeating/lengthOfLongestSubstring.java) | [medium]()                                                           | sliding window  / two pointers      O(n)      |
| 35  | [Longest Repeating Character Replacement](https://leetcode.com/problems/longest-repeating-character-replacement/)       | [Java](./algorithms/30_longest_repeating_replacement/characterReplacement.java)           | [medium]()                                                           | sliding window  / two pointers      O(n)      |
| 36  | [Remove Nth Node From End of List](https://leetcode.com/problems/remove-nth-node-from-end-of-list/)                     | [Java](./algorithms/31_remove_nth_node_from_end/RemoveNthFromEnd.java)                    | [medium](./algorithms/31_remove_nth_node_from_end/README.md)         |                                               |
| 37  | [Number of Islands](https://leetcode.com/problems/number-of-islands/)                                                   | [Java](./algorithms/32_numbers_of_Islands/NumIsLand.java)                                 | [medium]()                                                           | DFS                                           |
| 38  | [417 Pacific Atlantic Water Flow](https://leetcode.com/problems/pacific-atlantic-water-flow/)                           | [Java](./algorithms/33_pacific_atlantic_water_flow/PacificAtlantic.java)                  | [medium]()                                                           | DFS                                           |
| 39  | [322 Coin Change](https://leetcode.com/problems/coin-change/)                                                           | [Java](./algorithms/36_coin_change/CoinChange.java)                                       | [medium](./algorithms/36_coin_change/README.md)                      | bottom-up                                     |
| 40  | [417 Coin Change2](https://leetcode.com/problems/pacific-atlantic-water-flow/)                                          | [Java](./algorithms/37_coin_change2/CoinChange.java)                                      | [medium](./algorithms/37_coin_change2/README.md)                     | bottom-up                                     |


|1| sliding window 多用于 longest or shortest/ maximum or minimum substring
|2| binary search 用于sorted array

### Fun Problems

| topic | Title | Solution |
|-------| ----- | -------- |
|binary search|[Find Local Minimum](./algorithms/java/fun_find_local_minimum_in_unsorted_array/README.md)|[Java](./algorithms/java/fun_find_local_minimum_in_unsorted_array/FindLocalMin.java)|

### Data Structures

| Data Structures | Implementation |
|--|--|
|Queue|[Java](./data_structures/queue/Queue.java)|
|Min Heap / PriorityQueue|[Java](./data_structures/min_heap/MinHeap.java)|
|HashMap|[Java](./data_structures/hashmap/HashMap.java)|
|Tree Inorder Iterator|[Java](./data_structures/tree_iterator/InorderIterator.java)|
|Binary Search Tree Inorder Asc/Des Iterator|[Java](./data_structures/tree_iterator/AscDesInorderIterator.java)|
|Tree Preorder Iterator|[Java](./data_structures/tree_iterator/PreorderIterator.java)|
|Tree Postorder Iterator|[Java](./data_structures/tree_iterator/PostorderIterator.java)|
|Union Find|[Java](./data_structures/union_find/UnionFind.java)|
|Trie|[Java](./data_structures/trie/Trie.java)|
|Segment Tree|[Java](./data_structures/segment_tree/SegmentTree.java)|

### Designs

| Designs | Implementation |
|--|--|
|[Browser History](./designs/browser_history/README.md)|[Java](./designs/browser_history/BrowserHistory.java)|
|[Design Add Remove Find Random APIs in O(1) time](./designs/design_add_remove_find_random_in_o1/README.md)|[Java](./designs/design_add_remove_find_random_in_o1/NewDataStructure.java)|
|[Auto Spell Correction](./designs/auto_spell_correction/README.md)|[Java](./designs/auto_spell_correction/SpellCorrection.java)|


How to explain code:
1.document your assumption(size, 数据范围， 升序降序)
2.explain your approach and how you intend to solve the problem (先讲明白要做什么，再写代码)
3.provide code comments where applicable
4.explain the big-o run time complexity 
5.identify any additional data structures you used and justify why you used them
6.only provide your best answer

explain code:
from high level to details

//selection sorts and array a[] with size n in ascending order
void SelectionSort(int a[], int n){
	int global, tmp;
	for(int i=0;i<n-1;i++){//outer loop: how many iterations
		global = i;
		for(int j=i+1;j<n;j++){//inner loop:find the global minimum from the rest elements.
			if(a[j]<a[global]){
               //record the index of the smallest element
				global = j;
			}
		}
       // swap the global (a[index]) minimum with a[i];
		tmp = a[i];
        a[i]=a[global];
		a[global]=tmp;
	}
}