package middle;

//0 0 - 3 0 - 3 3 - 0 3
//        0 1 - 2 0  - 3 2 - 1 3
//        0 2 - 1 0
//        0 3 - 0 0
//        1 0 - 3 2
public class Rotate_48 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i; j < n - i - 1; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i]= matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = temp;
            }
        }
    }
}
