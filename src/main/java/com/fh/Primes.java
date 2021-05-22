package com.fh;

import java.util.Arrays;

/**
 * 素数计算
 */
    public class Primes {

        public int countPrimes(int count){
            Boolean[] isPrimes = new Boolean[count];
            Arrays.fill(isPrimes,true);
            //i*i是因为下边已经计算过了
            for (int i = 2; i * i < count ; i++) {
                if(isPrimes[i]){
                    for (int j = i * i; j < count; j =+i) {
                        isPrimes[j] = true;
                    }
                }
            }
            int num = 0;
            for (int i = 2; i < count; i++) {
                if(isPrimes[i]) num++;
            }
            return num;
        }
}
