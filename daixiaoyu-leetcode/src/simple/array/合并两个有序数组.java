package simple.array;

/**
 * @program: advance
 * @author: water76016
 * @description:
 * @version: v1.0.0
 * @create: 2023-07-18 00:37
 **/
public class 合并两个有序数组 {
    //定义三个指针，三个指针一起移动
    public void merge(int[] nums1, int m, int[] nums2, int n){
        int p1 = 0;
        int p2 = 0;
        int cur = 0;
        //定义结果数组
        int[] result = new int[m + n];
        while (p1 < m || p2 < n){
            if (p1 == m){
                cur = nums2[p2];
                p2++;
            }
            else if (p2 == n){
                cur = nums1[p1];
                p1++;
            }
            else if (nums1[p1] < nums2[p2]){
                cur = nums1[p1];
                p1++;
            }
            else {
                cur = nums2[p2];
                p2++;
            }
            result[p1 + p2 - 1] = cur;
        }
        //将结果赋值给第一个数组
        for (int i = 0; i < m + n; i++){
            nums1[i] = result[i];
        }
    }
}