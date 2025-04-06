package com.daixiaoyu.leetcode.simple.one;

/**
 * @program: advance-leetcode
 * @author: water76016
 * @description:
 * @version: v1.0.0
 * @create: 2025-04-06 21:59
 **/
public class 买卖股票的最佳时机 {
    /**
     * @author: water76016
     * @createTime: 2025年04月06 23:27:47
     * @description: 不断更新最低价，每次遇到了一个高价之后，就比较是否要更新结果
     * @param: prices
     * @return: int
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0){
            return 0;
        }
        //记录结果
        int result = 0;
        //记录自己遇到的最低价
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++){
            int curPrice = prices[i];
            if (curPrice < minPrice){
                //比最低价还小，更新最低价
                minPrice = curPrice;
            }
            else if (curPrice > minPrice){
                result = Math.max(result, curPrice - minPrice);
            }
        }
        return result;
    }
}
