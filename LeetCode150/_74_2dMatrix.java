
public class _74_2dMatrix {

    public static boolean method1(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int row = 0;
        int col = matrix[0].length - 1;

        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }

    public static boolean bs(int[] arr, int target) {
        int l = 0;
        int r = arr.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == target) {
                return true;
            }

            if (arr[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return false;
    }

    public static boolean method2(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        for (int[] row : matrix) {
            int lastElement = row[row.length - 1];
            if (lastElement == target) {
                return true;
            } else if (lastElement > target) {
                return bs(row, target);

            }

        }

        // If the loop completes without finding the target
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
        int target = 11;
        System.out.println(method2(matrix, target));
    }
}
