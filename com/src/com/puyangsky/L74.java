package com.puyangsky;

/**
 * Author: puyangsky
 * Date: 17/3/15
 * Complexity:
 * Method:
 */
public class L74 {

    public static boolean searchMatrix(int[][] matrix, int target) {
        int height = matrix.length;
        if (height == 0) {
            return false;
        }
        int width = matrix[0].length;
        if (width == 0) {
            return false;
        }
        //初始点在右上角，即matrix[i][j];
        int i = 0;
        int j = width - 1;
        while (i < height && j >= 0) {
            if (target == matrix[i][j]) {
                return true;
            }
            //target比当前坐标大，则往下找
            else if (target > matrix[i][j]) {
                i++;
            }
            //target比当前坐标小，则往左找
            else{
                j--;
            }
        }
        return false;
    }

//    public static int binarySearch(int[] array, int target) {
//        int left = 0, right = array.length - 1;
//        while (left < right) {
//            int mid = left + (right - left) / 2;
//            if(array[mid] == target) {
//                return mid;
//            }else if (array[mid] < target) {
//                left = mid;
//            }else {
//                right = mid - 1;
//            }
//        }
//
//        return left;
//    }
}
