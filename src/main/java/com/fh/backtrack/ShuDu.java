package com.fh.backtrack;

public class ShuDu {

    public void backtrack(char[][] board,int i,int j){
        int m = 9,n=9;
        if(j == n){
            backtrack(board,i+1,j);
            return;
        }
        if(board[i][j] != '.'){
            backtrack(board,i,j+1);
            return;
        }
        for (char ch = '0';ch <= '9';ch++) {
            if(!isValid(board,i,j,ch)){
                continue;
            }
            board[i][j] = ch;
            backtrack(board,i,j+1);
            board[i][j] = '.';
        }

    }

    public boolean isValid(char[][] board,int i,int j ,char n){
        for (int k = 0; k < 9; k++) {
            if(board[i][k] == n){
                return false;
            }
            if(board[k][j] == n){
                return false;
            }
            if(board[(i/3)*3+i/3][(j/3)*3+j%3] == n){
                return false;
            }
        }
        return true;
    }
}
