package simple.string;

/**
 * @program: advance
 * @author: water76016
 * @description:
 * 对于字符串s和t，只有在s = t + ... + t（t 自身连接 1 次或多次）时，我们才认定“t 能除尽 s”。
 * 给定两个字符串str1和str2。返回 最长字符串x，要求满足x 能除尽 str1 且 x 能除尽 str2 。
 * @version: v1.0.0
 * @create: 2023-07-02 16:39
 **/
public class 字符串的最大公因子 {
    /**
     * 从大小大取前缀进行枚举，碰到第一个满足的子字符串，即可返回结果
     */
    public String gcdOfStrings(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        int min = Math.min(len1, len2);
        for (int i = min; i >= 1; i--){
            //在长度上，能够除尽，字符串才能除尽
            if (len1 % i == 0 && len2 % i == 0){
                String str = str1.substring(0, i);
                if (checkDivide(str, str1) && checkDivide(str, str2)){
                    return str;
                }
            }
        }
        //没有找到结果，返回空
        return "";
    }

    //检查字符串t是否能够除尽s
    public boolean checkDivide(String t, String s){
        int divideNum = s.length() / t.length();
        //检查除的结果是否是整数，如果不是，则肯定不能够除尽
        if (t.length() * divideNum < s.length()){
            return false;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= divideNum; i++){
            builder.append(t);
        }
        return builder.toString().equals(s);
    }
}
