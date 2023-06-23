package dynamic_programming;

public class ClimbingStairs {
    public int climbStairs(int n) {
        if(n==1 || n==2 || n==3) return n;
        return fibo(n, 2,3);
    }

    int fibo(int n, int i, int j) {
        if(n==4) return i+j;
        return fibo(n-1, j, i+j);
    }
}
