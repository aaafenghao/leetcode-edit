package com.fh;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 信封嵌套问题
 * 给你信封的宽和高
 *
 *  最多能嵌套几个信封
 *
 *  先对宽做升序,相同的话,高做降序
 *
 *  然后求高的最长增长子序列
 */
public class Envelope {

    public static void main(String[] args) {

    }

    public void maxEnvelope(List<Node> root){
        root.sort((a,b) ->{
            int A = a.wide;
            int B = b.wide;
            int AA = a.height;
            int BB = b.height;
            if(A > B){
                return 1;
            }
            if(A < B){
                return -1;
            }
            if(A == B){
                if(AA > BB){
                    return -1;
                }
                if(AA < BB){
                    return 1;
                }
                if(AA == BB){
                    return 0;
                }
            }
            return 0;

        });
        List<Integer> list = new ArrayList();
        for (int i = 0; i < root.size(); i++) {
            list.add(root.get(i).height);
        }
        Integer[] array = new Integer[list.size()];
        list.toArray(array);

    }
    //8 3 4 2 7 4
    public int lengthOfLIS(int[] nums){
        int piles = 0,n=nums.length;
        int[] top = new int[n];
        for (int i = 0; i < n; i++) {
            int poker = nums[i];
            int left = 0,right = piles;
            while (left < right){
                int mid = (left + right)/2;
                if(top[mid] >=poker){
                    right = mid;
                }else{
                    left = mid+1;
                }
            }
            if(left == piles){
                piles++;
            }
            top[left] = poker;
        }
        return piles;
    }

    class Node{
        public int wide;
        public int height;

        public int getWide() {
            return wide;
        }

        public void setWide(int wide) {
            this.wide = wide;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }
    }
}
