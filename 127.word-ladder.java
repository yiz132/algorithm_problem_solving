import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/*
 * @lc app=leetcode id=127 lang=java
 *
 * [127] Word Ladder
 */

// @lc code=start
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for (String s : wordList) set.add(s);
        if (!set.contains(endWord)) return 0;
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int res = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                String curr = queue.poll();
                if (curr.equals(endWord)) {
                    return res;
                }
                StringBuilder sb = new StringBuilder(curr);
                for (int i = 0; i < curr.length(); i ++) {
                    for (char c = 'a'; c <='z'; c++) {
                        if (c != curr.charAt(i)) {
                            sb.setCharAt(i,c);
                            if (set.contains(sb.toString())){
                                queue.add(sb.toString());
                                set.remove(sb.toString());
                            }
                            sb.setCharAt(i,curr.charAt(i));
                        }
                    }
                }
            }
            res ++;
        }
        return 0;
    }
}
// @lc code=end

