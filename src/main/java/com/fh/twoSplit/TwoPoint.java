package com.fh.twoSplit;

/**
 * 双指针
 *
 * 快慢指针
 * 左右指针
 */
public class TwoPoint {


    /**
     * 判断是否有环
     * @param root
     * @return
     */
    public boolean hasCycle(ListNode root){
        ListNode fast,slow;
        fast = slow = root;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow  = slow.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }

    /**
     * 获取环的起点
     * @param root
     * @return
     */
    public ListNode getCycleStart(ListNode root){
        ListNode fast,slow;
        fast = slow = root;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                break;
            }
        }
        slow = root;
        while (fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode mid(ListNode root){
        ListNode fast,slow;
        fast = slow = root;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }





    public class ListNode{
        int val;
        ListNode next;
    }



    //左右指针

    public int twoSearch(int[] nums,int target){
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] > target){
                right = mid - 1;
            }
            if(nums[mid] < target){
                left = mid + 1;
            }
            if(nums[mid] == target){
                return mid;
            }
        }
        return -1;
    }

    public int[] twoSum(int[] nums,int target){
        int left = 0;
        int right = nums.length -1;
        while (left < right){
            int sum = nums[left] + nums[right];
            if(sum == target){
                return new int[]{left+1,right+1};
            }
            if(sum > target){
                right--;
            }
            if(sum < target){
                left--;
            }
        }
        return new int[]{-1,-1};
    }

    public int[] reverse(int[] nums){
        int left = 0;
        int right = nums.length -1;
        while (left < right){
            int tem = nums[left];
            nums[left] = nums[right];
            nums[left] = tem;
            left++;
            right--;
        }
        return nums;
    }


}
