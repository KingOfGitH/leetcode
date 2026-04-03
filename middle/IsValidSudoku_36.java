package middle;

import java.util.HashSet;
import java.util.Set;

/**
 * @author by zhangborui
 * @classname IsValidSudoku_36
 * @description 有效数独
 * [["5","3",".",".","7",".",".",".","."],
 * ["6",".",".","1","9","5",".",".","."],
 * [".","9","8",".",".",".",".","6","."],
 * ["8",".",".",".","6",".",".",".","3"],
 * ["4",".",".","8",".","3",".",".","1"],
 * ["7",".",".",".","2",".",".",".","6"],
 * [".","6",".",".",".",".","2","8","."],
 * [".",".",".","4","1","9",".",".","5"],
 * [".",".",".",".","8",".",".","7","9"]]
 * @date 2026/4/3 13:43
 */
public class IsValidSudoku_36 {
    public static void main(String[] args) {
        char[][] chars = new char[][]
                {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        System.out.println(new IsValidSudoku_36().isValidSudoku(chars));
    }

    public boolean isValidSudoku(char[][] board) {
        return rows(board) && lines(board) && squares(board);
    }

    private boolean rows(char[][] board) {
        for (char[] chars : board) {
            if (!row(chars)) {
                System.out.println(chars);
                return false;
            }
        }
        return true;
    }

    private boolean row(char[] board) {
        Set<Character> set = new HashSet<>();
        int dotNom = 0;
        for (char c : board) {
            if (c == '.') {
                dotNom++;
            } else {
                set.add(c);
            }
        }
        return dotNom + set.size() == 9;
    }

    private boolean lines(char[][] board) {
        for (int i = 0; i < board[0].length; i++) {
            if (!line(board, i)) {
                System.out.println(i);
                return false;
            }
        }
        return true;
    }

    private boolean line(char[][] board, int j) {
        Set<Character> set = new HashSet<>();
        int dotNom = 0;
        for (char[] chars : board) {
            char c = chars[j];
            if (c == '.') {
                dotNom++;
            } else {
                set.add(c);
            }
        }
        return dotNom + set.size() == 9;
    }

    private boolean squares(char[][] board) {
        for (int i = 0; i < board.length; i = i + 3) {
            for (int j = 0; j < board[0].length; j = j + 3) {
                if (!square(board, i, j)) {
                    System.out.println(i + " " + j);
                    return false;
                }
            }
        }
        return true;
    }

    private boolean square(char[][] board, int i, int j) {
        Set<Character> set = new HashSet<>();
        int dotNom = 0;
        for (int i1 = 0; i1 < 3; i1++) {
            for (int j1 = 0; j1 < 3; j1++) {
                char c = board[i+i1][j+j1];
                if (c == '.') {
                    dotNom++;
                } else {
                    set.add(c);
                }
            }
        }
        return dotNom + set.size() == 9;
    }


}
