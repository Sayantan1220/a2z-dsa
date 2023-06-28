package string;

import java.util.HashMap;

public class MinimumWindowSubstring {
    public static String minWindow(String s, String t) {
        String ans = "";
        HashMap<Character, Integer> hm2 = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            char ch = t.charAt(i);
            hm2.put(ch, hm2.getOrDefault(ch, 0) + 1);
        }
        int mcnt = 0;
        int dnct = t.length();
        HashMap<Character, Integer> hm1 = new HashMap<>();
        int i = -1;
        int j = -1;
        while(true){
            boolean f1 = false;
            boolean f2 = false;
            //accuire
            while(i < s.length() - 1 && mcnt < dnct){
                i++;
                char ch = s.charAt(i);
                hm1.put(ch, hm1.getOrDefault(ch, 0) + 1);
                if(hm1.getOrDefault(ch, 0) <= hm2.getOrDefault(ch, 0)){
                    mcnt++;
                }
                f1 = true;
            }
            //collect answer and release
            while(j < i && mcnt == dnct){
                String pans = s.substring(j + 1, i + 1);
                if(ans.length() == 0 || pans.length() < ans.length()) ans = pans;
                j++;
                char ch = s.charAt(j);
                if(hm1.get(ch) == 1) hm1.remove(ch);
                else hm1.put(ch, hm1.get(ch) - 1);
                if(hm1.getOrDefault(ch, 0) < hm2.getOrDefault(ch, 0))
                    mcnt--;
                f2 = true;
            }
            if(!f1 && !f2)
                break;
        }
        return ans;
    }

    public static void main(String[] args) {
        String result = minWindow("ADOBECODEBANC", "ABC");
        System.out.println(result);
    }
}
