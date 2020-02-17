import java.util.Arrays;

/*
 * @lc app=leetcode id=322 lang=java
 *
 * [322] Coin Change
 */

// @lc code=start
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        for (int i = 0; i <= amount; i ++) {
            if (i == 0) {
                dp[0] = 0;
            }
            else {
                for (int coin : coins) {
                    if (i - coin < 0) continue;
                    dp[i] = Math.min(dp[i-coin]+1,dp[i]);
                }
            }
        }
        return dp[amount] == amount+1 ? -1 :dp[amount];
    }
}
// @lc code=end

