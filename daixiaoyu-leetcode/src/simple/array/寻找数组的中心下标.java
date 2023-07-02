package simple.array;

import java.util.Arrays;

/**
 * @program: advance
 * @author: water76016
 * @description:
 * 给你一个整数数组nums ，请计算数组的 中心下标 。
 *
 * 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
 *
 * 如果中心下标位于数组最左端，那么左侧数之和视为 0 ，因为在下标的左侧不存在元素。这一点对于中心下标位于数组最右端同样适用。
 *
 * 如果数组有多个中心下标，应该返回 最靠近左边 的那一个。如果数组不存在中心下标，返回 -1 。
 * @version: v1.0.0
 * @create: 2023-07-03 00:49
 **/
public class 寻找数组的中心下标 {
    public static void main(String[] args) {
        int[] nums = {-1,-1,0,1,1,0};
        System.out.println(pivotIndex(nums));
    }
    //利用公式直接算： 2 * 左边的和 + sums[i] = total
    public static int pivotIndex(int[] nums) {
        if (nums == null || nums.length == 0){
            return -1;
        }
        //先计算数组的和
        int total = 0;
        for (int num : nums){
            total = total + num;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++){
            if (2 * sum + nums[i] == total){
                return i;
            }
            else {
                sum = sum + nums[i];
            }
        }
        return -1;
    }
}
