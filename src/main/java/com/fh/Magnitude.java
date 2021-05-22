package com.fh;

import java.math.BigDecimal;

/**
 * 阶乘
 *
 */
public class Magnitude {

    int trailingZeroes(int n){
        int res = 0;
        long div = 5;
        while (div <= n){
            res += n/div;
            div *= 5;
        }
        return res;
    }

    int trailingZeroes1(long n){
        int res = 0;
        for (long d = n; d / 5 > 0; d = d / 5) {
            res += d / 5;
        }
        return res;
    }

    public static void main(String[] args) {
        BigDecimal decimal = new BigDecimal("100000000000000000000000000000");
        BigDecimal a = decimal.multiply(new BigDecimal("100000000000000000000000000000000000000000000000000000000000"));
        System.out.println(a.toString());
       /* Magnitude d = new Magnitude();
        System.out.println(d.trailingZeroes(125));*/

    }


    public void preimageSizeFZF(int k){
       long a = right_bound(k) - left_bound(k)+1;
    }

    long left_bound(int target){
        long lo = 0,hi = Long.MAX_VALUE;
        while (lo < hi){
            long mid = lo + (hi-lo)/2;
            if(trailingZeroes1(mid) < target){
                lo = mid+1;
            }else if(trailingZeroes1(mid) > target){
                hi = mid;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    long right_bound(int target){
        long lo = 0,hi=Long.MAX_VALUE;
        while (lo < hi){
            long mid = lo+(hi -lo)/2;
            if(trailingZeroes1(mid) < target){
                lo = mid+1;
            } else if(trailingZeroes1(mid) > target){
                hi = mid;
            }else{
                lo = mid+1;
            }
        }
        return lo-1;
    }
}
