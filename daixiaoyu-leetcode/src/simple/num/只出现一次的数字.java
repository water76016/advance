package simple.num;

/**
 * @program: advance
 * @author: water76016
 * @description:
 * 给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。
 * @version: v1.0.0
 * @create: 2023-07-03 01:04
 **/
public class 只出现一次的数字 {
    //同归于尽法
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int i : nums){
            result = result ^ i;
        }
        return result;
    }
}
