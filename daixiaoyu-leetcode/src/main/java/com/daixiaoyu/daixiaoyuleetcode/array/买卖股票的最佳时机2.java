package com.daixiaoyu.daixiaoyuleetcode.array;

/**
 * @program: advance
 * @author: water76016
 * @description:
 * @version: v1.0.0
 * @create: 2023-09-24 22:56
 **/
public class 买卖股票的最佳时机2 {
    /**
     * @author: water76016
     * @createTime: 2023年09月24 22:59:48
     * @description: 每次判断，只要有下降趋势了，就开始卖股票
     * @param: prices
     * @return: int
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0){
            return 0;
        }

        int result = 0;
        int min = prices[0];
        int pre = prices[0];
        for (int i = 1; i < prices.length; i++){
            //判断跟前一个比是不是在下降
            if (prices[i] < pre){
                result = result + (pre - min);
                min = prices[i];
            }
            else {

            }
            pre = prices[i];
        }
        if (pre > min){
            result = result + (pre - min);
        }
        return result;
    }
}
