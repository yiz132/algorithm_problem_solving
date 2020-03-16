package crackCodeInterview;

import java.util.ArrayList;
import java.util.List;

class AllPossibleStrings {
    List<String> list;
    char[] input;
    public String[] permutation(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        list = new ArrayList<>();
        input = s.toCharArray();
        dfs(0);
        String[] res = new String[list.size()];
        for (int i = 0; i < res.length; i ++) {
            res[i]=list.get(i);
        }
        return res;
    }
    
    private void dfs(int start){
        if (start == input.length) {
            list.add(new String(input));
            return;
        }
        boolean[] used = new boolean[256];
        for (int i = start; i < input.length; i++) {
            if (start != i && input[start] == input[i] || used[input[i]]) {
                continue;
            }
            used[input[i]] = true;
            swap(start,i);
            dfs(start+1);
            swap(start,i);
        }
    }
    
    private void swap(int i, int j) {
        char temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
}