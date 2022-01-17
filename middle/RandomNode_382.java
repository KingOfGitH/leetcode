package middle;

import common.ListNode;

import java.util.Random;

/**
 * @author zhangborui
 */
public class RandomNode_382 {
    int length = 0;
    ListNode head;
    ListNode randomNode;

    public RandomNode_382(ListNode head) {
        this.head = head;
        while (head != null) {
            length++;
            head = head.next;
        }
    }

    public int getRandom() {
        int anInt = new Random().nextInt(length);
        randomNode = head;
        for (int i = 0; i < anInt; i++) {
            randomNode = randomNode.next;
        }
        return randomNode.val;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = listNode;
        ListNode listNode3 = listNode;
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        RandomNode_382 randomNode_382 = new RandomNode_382(listNode);
        System.out.println(listNode);
        System.out.println(randomNode_382.head);
        System.out.println(randomNode_382.length);
        System.out.println(randomNode_382.getRandom());
        System.out.println(randomNode_382.getRandom());
        System.out.println(randomNode_382.getRandom());
        System.out.println(randomNode_382.getRandom());
    }
}
