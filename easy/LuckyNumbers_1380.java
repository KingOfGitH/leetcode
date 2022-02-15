package easy;

import java.util.ArrayList;
import java.util.List;

public class LuckyNumbers_1380 {
    public List<Integer> luckyNumbers(int[][] matrix) {

        List<Integer> res = new ArrayList<>();
        for (int[] ints : matrix) {
            int min = 0;
            for (int j = 0; j < ints.length; j++) {
                if (ints[min] > ints[j]) {
                    min = j;
                }
            }
            int index = 0;
            while (index < matrix.length) {
                if (ints[min] < matrix[index][min]) {
                    break;
                }
                index++;
            }
            if (index == matrix.length) {
                res.add(ints[min]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LuckyNumbers_1380 luck = new LuckyNumbers_1380();
        System.out.println(luck.luckyNumbers(new int[][]{{3, 7, 8},{9, 11, 13},{15, 16, 17}}));
    }
}
