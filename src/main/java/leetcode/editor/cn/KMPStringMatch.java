package leetcode.editor.cn;

/**
 *
 * KMP--算法
 * 字符串匹配算法
 *
 */
public class KMPStringMatch {

    private String pat;

    private int[][] dp;


    /**
     * dp[j][c] = next
     * 0<= j < M 代表当前状态
     * 0<= c < 256 代表遇到的字符(ASCII 码)
     * 0<= next <= M 代表下一个状态
     *
     * dp[4]['A'] = 3
     * 当前状态是4,遇到字符串A
     * pat状态应转移到状态3
     *
     * dp[1]['B'] = 2
     * 当前状态是1,遇到字符串B
     * pat状态转移到状态2
     *
     * 
     */
    public KMPStringMatch(String pat){
        this.pat = pat;
        int M = pat.length();
        //dp[状态][字符] = 下一个状态
        dp = new int[M][256];
        //base case 第一个字母匹配,状态推进到1
        dp[0][pat.charAt(0)] = 1;
        //影子状态X初始化为0
        int X = 0;
        //当前状态i从1开始
        //构建状态图
        //-> A-> B-> A-> B-> C->
        //1--B状态推进,其他都是0,X=0
        //2--A状态推进,其他都是0,X=1
        //3--B状态推进,其他都是0,X=2
        for (int i = 1; i < M; i++) {
            for (int j = 0  ; j < 256; j++) {
                if(pat.charAt(i) == j){//状态推进
                    dp[i][j] = i+1;
                } else {//状态回退
                    dp[i][j] = dp[X][j];
                }
            }
            //更新影子状态
            X = dp[X][pat.charAt(i)];
        }
    }



    public int search(String text){
        int M = pat.length();
        int N = text.length();
        //pat的初始状态为0
        int j=0;
        for (int i = 0; i < N; i++) {
            //当前状态是j,遇到字符text[i]
            //pat应该转移到哪个状态
            j = dp[j][text.charAt(i)];
            //如果达到终止态,返回匹配开头的索引
            if(j == M){
                return i-M +1;
            }
        }
        //没到达终止态,匹配失败
        return -1;
    }
}
