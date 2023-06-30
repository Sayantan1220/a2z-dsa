/*
At a lemonade stand, each lemonade costs $5. Customers are standing in a queue to buy from you and order one at a time
(in the order specified by bills). Each customer will only buy one lemonade and pay with either a $5, $10, or $20 bill.
You must provide the correct change to each customer so that the net transaction is that the customer pays $5.
Note that you do not have any change in hand at first.
Given an integer array bills where bills[i] is the bill the ith customer pays,
return true if you can provide every customer with the correct change, or false otherwise.
https://leetcode.com/problems/lemonade-change/description/

TC: O(n)
SC: O(1)
 */

package array;

public class LemonadeChange {
    public static boolean lemonadeChange(int[] bills) {
        int count5=0;
        int count10=0;
        int count20=0;

        for(int bill: bills){
            // if encounter 5 then collect it simply
            if(bill==5 ) count5+=5;

            else if(bill==10){
                if(count5>=5){
                    count5-=5;
                    count10+=10;
                }else return false;
            }else{

                if(count5>=5 && count10>=10){
                    count5-=5;
                    count10-=10;
                    count20+=20;
                }else if(count5>=15){
                    count5-=15;
                    count20+=20;
                }
                else return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] bills = {5,5,10,10,20};
        boolean result = lemonadeChange(bills);
        System.out.println(result);
    }
}
