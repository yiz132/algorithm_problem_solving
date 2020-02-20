/*
 * @lc app=leetcode id=91 lang=java
 *
 * [91] Decode Ways
 *
 * https://leetcode.com/problems/decode-ways/description/
 *
 * algorithms
 * Medium (23.57%)
 * Likes:    2082
 * Dislikes: 2351
 * Total Accepted:    341.1K
 * Total Submissions: 1.4M
 * Testcase Example:  '"12"'
 *
 * A message containing letters from A-Z is being encoded to numbers using the
 * following mapping:
 * 
 * 
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 
 * 
 * Given a non-empty string containing only digits, determine the total number
 * of ways to decode it.
 * 
 * Example 1:
 * 
 * 
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2
 * 6).
 * 
 */

// @lc code=start
class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 1;
        if (s.charAt(0) == '0') return 0;
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= s.length(); i++) {
            int prepre = s.charAt(i-2) - '0';
            int pre = s.charAt(i-1) - '0';
            if (prepre*10 + pre <= 26 && prepre*10+pre >= 10) dp[i] += dp[i-2];
            if (pre != 0) dp[i] += dp[i-1]; 
        }
        return dp[s.length()];
    }
}
// @lc code=end

