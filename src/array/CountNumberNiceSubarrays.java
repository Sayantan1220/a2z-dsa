package array;

public class CountNumberNiceSubarrays {

    public static int numberOfSubarrays(int[] nums, int k) {
        int i=0;
        int j=0;
        int oddCount=0;
        int ans=0;
        int count=0;

        while(j<nums.length){

            if(nums[j]%2!=0){
                oddCount++;
                ans=0;
            }
            while(oddCount==k){
                ans++;
                if(nums[i]%2!=0){
                    oddCount--;
                }
                i++;
            }
            count+=ans;
            j++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,2,1,2,2,1,2,2,2};
        int result = numberOfSubarrays(arr, 3);
        System.out.println(result);
    }
}
