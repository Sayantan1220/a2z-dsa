package string;

public class RepeatedStringMatch {

    public static int repeatedStringMatch(String a, String b) {
        StringBuilder copy = new StringBuilder();
        int count=0;
        while(copy.length()<b.length()){
            copy.append(a);
            count++;
        }
        if(copy.toString().contains(b))
            return count;
        if((copy + a).contains(b))
            return ++count;
        return -1;
    }

    public static void main(String[] args) {
        int result = repeatedStringMatch("abcd", "cdabcdab");
        System.out.println(result);
    }
}
