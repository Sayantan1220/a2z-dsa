/*
You are climbing a staircase. It takes n steps to reach the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
https://leetcode.com/problems/climbing-stairs/description/

TC: O(n)
SC: O(1)
 */


package dynamic_programming;

public class ClimbingStairs {
    public static int climbStairs(int n) {
        if(n==1 || n==2 || n==3) return n;
        return fibo(n, 2,3);
    }

    static int fibo(int n, int i, int j) {
        if(n==4) return i+j;
        return fibo(n-1, j, i+j);
    }

    public static void main(String[] args) {
        int result = climbStairs(4);
        System.out.println(result);
    }
}
