/*
 * @lc app=leetcode id=456 lang=java
 *
 * [456] 132 Pattern
 *
 * https://leetcode.com/problems/132-pattern/description/
 *
 * algorithms
 * Medium (28.55%)
 * Likes:    1090
 * Dislikes: 73
 * Total Accepted:    46.8K
 * Total Submissions: 163.2K
 * Testcase Example:  '[1,2,3,4]'
 *
 * 
 * Given a sequence of n integers a1, a2, ..., an, a 132 pattern is a
 * subsequence ai, aj, ak such
 * that i < j < k and ai < ak < aj. Design an algorithm that takes a list of n
 * numbers as input and checks whether there is a 132 pattern in the list.
 * 
 * Note: n will be less than 15,000.
 * 
 * Example 1:
 * 
 * Input: [1, 2, 3, 4]
 * 
 * Output: False
 * 
 * Explanation: There is no 132 pattern in the sequence.
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: [3, 1, 4, 2]
 * 
 * Output: True
 * 
 * Explanation: There is a 132 pattern in the sequence: [1, 4, 2].
 * 
 * 
 * 
 * Example 3:
 * 
 * Input: [-1, 3, 2, 0]
 * pre_min -1,-1,-1, -1
 * post_max 3  3  2   0
 * 
 * Output: True
 * 
 * Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1,
 * 3, 0] and [-1, 2, 0].
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean find132pattern(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int[] pre_mins = new int[nums.length];
        Stack<Integer> stack = new Stack<>(); 
        for (int i = 0; i < nums.length; i++){
            if (i == 0) {
                pre_mins[0] = nums[0];
            }
            else {
                pre_mins[i] = Math.min(pre_mins[i-1],nums[i]);
            }
        }
        for (int i = nums.length-1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                if (!stack.isEmpty() && pre_mins[i] < stack.peek()) {
                    return true;
                }
                stack.pop();
            }
            if (pre_mins[i] < nums[i]) stack.push(nums[i]);
        }
        return false;
    }
}
// @lc code=end

