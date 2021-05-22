package com.fh;

/**
 * 如何k个一组,翻转链表
 */
public class FlipChart {


    ListNode reverseKGroup(ListNode head,int k){
        if(head == null){
            return null;
        }
        ListNode a,b;
        a = b = head;
        for (int i = 0; i < k; i++) {
            if(b == null){
                return head;
            }
            b = b.next;
        }
        ListNode newHead = reverse(a, b);
        a.next = reverseKGroup(b,k);
        return newHead;
    }

    ListNode reverse(ListNode a,ListNode b){
        ListNode pre,cur,nxt;
        pre = null;cur = a;nxt=a;
        while (cur != b){
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return cur;
    }

    class ListNode{
        public int val;
        public ListNode next;
    }


}
