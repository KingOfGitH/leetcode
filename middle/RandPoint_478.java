package middle;

import java.util.Random;

/**
 * @author by zhangborui
 * @classname RandPoint_478
 * @description 先通过随机确定x，再通过x求y的范围再随机的解法是错误的
 * 因为x在靠近R或-R的时候y的取值范围就会越来越小
 * @date 2022/6/5 15:48
 */
public class RandPoint_478 {
    double radius;
    double x_center;
    double y_center;
    Random random = new Random();

    public RandPoint_478(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
    }

    public double[] randPoint() {
        double length = Math.sqrt(random.nextDouble() * radius * radius);
        double angle = random.nextDouble() * 2 * Math.PI;
        double x = x_center + length * Math.cos(angle);
        double y = y_center + length * Math.sin(angle);
        return new double[]{x, y};
    }

}
