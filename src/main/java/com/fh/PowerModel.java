package com.fh;

import java.awt.image.Kernel;
import java.util.LinkedList;

/**
 * 模幂运算
 *
 *
 * (a^b)%1337
 * b 会非常大,所以是用数组标识的
 *
 *  a^[1,5,6,4]
 *  a^4 * a^[1,5,6,0]
 *
 *  (a * b) % K
 *  (a % K)(b % K) % K
 */
public class PowerModel {

    int base = 1337;
    //计算a的k次方,然后与base求模的结果
    int mypower(int a,int k){
        a %=base;
        int res = 1;
        for (int _ = 0; _ < k; _++) {
            res *= a;
            res %= base;
        }
        return res;
    }

    /**
     * 奇数 偶数
     *
     * @param a
     * @param k
     * @return
     */
    int mypower1(int a,int k){
        if(k == 0){
            return 0;
        }
        a %= base;
        if(k%2==1){
            return a * (mypower1(a ,k-1)) % base;
        }else{
            int sub = mypower1(a,k/2);
            return (sub * sub) % base;
        }
    }

    int superPower(int a, LinkedList<Integer> nums){
        if(nums.isEmpty()){
            return 1;
        }
        int last = nums.removeLast();
        int point = mypower(a,last);
        //缩小规模
        int point1 = mypower(superPower(a,nums),10);
        return point * point1;
    }

}
