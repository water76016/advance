package simple.string;

/**
 * @program: advance
 * @author: water76016
 * @description:
 * 给你两个字符串 word1 和 word2 。
 * 请你从 word1 开始，通过交替添加字母来合并字符串。
 * 如果一个字符串比另一个字符串长，就将多出来的字母追加到合并后字符串的末尾。
 * 返回 合并后的字符串 。
 * @version: v1.0.0
 * @create: 2023-07-02 15:48
 **/
public class 交替合并字符串 {
    /**
     * 模拟交替合并的过程即可
     */
    public String mergeAlternately(String word1, String word2) {
        //先判空
        if (word1 == null || word1.length() == 0){
            return word2;
        }
        if (word2 == null || word2.length() == 0){
            return word1;
        }
        //开始交叉合并
        StringBuilder builder = new StringBuilder("");
        int step = 0;
        while (word1.length() > step && word2.length() > step){
            builder.append(word1.charAt(step)).append(word2.charAt(step));
            step++;
        }
        //把较长的那个字符串追加到结果的后面
        if (word1.length() >= step){
            builder.append(word1.substring(step));
        }
        if (word2.length() >= step){
            builder.append(word2.substring(step));
        }
        return builder.toString();
    }
}
