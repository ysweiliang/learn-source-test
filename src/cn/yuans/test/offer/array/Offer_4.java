package cn.yuans.test.offer.array;

/**
 * 给定一个二维数组，其每一行从左到右递增排序，从上到下也是递增排序。
 * 给定一个数，判断这个数是否在该二维数组中。
 * 要求时间复杂度 O(M + N)，空间复杂度 O(1)。其中 M 为行数，N 为 列数。
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * <p>
 * Given target = 5, return true.
 * Given target = 20, return false.
 *
 * @author yuans
 * @create 2021-04-12-12:26
 */
public class Offer_4 {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        Offer_4 offer_4 = new Offer_4();
        boolean b = offer_4.Find(5, matrix);
        System.out.println(b);
    }

    /**
     * 该二维数组中的一个数，小于它的数一定在其左边，大于它的数一定在其下边
     */
    public boolean Find(int target, int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int rows = matrix.length, cols = matrix[0].length;
        int r = 0, c = cols - 1; // 从右上角开始
        while (r <= rows - 1 && c >= 0) {
            if (target == matrix[r][c])
                return true;
            else if (target > matrix[r][c])
                r++;
            else
                c--;
        }
        return false;
    }
}
