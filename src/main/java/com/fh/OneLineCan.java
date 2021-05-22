package com.fh;

/**
 * 一行代码解决问题
 */
public class OneLineCan {

    /**
     * Nim游戏
     *
     * 面前有一堆石子，最少哪一个，最多哪三个，谁拿到最后一个谁就赢
     *
     * 你第一个拿
     * @param n
     * @return
     */
    public boolean canWinNim(int n){

        return n % 4 != 0;
    }




}
