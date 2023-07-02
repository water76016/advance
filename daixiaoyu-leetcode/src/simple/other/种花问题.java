package simple.other;

/**
 * @program: advance
 * @author: water76016
 * @description:
 * 假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 *
 * 给你一个整数数组flowerbed 表示花坛，由若干 0 和 1 组成，其中 0 表示没种植花，1 表示种植了花。另有一个数n ，
 * 能否在不打破种植规则的情况下种入n朵花？能则返回 true ，不能则返回 false。
 * @version: v1.0.0
 * @create: 2023-07-02 17:48
 **/
public class 种花问题 {
    /**
     * 模拟种花，一次遍历即可，能种就种进去，最后看n是否小于等于0，满足则返回true，否则返回false
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed == null || flowerbed.length == 0){
            return false;
        }
        //记录上一个是有花还是没有花，初始化是没有花
        boolean flag = false;
        int length = flowerbed.length;
        for (int i = 0; i <= length - 1; i++){
            if (flag){
                //如果上一轮是有花，且当前位置种了花，则返回false
                if (flowerbed[i] == 1){
                    return false;
                }
                else {
                    flag = false;
                }
            }
            else {
                if (flowerbed[i] == 1){
                    flag = true;
                }
                else {
                    if (i == length - 1 || flowerbed[i + 1] == 0){
                        flowerbed[i] = 1;
                        n--;
                        flag = true;
                    }
                }
            }
        }
        //判断n是否小于等于0，小于等于0说明可以种花
        if (n <= 0){
            return true;
        }
        return false;
    }
}


