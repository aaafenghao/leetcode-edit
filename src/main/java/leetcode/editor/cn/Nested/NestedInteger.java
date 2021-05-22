package leetcode.editor.cn.Nested;

import java.util.List;

/**
 * 存储的数据要么是val,要么是list
 */
public class NestedInteger {

    public Integer val;

    public List<NestedInteger> list;

    public NestedInteger(Integer val){
        this.val = val;
        this.list = null;
    }

    public NestedInteger(List<NestedInteger> list){
        this.list = list;
        this.val = null;
    }

    public boolean isInteger(){
        return val != null;
    }

    public Integer getInteger(){
        return this.val;
    }

    public List<NestedInteger> getList(){
        return list;
    }
}
