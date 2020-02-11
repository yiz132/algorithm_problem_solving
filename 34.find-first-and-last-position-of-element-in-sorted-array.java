import java.util.Arrays;

/*
 * @lc app=leetcode id=34 lang=java
 *
 * [34] Find First and Last Position of Element in Sorted Array
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[] {-1,-1};
        if (nums[0] > target || nums[nums.length-1] < target) return new int[] {-1,-1};
        if (Arrays.binarySearch(nums,target) < 0) return new int[]{-1,-1};
        // find the last smaller one
        int l = 0;
        int r = nums.length;
        int[] res = new int[2];
        res[1] = nums.length-1;
        while (l < r) {
            int mid = (l+r) / 2;
            if (mid + 1 < nums.length && nums[mid] < target && nums[mid+1] == target) {
                res[0] = mid+1;
                break;
            }
            if (nums[mid] >= target) {
                r = mid;
            }
            else {
                l = mid+1;
            }
        }
        //find the first larger one
        l = 0;
        r = nums.length;
        while (l < r) {
            int mid = (l+r)/2;
            if (mid - 1 >= 0 && nums[mid] > target && nums[mid-1] == target) {
                res[1] = mid-1;
                break;
            }
            if (nums[mid] > target) {
                r = mid;
            }
            else {
                l = mid+1;
            }
        }
        return res;
    }
}
// @lc code=end

