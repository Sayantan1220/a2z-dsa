package Array;

public class BestTimeBuySellStock {

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minValue = Integer.MAX_VALUE;
        int n = prices.length;
        for (int i = 0; i < n; i++){
            minValue = Math.min(minValue, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minValue);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        int result = maxProfit(arr);
        System.out.println(result);
    }
}
