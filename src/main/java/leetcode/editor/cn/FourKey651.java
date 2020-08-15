package leetcode.editor.cn;

public class FourKey651 {

    public static void main(String[] args) {

    }

    //两种方式
    //1.一直按A键
    //2.当按键A次数足够大的时候,按CA CC CV
    public int maxA(int N){
        int[] dp = new int[N+1];
        dp[0] = 0;
        for (int i = 1; i <=N ; i++) {
            //按 A 键
            dp[i] = dp[i-1] + 1;
            for (int j = 2; j < i ; j++) {
                //全选 & 复制 dp[j-2] 连续粘贴i-j次
                //屏幕上共dp[j-2] * (i-j+1)个A
                dp[i] = Math.max(dp[i],dp[j-2] * (i-j+1));
            }
        }
        //N次键之后最多有几个A
        return dp[N];
    }

    //n--剩余的按键次数
    //a_num--当前屏幕上字符A的数量
    //copy剪切板上字符A的数量
    public int maxA1(int n,int a_num,int copy){
        if(n <= 0){
            return a_num;
        }
        int maxA = Math.max(
                maxA1(n-1,a_num+1,copy) ,//A
                Math.max(
                        maxA1(n-1,a_num + copy,copy),//CV
                        maxA1(n-2,a_num,a_num)//CA CC
                )
        );
        return maxA;
    }


}
