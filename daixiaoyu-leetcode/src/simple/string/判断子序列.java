package simple.string;

/**
 * @program: advance
 * @author: water76016
 * @description:
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。
 * （例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * @version: v1.0.0
 * @create: 2023-07-03 00:03
 **/
public class 判断子序列 {
    //双指针，相同则两个指针一起移动，不相同则仅一个指针进行移动
    public boolean isSubsequence(String s, String t) {
        int n = 0;
        int m = 0;
        while (m < t.length() && n < s.length()){
            if (s.charAt(n) == t.charAt(m)){
                n++;
                m++;
            }
            else {
                m++;
            }
        }
        if (n == s.length()){
            return true;
        }
        else {
            return false;
        }
    }
}
