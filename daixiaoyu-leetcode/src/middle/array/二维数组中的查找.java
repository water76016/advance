package middle.array;

/**
 * @program: advance
 * @author: water76016
 * @description:在一个 n * m 的二维数组中，每一行都按照从左到右非递减的顺序排序，
 * 每一列都按照从上到下非递减的顺序排序。
 * 请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * 题解：从右上角开始找，不断地缩小范围即可
 * @version: v1.0.0
 * @create: 2023-07-27 22:17
 **/
public class 二维数组中的查找 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int startX = 0;
        int startY = matrix[0].length - 1;
        int endX = matrix.length - 1;
        int endY = 0;
        while (startX <= endX && startY >= endY){
            if (matrix[startX][startY] == target){
                return true;
            }
            else if(matrix[startX][startY] < target){
                startX++;
            }
            else {
                startY--;
            }

        }
        return false;
    }
}
