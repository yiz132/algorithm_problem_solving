import java.util.Arrays;

/*
 * @lc app=leetcode id=973 lang=java
 *
 * [973] K Closest Points to Origin
 */

// @lc code=start
//if using sort or heap, this should be quite easy
// Divide and Conquer (inspired by Quick Sort, partition)
/*  1, 2, 5, 3, 6, 2
    1, 2, 5, 3, 2, 6
    1, 2, 2, 3, 5, 6
*/
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        int l = 0;
        int r = points.length;
        while (l < r) {
            int smaller_counts = helper(points,l,r); //smaller and itself
            if (smaller_counts == K) break;
            if (smaller_counts < K) {
                l = smaller_counts+1;
            }
            else {
                r = smaller_counts-1;
            }
        }
        return Arrays.copyOfRange(points,0,K);
    }

    private int helper(int[][] points, int l , int r) {
        int curr = l;
        for (int i = l+1; i <= r; i ++) {
            if (distance(points[i]) < distance(points[l])) {
                curr ++;
                swap(points,i,curr);
            }
        }
        swap(points,l,curr);
        return curr;
    }

    private void swap(int[][] points, int l, int r) {
        int[] temp = points[l];
        points[l] = points[r];
        points[r] = temp; 
    }

    private int distance(int[] point){
        return point[0]*point[0] + point[1]*point[1];
    }
}
// @lc code=end

