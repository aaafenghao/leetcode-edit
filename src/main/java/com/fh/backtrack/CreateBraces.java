package com.fh.backtrack;

import java.util.LinkedList;

public class CreateBraces {

    public void backtrack(int left, int right, LinkedList<String> track,LinkedList<LinkedList> res){
        if(right < left){
            return;
        }
        if(left < 0 || right < 0){
            return;
        }
        if(left == 0 && right == 0){
            res.add(track);
            return;
        }
        track.add("(");
        backtrack(left-1,right,track,res);
        track.removeLast();

        track.add(")");
        backtrack(left,right-1,track,res);
        track.removeLast();
    }
}
