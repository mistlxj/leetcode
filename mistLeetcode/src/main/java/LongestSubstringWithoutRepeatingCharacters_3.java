import java.util.HashSet;
import java.util.Set;

/**
 * Created by lixiaojian on 2016/10/31.
 * @source https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestSubstringWithoutRepeatingCharacters_3 {

//    Given a string, find the length of the longest substring without repeating characters.
//
//    Examples:
//
//    Given "abcabcbb", the answer is "abc", which the length is 3.
//
//    Given "bbbbb", the answer is "b", with the length of 1.
//
//    Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        for (int i = 0; i <s.length(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(s.charAt(i));
            for(int j=i+1;j<s.length();j++) {
                if (!sb.toString().contains(String.valueOf(s.charAt(j)))) {
                    sb.append(s.charAt(j));
                } else {
                    break;
                }
            }
            int cur = sb.length();
            max = Math.max(max,cur);
        }
        return max;
    }

    public static void main(String[] args) {
        String str = "VWXYZ0123456789!\\\"#$%&'()*+,-./:;<=>?@[\\\\]^_`{|}~ abcdefghijklmnopqrstuvwxy";
        System.out.println(lengthOfLongestSubstring(str));
    }
}
