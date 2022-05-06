package easy;

import java.util.LinkedList;

/**
 * @author by zhangborui
 * @classname RecentCounter
 * @description 933
 * @date 2022/5/6 14:16
 */
public class RecentCounter {
    int size;
    LinkedList<Integer> list;

    public RecentCounter() {
        size = 0;
        list = new LinkedList<>();
    }

    public int ping(int t) {
        while(size > 0 && t - list.getFirst() > 3000) {
            list.removeFirst();
            size--;
        }
        list.addLast(t);
        size++;
        return size;
    }

    public static void main(String[] args) {
        RecentCounter recentCounter = new RecentCounter();
        System.out.println(recentCounter.ping(1));
        System.out.println(recentCounter.ping(100));
        System.out.println(recentCounter.ping(3001));
        System.out.println(recentCounter.ping(3002));
    }
}
