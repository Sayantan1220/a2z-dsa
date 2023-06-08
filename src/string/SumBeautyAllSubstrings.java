package string;

public class SumBeautyAllSubstrings {

    public int beautySum(String s) {
        //using an array as frequency :-
        int sum = 0 ;
        for(int i = 0 ; i < s.length() ; i++){
            int[] frequency = new int[26] ;//for 26 alphabets ;

            for(int j = i ; j<s.length() ;j++){
                frequency[s.charAt(j)-'a']++ ;
                //now beauty from substring i to j :-
                int beaut = beauty(frequency);
                sum = sum + beaut ;
            }
        }
        return sum ;
    }

    public int beauty(int[] frequency){
        int min = Integer.MAX_VALUE; int max = Integer.MIN_VALUE ;
        for (int j : frequency) {

            if (j != 0) {//this is very very very important
                min = Math.min(j, min);
            }
            max = Math.max(j, max);
        }
        return max-min ;
    }
}
