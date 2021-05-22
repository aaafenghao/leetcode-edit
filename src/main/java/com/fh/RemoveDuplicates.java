package com.fh;

public class RemoveDuplicates {

    int removeDuplicates(int[] nums){
        if(nums.length == 0){
            return 0;
        }
        int n = nums.length;
        int slow = 0;
        int fast = 1;
        while (fast < n){
            if(nums[fast] != nums[slow]){
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow+1;
    }

    class ListNode{
        ListNode next;
        int val;
    }

    ListNode removeDuplicates(ListNode head){
        if(head == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null){
            if(fast.val != slow.val){
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }
        slow.next = null;
        return head;
    }
}
