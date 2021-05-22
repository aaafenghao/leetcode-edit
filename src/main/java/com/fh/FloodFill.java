package com.fh;

/**
 * 染色,扫雷
 * 不知道叫啥
 */
public class FloodFill {

    int[][] floodFill(int[][] image,int sr,int sc,int newColor){
        int origColor = image[sr][sc];
        fill(image,sr,sc,origColor,newColor);
        return null;
    }

    public void fill(int[][] image,int sr,int sc,int origColor,int newColor){
        if(!isArea(image,sr,sc)){
            return;
        }
        if(image[sr][sc] != origColor){
            return;
        }
        if(image[sr][sc] == -1){
            return;
        }
        image[sr][sc] = -1;
        fill(image,sr,sc+1,origColor,newColor);
        fill(image,sr,sc-1,origColor,newColor);
        fill(image,sr+1,sc,origColor,newColor);
        fill(image,sr-1,sc,origColor,newColor);
        image[sr][sc] = newColor;
    }

    public boolean isArea(int[][] image,int x,int y){
        return x>=0 && x<=image.length && y>=0 && y<=image[0].length;
    }
}
