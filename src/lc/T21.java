package lc;

import java.util.List;

/**
 * @Author: 余新洁
 * @Date: 2021/5/29
 * @Description: 21. 合并两个有序链表
 */
public class T21 {
    /**
     * go
     * 双针，一个指针固定头，一个指针遍历连接。
     *
     * think
     * 递归
     *
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode head = new ListNode(0);
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                if (result == null){
                    result = l1;
                }
                head.next = l1;
                l1 = l1.next;
            }else {
                if (result == null){
                    result = l2;
                }
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }
        if (l1 == null){
            head.next = l2;
        }else {
            head.next = l1;
        }
        return result == null ? head.next : result;
    }

    public static class ListNode {
        private  int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}

