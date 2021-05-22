package com.fh.backtrack;

import java.util.Arrays;

public class EightQueen {


    char[][] solveNQueen(int n){
        char[][] result = new char[n][n];
        Arrays.fill(result,'.');
        backtrace(result,n);
        return result;
    }

    public void backtrace(char[][] board,int row){
        if(row == board.length){
            return;
        }
        int n = board[row].length;
        for (int col = 0; col < n; col++) {
            if(!isValid(board,row,col)){
                continue;
            }
            board[row][col] = 'Q';
            backtrace(board,row+1);
            board[row][col] = '.';
        }
    }

    public boolean isValid(char[][] board,int row,int col){
        int n = board.length;
        //检查列是否有冲突
        for (int i = 0; i <n ; i++) {
            if(board[i][col] == 'Q'){
                return false;
            }
        }
        //检查右上是否有冲突
        for (int i = row-1,j=col+1; i >=0 && j < n  ; i--,j++) {
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        for (int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        return true;

    }
}
