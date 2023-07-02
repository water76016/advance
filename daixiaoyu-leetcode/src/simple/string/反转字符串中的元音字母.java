package simple.string;

import java.util.IllegalFormatCodePointException;

/**
 * @program: advance
 * @author: water76016
 * @description:
 * 给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。
 *
 * 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现不止一次。
 * @version: v1.0.0
 * @create: 2023-07-02 19:40
 **/
public class 反转字符串中的元音字母 {
    /**
     * 利用双指针法，满足元音字母则交换，否则继续进行指针移动
     *
     * 注：这里可以new一个数组出来，可以直接s转换成数组，在这个数组上做交换即可
     */
    public String reverseVowels(String s) {
        if (s == null || s.length() <= 1){
            return s;
        }
        char[] nums = new char[s.length()];
        int left = 0;
        int right = s.length() - 1;
        while (left < right){
            //找左边的元音
            while (left <= right){
                if (isYuanyin(s.charAt(left))){
                    break;
                }
                nums[left] = s.charAt(left);
                left++;
            }
            //找右边的元音
            while (left <= right){
                if (isYuanyin(s.charAt(right))){
                    break;
                }
                nums[right] = s.charAt(right);
                right--;
            }
            //判断left和right是否满足条件，满足条件则交换
            if (left < right && left <= s.length() - 1 && right >= 0){
                nums[left] = s.charAt(right);
                nums[right] = s.charAt(left);
                left++;
                right--;
            }
            else if (left <= right){
                nums[left] = s.charAt(left);
                nums[right] = s.charAt(right);
                left++;
                right--;
            }
        }
        if (left == right){
            nums[left] = s.charAt(left);
        }
        return new String(nums);
    }

    public boolean isYuanyin(char c){
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
            return true;
        }
        if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U'){
            return true;
        }
        return false;
    }
}
