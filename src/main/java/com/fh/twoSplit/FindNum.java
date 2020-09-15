package com.fh.twoSplit;

public class FindNum {

    public Integer find(int[] nums,int target){
        int left = 0;
        int right = nums.length - 1;
        while (left <=right){
            int mid = left+(right-left)/2;
            if(nums[mid] == target){
                return nums[mid];
            }
            if(nums[mid] > target){
                right = mid - 1;
            }
            if(nums[mid] < target){
                left = mid + 1;
            }
        }
        return -1;
    }

    //左边界
    public Integer left_find(int[] nums,int target){
        int left = 0;
        int right = nums.length-1;
        while (left <= right){
            int mid = left+(right-left)/2;
            if(nums[mid] == target){
                right = mid -1;
            }
            if(nums[mid] > target){
                right = mid -1;
            }
            if(nums[mid] < target){
                left = mid+1;
            }

        }
        if(left >= nums.length || nums[left] != target){
            return -1;
        }
        return left;
    }

    public Integer right_find(int[] nums,int target){
        int left = 0;
        int right = nums.length -1;
        while (left <= right){
            int mid = left+(right-left)/2;
            if(nums[mid] > target){
                right = mid-1;
            }
            if(nums[mid] < target){
                left = mid + 1;
            }
            if(nums[mid] == target){
                left = mid +1;
            }
        }
        if(right < 0 || nums[right] != target){
            return -1;
        }
        return right;
    }
}
