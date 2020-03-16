package crackCodeInterview;

public class PrintNumsWithNDigits {
    int[] num;
    public void printNumsWithN(int n){
        this.num = new int[n]; //index 0 -> last digit
        recursion(n,0);
    }

    private void recursion(int n, int index){
        if (index == n-1) {
            for (int curr = 0; curr <= 9; curr++) {
                this.num[index] = curr;
                printNum();
            }
            return;
        }
        for (int curr = 0; curr <= 9; curr++) {
            this.num[index] = curr;
            recursion(n,index+1);
        }
    }

    private void printNum() {
        int i = 0;
        while (i < num.length && num[i] == 0) {
            i ++;
        }
        for ( ; i < this.num.length; i++) {
            System.out.print(this.num[i]);
        }
        System.out.println();
    }


    public static void main(String[] args) {
        int n = 7;
        PrintNumsWithNDigits pn = new PrintNumsWithNDigits();
        pn.printNumsWithN(n);
    }
}