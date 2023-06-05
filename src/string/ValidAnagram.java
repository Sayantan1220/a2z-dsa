package string;

public class ValidAnagram {

    public static boolean isAnagram(String s, String t) {

        int[] arr = new int[256];
        if (s.length() != t.length()){
            return false;
        }

        for (int i = 0; i < s.length(); i++){
            arr[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++){
            if (arr[t.charAt(i) - 'a']-- == 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        boolean result = isAnagram(s, t);
        System.out.println(result);
    }
}
