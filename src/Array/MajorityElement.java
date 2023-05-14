package Array;

public class MajorityElement {
    public static int majorityElement(int[] nums) {
        int count=0;
        Integer me=null;

        //travese the array
        //make the first ele as the majority
        //if next is qual c++ || if not c--
        // after count bcom zero make the element as majority where count got zero
        for(int i=0;i<nums.length;i++){
            if(count==0){
                me=nums[i];
                count=1;
            }else if(nums[i]==me){
                count++;
            }else{
                count--;
            }
        }
        return me;
    }

    public static void main(String[] args) {
        int[] arr = {2,2,1,1,1,2,2};
        int result = majorityElement(arr);
        System.out.println(result);
    }
}
