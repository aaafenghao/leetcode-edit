package com.fh;

import java.util.Random;

/**
 * 如何在无限序列中随机抽取元素
 *
 * 水塘抽样算法
 */
public class RandomSelectedElement {


    int[] getRandom(ListNode root,int k){
        Random random = new Random();
        int[] res = new int[k];
        ListNode p = root;

        for (int i = 0; i < k && p != null; i++) {
            res[i] = p.val;
            p = p.next;
        }

        int i = k;
        while (p != null){
            int j = random.nextInt(++i);
            if(j < k){
                res[j] = p.val;
            }
            p = p.next;
        }
        return res;

    }



    class ListNode {
        int val;
        ListNode next;
    }
}
