package leetcode.editor.cn.lfu;

import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * 最近使用次数最少淘汰算法
 */
public class LFUCache {
    //key--value映射
    private HashMap<Integer,Integer> keyToVal;
    //key--freq频率映射
    private HashMap<Integer,Integer> keyToFreq;
    //freq--keys映射
    private HashMap<Integer, LinkedHashSet<Integer>> freqsToKeys;
    //最小频率记录
    int minFreq;
    //容量
    int cap;

    public LFUCache(int cap){
        keyToVal = new HashMap<>();
        keyToFreq = new HashMap<>();
        freqsToKeys = new HashMap<>();
        this.cap = cap;
        this.minFreq = 0;
    }

    public int get(int key){
        if(!keyToVal.containsKey(key)){
            return -1;
        }
        increaseFreq(key);
        return keyToVal.get(key);
    }

    public void put(int key,int value){
        if(cap <=0){
            return;
        }
        if(keyToVal.containsKey(key)){
            keyToVal.put(key,value);
            increaseFreq(key);
            return;
        }
        if(this.cap <= keyToVal.size()){
            removeMinFreqKey();
        }
        keyToVal.put(key,value);
        keyToFreq.put(key,1);
        freqsToKeys.putIfAbsent(1,new LinkedHashSet<>());
        freqsToKeys.get(1).add(key);
        this.minFreq = 1;
    }

    public void increaseFreq(int key){
        Integer freq = keyToFreq.get(key);
        keyToFreq.put(key,freq+1);

        freqsToKeys.get(freq).remove(key);

        freqsToKeys.putIfAbsent(key,new LinkedHashSet<>());
        freqsToKeys.get(freq+1).add(key);
        //如果数据被清空,需要注意最小频次的变化
        if(freqsToKeys.get(freq).isEmpty()){
            freqsToKeys.remove(key);
            if(freq == minFreq){
                this.minFreq++;
            }
        }
    }

    public void removeMinFreqKey(){
        LinkedHashSet<Integer> integers = freqsToKeys.get(minFreq);
        //最先被插入的key被删除
        Integer next = integers.iterator().next();
        integers.remove(next);
        if(integers.isEmpty()){
            freqsToKeys.remove(minFreq);
            //需要更新最小频次么
        }
        keyToVal.remove(next);
        keyToFreq.remove(next);
    }



}
