/*
The count-and-say sequence is a sequence of digit strings defined by the recursive formula:
countAndSay(1) = "1"
countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1),
which is then converted into a different digit string.
To determine how you "say" a digit string,
split it into the minimal number of substrings such that each substring contains exactly one unique digit.
Then for each substring, say the number of digits, then say the digit. Finally, concatenate every said digit.
https://leetcode.com/problems/count-and-say/

Approach
Handle the edge case where n is less than or equal to 0 by returning null.
Initialize a variable result with the initial term of the sequence, which is "1".
Use a loop to generate the next term in the sequence n times:
Inside the loop, create a StringBuilder named sb to build the next term.
Initialize a counter count to 1 to keep track of the consecutive occurrences of a digit.
Iterate through the characters of the result string starting from the second character.
Compare each character with the previous character. If they are the same, increment the count.
If the characters are different, append the count followed by the previous character to sb, reset the count to 1, and continue to the next character.
After the inner loop completes, append the final count and the last character of the result string to sb.
Update the result to the generated string in sb.
Return the final result string.

Time complexity:
The time complexity of the code is O(n * k),
where n is the given input and k is the length of the longest term in the "Count and Say" sequence up to the nth term.
In each iteration of the loop, the code iterates through the characters of the result string to build the next term.
Therefore, the time complexity is proportional to the length of the longest term, which is k.

Space complexity:
The space complexity of the code is O(k),
where k is the length of the longest term in the "Count and Say" sequence up to the nth term.
It is due to the use of the StringBuilder to build the next term.
The space required for the result string and the temporary variables is negligible compared to the length of the longest term,
making the space complexity O(k).
 */

package string;

public class CountSay {

    public static String countAndSay(int n) {
        if (n <= 0)
            return null;
        String result = "1";
        int i = 1;
        while (i < n)
        {
            StringBuilder sb = new StringBuilder();
            int count = 1;
            for (int j = 1; j < result.length(); j++)
            {
                if (result.charAt(j) == result.charAt(j - 1))
                {
                    count++;
                }
                else
                {
                    sb.append(count);
                    sb.append(result.charAt(j - 1));
                    count = 1;
                }
            }
            sb.append(count);
            sb.append(result.charAt(result.length() - 1));
            result = sb.toString();
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        String result = countAndSay(4);
        System.out.println(result);
    }
}
