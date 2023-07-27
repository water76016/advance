package simple.string;

/**
 * @program: advance
 * @author: water76016
 * @description: 请实现一个函数，把字符串 s 中的每个空格替换成"%20"
 * 题解：先计算空格的数量，然后计算总的长度，后面从最后面不断地进行填充
 * @version: v1.0.0
 * @create: 2023-07-27 22:24
 **/
public class 替换空格 {
    public String replaceSpace(String s) {
        int totalBlank = 0;
        for(char c : s.toCharArray()){
            if (c == ' '){
                totalBlank++;
            }
        }
        char[] result = new char[s.length() + 2 * totalBlank];
        int resultPoint = result.length - 1;
        for(int i = s.length() - 1; i >= 0; i--){
            if (s.charAt(i) != ' '){
                result[resultPoint] = s.charAt(i);
                resultPoint--;
                continue;
            }
            result[resultPoint] = '0';
            resultPoint--;
            result[resultPoint] = '2';
            resultPoint--;
            result[resultPoint] = '%';
            resultPoint--;
        }
        return String.valueOf(result);
    }
}
