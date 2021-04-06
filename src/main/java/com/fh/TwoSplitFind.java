package com.fh;

import java.util.ArrayList;

/**
 * 二分查找的高效判定子序列
 *
 *
 */
public class TwoSplitFind {

    boolean isSubsequence(String s, String t) {
        int m = s.length(), n = t.length();
        ArrayList<Integer>[] index = new ArrayList[256];
        for (int i = 0; i < n ; i++) {
            char c = t.charAt(i);
            if(index[c] == null){
                index[c] = new ArrayList<>();
            }
            index[c].add(i);
        }
        int j = 0;
        for (int i = 0; i < m; i++) {
            char c = s.charAt(i);
            if(index[c] == null){
                return false;
            }
            int pos = left_bound(index[c],j);
            if(pos == index[c].size()){
                return false;
            }
            j = index[c].get(pos) + 1;
        }

        return true;
    }

    private int left_bound(ArrayList<Integer> index, int j) {
        int n = index.size();
        int left = 0;
        int right = index.size() - 1;
        while (left <= right){
            int mid = left + (right - left)/2;
            if(mid > j){

            }
        }
        return 0;
    }
}
