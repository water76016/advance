package simple.num;

/**
 * @program: advance
 * @author: water76016
 * @description:
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * @version: v1.0.0
 * @create: 2023-07-02 22:51
 **/
public class 移动零 {
    //采用双指针进行移动，两次遍历
    public void moveZeroes(int[] nums) {
        if(nums == null) {
            return;
        }
        //第一次遍历的时候，j指针记录非0的个数，只要是非0的统统都赋给nums[j]
        int step = 0;
        for(int i=0;i<nums.length;++i) {
            if(nums[i]!=0) {
                nums[step] = nums[i];
                step++;
            }
        }
        //非0元素统计完了，剩下的都是0了
        //所以第二次遍历把末尾的元素都赋为0即可
        for(int i = step; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
