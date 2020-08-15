package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;

public class BFS {

    int bfs(Node start,Node target){
        Queue<Node> q = new LinkedBlockingQueue<>();//核心数据结构
        Set<Node> visted = new HashSet<>();//避免走回头路

        q.add(start);//将起点加入队列
        visted.add(start);

        int step = 0;//记录扩散的步数
        while (!q.isEmpty()){
            int size = q.size();
            //将当前队列中的节点相四周扩散
            for (int i = 0; i < size ; i++) {
                Node cur = q.poll();
                //* 这里判断是否到达终点
                if(cur.equals(target)){
                    return step;
                }
                //将cur相邻节点添加到队列中
                if(!visted.contains(cur.next)){
                    q.offer(cur.next);
                    visted.add(cur.next);
                }
            }
            //** 更新步数在这里
            step++;
        }
        return step;
    }

    class Node{
        Node next;
    }
}
