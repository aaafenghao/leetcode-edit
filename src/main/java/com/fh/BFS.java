package com.fh;

import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.LinkedBlockingDeque;

public class BFS {

    int BFS(Node start,Node target){
        Queue<Node> q = new LinkedBlockingDeque<>();
        Set<Node> visited =  new HashSet<>();
        q.offer(start);
        visited.add(start);

        int step = 0;
        return 0;
    }

    class Node{

    }
}
