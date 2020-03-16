package crackCodeInterview;

class InversePairs {
    private int[] new_nums;
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        new_nums = new int[nums.length];
        return recursion(nums,0,nums.length-1);
    }
    
    private int recursion(int[] nums, int start, int end) {
        if (start >= end) {
            return 0;
        }
        int mid = start + (end-start)/2;
        int left = recursion(nums,start,mid);
        int right = recursion(nums,mid+1,end);
        int res = 0;
        int i = mid;
        int j = end;
        int k = end;
        while (i >= start || j >= mid+1) {
            if (i == start-1) {
                new_nums[k--] = nums[j--];
            }
            else if (j == mid) {
                new_nums[k--] = nums[i--];
            }
            else if (nums[i] > nums[j]) {
                res += j-mid;
                new_nums[k--] =nums[i--];
            }
            else {
                new_nums[k--] = nums[j--];
            }
        }
        System.arraycopy(new_nums,start,nums,start,end-start+1);
        return res + left +right;
    }
}