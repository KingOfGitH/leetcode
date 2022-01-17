package common;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("" + val).append(",");
        ListNode listNode = this;
        while (listNode.next != null) {
            res.append(listNode.next.val).append(",");
            listNode = listNode.next;
        }
        return res.toString();
    }
}
