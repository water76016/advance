package simple.array;

/**
 * @program: advance
 * @author: water76016
 * @description:
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 * 请找出数组中任意一个重复的数字。
 *
 * 题解：使用数组，将每个数放到数组对应的下标，多余的那个直接返回即可
 * @version: v1.0.0
 * @create: 2023-07-27 22:10
 **/
public class 数组中重复的数字 {
    public int findRepeatNumber(int[] nums) {
        int index = 0;
        while (index < nums.length){
            if (nums[index] == index){
                index++;
                continue;
            }
            //此时说明数组下标和对应的值不相等，需要交换位置
            if (nums[nums[index]] == nums[index]){
                return nums[index];
            }
            int temp = nums[index];
            nums[index] = nums[temp];
            nums[temp] = temp;
        }
        return -1;
    }
}
