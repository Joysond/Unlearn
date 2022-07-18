package com.citrix.tomcat.rpm;

/**
 * @author jdsouza - 14/07/22
 */
public class MatrixElementSearch {
    public static void main(String[] args) {
        int[][] sortedMatrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 12}
        };
        System.out.println(sortedMatrix[0].length);
        System.out.println(sortedMatrix.length);
        System.out.println(findElement(sortedMatrix, 12));
    }

    private static String findElement(int[][] matrix, int element) {
        int row = findPossibleRow(matrix, element);
        int col = findPossibleCol(matrix, row, element);
        if(col == -1) return "Not found";
        else return row + "," + col;
    }

    private static int findPossibleCol(int[][] matrix, int row, int element) {
        int low = 0, high = matrix.length - 1;
        int mid = 0;
        while(low < high) {
            mid = (low + high) / 2;
            if(element > matrix[row][mid])
                low = mid + 1;
            else if(element < matrix[row][mid])
                high = mid - 1;
            else break;
        }
        if(matrix[row][mid] == element) return mid;
        else return -1;
    }

    private static int findPossibleRow(int[][] matrix, int element) {
        int low = 0, high = matrix.length - 1;
        int mid = 0;
        while(low < high) {
            mid = (low + high) / 2;
            if(element > matrix[mid][0])
                low = mid + 1;
            else if(element < matrix[mid][0])
                high = mid - 1;
            else break;
        }
        // check if the element is greater than the next row then return current mid as row

        if (matrix[mid][0] == element) return mid;
        else if(element >= matrix[mid+1][0]) return mid+1;
        else return mid - 1;
    }

}
