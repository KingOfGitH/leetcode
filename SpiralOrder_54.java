import java.util.ArrayList;
import java.util.List;

/**
 * @author by zhangborui
 * @classname SpiralOrder_54
 * @description 3 4  00 01 02 03 13 23 22 21 20 10
 * @date 2026/4/13 16:13
 */
public class SpiralOrder_54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int len = matrix.length * matrix[0].length;
        int step = 0;
        int rowLen = matrix[0].length;
        int colLen = matrix.length - 1;
        int cur = 0;
        int row = 0;
        int col = 0;
        for (int i = 0; i < len; i++) {
            res.add(matrix[row][col]);
            cur++;
            if (step == 0) {
                if (cur == rowLen) {
                    cur = 0;
                    step++;
                    rowLen--;
                    row++;
                }else {
                    col++;
                }
            } else if (step == 1) {
                if (cur == colLen) {
                    cur = 0;
                    step++;
                    colLen--;
                    col--;
                }else {
                    row++;
                }
            } else if (step == 2) {
                if (cur == rowLen) {
                    cur = 0;
                    step++;
                    rowLen--;
                    row--;
                }else {
                    col--;
                }
            } else if (step == 3) {
                if (cur == colLen) {
                    cur = 0;
                    step = 0;
                    colLen--;
                    col++;
                }else {
                    row--;
                }
            }
        }
        return res;
    }
}
