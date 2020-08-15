package leetcode.editor.cn;

public class MaxPQ {
    //存储元素
    private String[] pq;
    //元素数量
    private int n;

    public MaxPQ(int cap){
        //索引0不用,索引多分配一个空间
        pq = new String[cap+1];
    }
    //返回当前堆中的最大元素
    public String max(){
        return pq[1];
    }
    //插入元素
    public void insert(String key){
        n++;
        pq[n] = key;
        swim(n);
    }
    //插入并返回最大元素
    public String delMax(){
        String max = pq[1];
        exch(1,n);
        pq[n] = null;
        n--;
        sink(1);
        return max;
    }
    //上浮第k个元素,以维护最大堆性质
    private void swim(int k){
        //如果上浮到堆顶,就不用上浮了
        while (k > 1 && less(parent(k),k)){
            exch(parent(k),k);
            k = parent(k);
        }
    }
    //下浮第k个元素,以维护最大堆性质
    private void sink(int k){
        while (left(k) <=n){
            int older = left(k);
            if(right(k) <=n && less(older,right(k))){
                older = right(k);
            }
            if(less(older,k)){
                break;
            }
            exch(k,older);
            k = older;
        }
    }
    //交换数组的两个元素
    private void exch(int i,int j){
        String tem = pq[i];
        pq[i] = pq[j];
        pq[j] = tem;
    }

    private boolean less(int i,int j){
        return pq[i].compareTo(pq[j]) < 0;
    }

    private int parent(int root){
        return root /2;
    }

    private int left(int root){
        return root *2;
    }

    private int right(int root){
        return root * 2 +1;
    }



}
