/**
 * Created by lixiaojian on 2016/11/3.
 * @source https://leetcode.com/problems/zigzag-conversion/
 */
public class Lee006_ZigZagConversion {
//    The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
//    P   A   H   N
//    A P L S I I G
//    Y   I   R
//    And then read line by line: "PAHNAPLSIIGYIR"
//    Write the code that will take a string and make this conversion given a number of rows:
//
//    string convert(string text, int nRows);
//    convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".

    //@ps： 第一，要理解ZigZag的意思，第二，静下心来找规律
    public static String convert(String s, int numRows) {
        if (numRows <= 1 || numRows > s.length()) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i<s.length();i+=2*(numRows-1)) {
            sb.append(s.charAt(i));
        }
        for (int j=1;j<numRows-1;j++) {
            boolean flag = true;
            int i = j;
            while(i < s.length()) {
                sb.append(s.charAt(i));
                if(flag) {
                    i += 2*(numRows-j-1);
                    flag = false;
                }else {
                    i += 2*j;
                    flag = true;
                }
            }
        }
        for (int i = numRows-1; i <s.length() ; i+=2*(numRows-1)) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        //convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".\
        String str = "PAYPALISHIRING";
        System.out.println(convert(str,3));
    }
}
