package string;

public class RepeatedStringMatch {

    public static int repeatedStringMatch(String a, String b) {
        String copy = "";
        int count=0;
        while(copy.length()<b.length()){
            copy+=a;
            count++;
        }
        if(copy.indexOf(b)>=0)
            return count;
        if((copy+a).indexOf(b)>=0)
            return ++count;
        return -1;
    }

    public static void main(String[] args) {
        int result = repeatedStringMatch("abcd", "cdabcdab");
        System.out.println(result);
    }
}
