import java.util.LinkedList;
import java.util.List;

/**
 * Created by lixiaojian on 2016/10/31.
 */
public class LongestPalindromicSubstring_5 {
    public static String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }
        LinkedList<Character> stack = new LinkedList<Character>();
        String max = "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <s.length() ; i++) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
            } else {
                if (s.charAt(i) == stack.peek()) {
                    sb.append(stack.pop());
                } else {
                    stack.push(s.charAt(i));
                }
            }
            String cur = sb.toString();
            if (cur.length() >= max.length()) {
                max = sb.reverse() + cur;
            }
            sb.delete(0,sb.length());
        }
        return max;
    }

    public static void main(String[] args) {
        String str = "abba";
        System.out.println(longestPalindrome(str));
    }
}
