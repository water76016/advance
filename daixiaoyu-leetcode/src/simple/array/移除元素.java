package simple.array;

/**
 * @program: advance
 * @author: water76016
 * @description: 给你一个数组 nums和一个值 val，你需要 原地 移除所有数值等于val的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * 注意：这里元素的顺序可以改变
 * @version: v1.0.0
 * @create: 2023-07-25 00:53
 **/
public class 移除元素 {
    //元素的顺序可以改变（首尾双指针）
    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            if (nums[left] == val){
                nums[left] = nums[right];
                right--;
            }
            else {
                left++;
            }
        }
        return left;
    }
    //元素的顺序不能改变（两个指针都在头部，一个指向要处理的元素，一个指向将要赋值的位置）
    public int removeElement2(int[] nums, int val) {
        int left = 0;
        int right = 0;
        while (right < nums.length){
            if (nums[right] != val){
                nums[left] = nums[right];
                left++;
            }
            right++;
        }
        return left;
    }
}
