/*
A digit string is good if the digits (0-indexed) at even indices are even and the digits at odd indices are prime (2, 3, 5, or 7).
For example, "2582" is good because the digits (2 and 8) at even positions are even and the digits (5 and 2) at odd positions are prime. However, "3245" is not good because 3 is at an even index but is not even.
Given an integer n, return the total number of good digit strings of length n. Since the answer may be large, return it modulo 109 + 7.
A digit string is a string consisting of digits 0 through 9 that may contain leading zeros.
https://leetcode.com/problems/count-good-numbers/description/

TC: O(n)
SC: O(n)
 */


package Recursion;

public class GoodNumber {

    public static long MOD = 1_000_000_007;

    public static int countGoodNumbers(long n) {

        // Calculate the number of even and odd positions in the digit string
        long odd = n/2;
        long even = (n+1)/2;

        // Calculate the total number of good digit strings
        // multiplying 5 by even because there could only be 5 even numbers between 0-9
        // multiplying 4 by odd because there could only be 4 prime numbers between 0-9
        return (int)(pow(5,even) * pow(4,odd) % MOD);
    }

    public static long pow(long x, long n){

        // Base case for the recursion
        if(n==0)
            return 1;

        // Recursively calculate x^(n/2)
        long temp = pow(x,n/2);

        // If n is even, return (x^(n/2))^2
        if(n%2==0){
            return (temp * temp)% MOD;
        }
        // If n is odd, return (x^(n/2))^2 * x
        else{
            return (x * temp * temp)% MOD;
        }
    }

    public static void main(String[] args) {
        long n = 50;
        int result = countGoodNumbers(n);
        System.out.println(result);
    }
}
