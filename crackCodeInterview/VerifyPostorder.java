package crackCodeInterview;

class VerifyPostorder {
    public boolean verifyPostorder(int[] postorder) {
        return verify(postorder,0,postorder.length-1);
    }
    
    private boolean verify(int[] post, int start, int end){
        if (start >= end) {
            return true;
        }
        int root = post[end];
        int mid = start;
        while (post[mid] < root) {
            mid++;
        }
        boolean left = verify(post,start,mid-1);
        for (int i = mid; i < end; i++) {
            if (post[i] < root) {
                return false;
            }
        }
        boolean right = verify(post,mid,end-1);
        return left && right;
    }
}