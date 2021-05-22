package leetcode.editor.cn;


public class Waiguanshulie {

    public static void main(String[] args) {
        Waiguanshulie demo = new Waiguanshulie();
        demo.print(5);
    }

    public void print(int n){
        String pre = "1";//base case
        for (int i = 0; i < n; i++) {
            if(pre.length() == 1){
                pre = "11";
                System.out.println(pre);
                continue;
            }
            char first = pre.charAt(0);
            StringBuffer str = new StringBuffer();
            int count = 1;
            for (int j = 1; j < pre.length(); j++) {
                char item = pre.charAt(j);
                if(item == first){
                    count++;
                }else{
                    count = 1;
                    str.append(count).append(first);
                    first = item;
                }
            }
            str.append(count).append(first);
            System.out.println(str.toString());
            pre = str.toString();
        }
    }
}
