package easy;

/**
 * @author by zhangborui
 * @classname IsBoomerang_1037
 * @description TODO
 * @date 2022/6/8 21:07
 */
public class IsBoomerang_1037 {
    public boolean isBoomerang(int[][] points) {
        int x1 = points[0][0];
        int y1 = points[0][1];
        int x2 = points[1][0];
        int y2 = points[1][1];
        int x3 = points[2][0];
        int y3 = points[2][1];
        return (x1 - x2) * (y1 - y3) != (x1 - x3) * (y1 - y2);
    }
}
