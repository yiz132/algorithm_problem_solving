import java.util.Stack;

/*
 * @lc app=leetcode id=394 lang=java
 *
 * [394] Decode String
 */

// @lc code=start
class Solution {
    private int i = 0;
    public String decodeString(String s) {
        if (s == null || s.length() == 0) return "";
        return recursion(s);
    }

    private String recursion(String s) {
        int counts = 0;
        StringBuilder sb = new StringBuilder();
        while (i < s.length()) {
            char c = s.charAt(i++);
            if (c == '[') {
                String sub = recursion(s);
                if (counts == 0) {
                    sb.append(sub);
                }
                else {
                    for (int j = 0; j < counts; j++) {
                        sb.append(sub);
                    }
                    counts = 0;
                }
            }
            else if (Character.isDigit(c)) {
                counts = 10 * counts + c - '0';
            }
            else if (c == ']'){
                return sb.toString();
            }
            else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
// @lc code=end

