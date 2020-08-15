package leetcode.editor.cn.lru;

import java.util.Scanner;
/**
 * @ClassName
 * @Description TODO
 * @Author Administrator
 * @Date 2020-08-10 15:51
 **/
public class Test {
    //判断素数
    private boolean is_prime(int x){
        if(x>1){
            if(x<4){	// 2,3 素数
                return true;
            }else{
                for(int i=2;i<=Math.sqrt(x);i+=1){
                    if(x%i==0) return false;
                }
                return true;
            }
        }

        return false;
    }


    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        Test nyoj=new Test();
        int n=scan.nextInt(2);	//组数
        System.out.println(n);
        for(int i=0;i<n;i++){
            int m=scan.nextInt();
            if(m<0) break;
            if(nyoj.is_prime(m)){
                System.out.println(m+" "+0); continue;
            }
            // 距离
            int d=(m%2==0)?1:0;
            //特例：1 不是素数
            if(m==1){
                System.out.println("2 1");
            }else{
                while(true){
                    int min=m-d;
                    int max=m+d;
                    if(nyoj.is_prime(min)){
                        System.out.println(min+" "+d);	break;
                    }else{
                        if(nyoj.is_prime(max)){
                            System.out.println(max+" "+d);	break;
                        }
                    }
                    d+=2;
                }
            }

        }
        scan.close();
    }
}
