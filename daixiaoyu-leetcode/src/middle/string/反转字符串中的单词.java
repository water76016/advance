package middle.string;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @program: advance
 * @author: water76016
 * @description:
 * @version: v1.0.0
 * @create: 2023-07-02 22:28
 **/
public class 反转字符串中的单词 {
    public String reverseWords(String s) {
        //先去除s左右两边的空白字符
        s = s.trim();
        //找到里面所有的单词
        List<String> list = Arrays.asList(s.split("\\s+"));
        //反转
        Collections.reverse(list);
        //返回结果
        return String.join(" ", list);
    }
}
