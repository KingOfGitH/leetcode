package hard;

import common.ListNode;

public class MergeKSortedLists_lcr078 {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        ListNode head = null;
        for (ListNode list : lists) {
            if (list == null) {
                continue;
            }
            head = mergeTwoLists(head, list);
        }
        return head;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode cur = new ListNode();
        ListNode head = cur;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cur.next = list1;
                cur = cur.next;
                list1 = list1.next;
            }else  {
                cur.next = list2;
                cur = cur.next;
                list2 = list2.next;
            }
        }
        if (list1 != null) {
            cur.next = list1;
        }
        if (list2 != null) {
            cur.next = list2;
        }
        return head.next;
    }
}
