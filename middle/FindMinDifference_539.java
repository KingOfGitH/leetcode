package middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindMinDifference_539 {
    public int findMinDifference(List<String> timePoints) {
        int size = timePoints.size();
        if (size > 1440) {
            return 0;
        }
        float[] time = new float[size];
        int i = 0;
        for (String timePoint : timePoints) {
            time[i++] = Float.parseFloat((timePoint.replace(":", ".")));
        }
        Arrays.sort(time);
        int res = Integer.MAX_VALUE;
        int temp;
        int a;
        int b;
        int c;
        int d;
        for (i = 0; i < time.length - 1; i++) {
            a = (int) (time[i + 1]);
            b = Math.round((time[i + 1] - a) * 100);
            c = (int) (time[i]);
            d = Math.round((time[i] - c) * 100);
            temp = (a - c) * 60 + b - d;
            if (res > temp) {
                res = temp;
                if (res == 0) {
                    return res;
                }
            }
        }
        a = (int) (time[0]) + 24;
        b = Math.round((time[0] + 24 - a) * 100);
        c = (int) (time[size - 1]);
        d = Math.round((time[size - 1] - c) * 100);
        temp = (a - c) * 60 + b - d;
        if (res > temp) {
            res = temp;
        }

        return res;
    }

    public static void main(String[] args) {
        FindMinDifference_539 findMinDifference_539 = new FindMinDifference_539();
        System.out.println(findMinDifference_539.findMinDifference(Arrays.asList("23:59", "00:00")));
        System.out.println(findMinDifference_539.findMinDifference(Arrays.asList("00:00","23:59","00:00")));
        System.out.println((int) ((1.11 - 1) * 100));
    }
}
