package simple.other;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: advance
 * @author: water76016
 * @description:
 * 给你一个数组candies和一个整数extraCandies，其中candies[i]代表第 i 个孩子拥有的糖果数目。
 *
 * 对每一个孩子，检查是否存在一种方案，将额外的extraCandies个糖果分配给孩子们之后，此孩子有 最多的糖果。
 * 注意，允许有多个孩子同时拥有 最多的糖果数目。
 * @version: v1.0.0
 * @create: 2023-07-02 17:43
 **/
public class 拥有最多糖果的孩子 {
    /**
     * 先一次遍历记录最大值，然后遍历这个数组，若当前数 + 额外的数 >= 最大值，则置为true，否则置为false
     */
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        if (candies == null || candies.length == 0){
            return null;
        }
        int max = 0;
        for (int num : candies){
            max = Math.max(max, num);
        }
        List<Boolean> list = new ArrayList<>();
        for (int num : candies){
            if (num + extraCandies >= max){
                list.add(true);
            }
            else {
                list.add(false);
            }
        }
        return list;
    }
}
