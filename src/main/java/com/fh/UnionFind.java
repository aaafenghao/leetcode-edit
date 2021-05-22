package com.fh;

/**
 * 并查集算法
 *
 *  感觉像图论
 *
 */
public class UnionFind {


    /**
     * 提供一个二维棋盘,找出四面都被X包围的o,并且替换成X
     *
     * 使用Union-find 提供一个虚拟节点
     * 二维转换成一维
     * @param board
     */
    void solve(char[][] board) {
        if(board.length == 0){
            return;
        }
        int m = board.length;
        int n = board[0].length;
        UF uf = new UF( m * n + 1);
        int dummy = m * n;
        //将首列和末列的O和dummy连通
        for (int i = 0; i < m; i++) {
            if(board[i][0] == 'o'){
                uf.union(i * n,dummy);
            }
            if(board[i][n-1] == 'o'){
                uf.union(i * n + n-1,dummy);
            }
        }
        //将首行和末行的o和dummy连通
        for (int j = 0; j < n; j++) {
            if(board[0][j] == 'o'){
                uf.union(j,dummy);
            }
            if(board[m-1][j] == 'o'){
                uf.union(n * (m-1) + j,dummy);
            }
        }
        int[][] d = new int[][]{{1,0},{0,1},{0,-1},{-1,0}};
        for (int i = 1; i < m-1; i++) {
            for (int j = 1; j < n-1; j++) {
                if(board[i][j] == 'o'){
                    for (int k = 0; k < 4; k++) {
                        int x = i + d[k][0];
                        int y = j + d[k][1];
                        if(board[x][y] == 'o'){
                            uf.union(x * n + y,i * n + j);
                        }
                    }
                }
            }
        }

        for (int i = 1; i < m-1; i++) {
            for (int j = 1; j < n-1; j++) {
                if(!uf.connected(dummy,i * n + j)){
                    board[i][j] = 'X';
                }
            }
        }


    }


    boolean equationsPossible(String[] equations) {
        UF uf = new UF(26);
        for (String eq:equations){
            if(eq.charAt(1) == '='){
                char x = eq.charAt(0);
                char y = eq.charAt(3);
                uf.union(x - 'a',y-'a');
            }
        }
        for (String eq:equations){
            if(eq.charAt(1) == '!'){
                char x = eq.charAt(0);
                char y = eq.charAt(3);
                if(uf.connected(x - 'a',y - 'a')){
                    return false;
                }
            }
        }
        return true;
    }




    class UF{
        //连通分量个数
        private int count;
        //存储一棵树
        private int[] parent;
        //记录树的重量
        private int[] size;

        public UF(int n){
            this.count = n;
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public void union(int p,int q){
            int rootp = find(p);
            int rootq = find(q);
            if(rootp == rootq){
                return;
            }
            //将小树接到大树下面,这样比较平衡
            if(size[rootp] > size[rootq]){
                parent[rootq] = rootp;
                size[rootp] += size[rootq];
            }else {
                parent[rootp] = rootq;
                size[rootq] += size[rootp];
            }
        }

        public boolean connected(int p,int q){
            int i = find(p);
            int i1 = find(q);
            return i == i1;
        }

        public int find(int x){
            while (parent[x] != x){
                //进行路径压缩
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public int count(){
            return this.count;
        }
    }


}
