/*
 * @lc app=leetcode id=4 lang=java
 *
 * [4] Median of Two Sorted Arrays
 */

// @lc code=start
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int n = nums1.length;
        int m = nums2.length;
        int left = 0;
        int right = 0;
        int start = 0;
        int end = n;
        int a;
        int b;
        //binary search for a 
        while (start <= end){
            a = (end+start)/2;
            b = (m+n+1)/2-a;
            if (a > start && nums1[a-1] > nums2[b]) {
                end = a-1;
            }
            else if (a < end && nums2[b-1] > nums1[a]){
                start = a+1;
            }
            else {
                if (a == 0) left = nums2[b-1];
                else if (b == 0) left = nums1[a-1];
                else if (nums1[a-1] >= nums2[b-1]) {
                    left = nums1[a-1];
                }
                else {
                    left = nums2[b-1];
                }
                if ((m+n)%2 == 1) {
                    right = left;
                }
                else {
                    if (a == n) {
                        right = nums2[b];
                    }
                    else if (b == m) {
                        right = nums1[a];
                    }
                    else {
                        right = Math.min(nums1[a],nums2[b]);
                    }
                }
                return (left + right)/2.0;
            }
        }
        return 0.0;
    }
}
// @lc code=end

